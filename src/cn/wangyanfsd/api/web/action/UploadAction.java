package cn.wangyanfsd.api.web.action;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.BslcCflc;
import cn.wangyanfsd.api.bean.BslcJclc;
import cn.wangyanfsd.api.bean.BslcXklc;
import cn.wangyanfsd.api.bean.BslcZzlc;
import cn.wangyanfsd.api.bean.FjLbt;
import cn.wangyanfsd.api.bean.FjQdym;
import cn.wangyanfsd.api.bean.FjRmjx;
import cn.wangyanfsd.api.service.BslcCflcService;
import cn.wangyanfsd.api.service.BslcJclcService;
import cn.wangyanfsd.api.service.BslcXklcService;
import cn.wangyanfsd.api.service.BslcZzlcService;
import cn.wangyanfsd.api.service.FjLbtService;
import cn.wangyanfsd.api.service.FjQdymService;
import cn.wangyanfsd.api.service.FjRmjxService;
import cn.wangyanfsd.api.service.impl.BslcCflcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcJclcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcXklcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcZzlcServiceImpl;
import cn.wangyanfsd.api.service.impl.FjLbtServiceImpl;
import cn.wangyanfsd.api.service.impl.FjQdymServiceImpl;
import cn.wangyanfsd.api.service.impl.FjRmjxServiceImpl;
import cn.wangyanfsd.api.util.FileTools;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;

public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private HttpServletRequest request;
	Map<Object, Object> map;
	private String message;
	
	private String choice;
	private String id;
	private String url;
	private String time;
	private String title;
	private String content;
	private String type;
	private String filename;
	private String fileType;

	private static byte[] subBytes(byte[] b, int from, int end) {
		byte[] result = new byte[end - from];
		System.arraycopy(b, from, result, 0, end - from);
		return result;
	}

	/**
	 * ��λ��ǰͷ��Ϣ�Ľ���λ��
	 * 
	 * @param bytes
	 * @param start
	 *            :��ʼλ��
	 * @param end
	 *            :����λ��
	 * @param endStr
	 *            :�Ƚ��ַ���
	 * @return TODO
	 */
	public int locateEnd(byte[] bytes, int start, int end, String endStr) {
		byte[] endByte = endStr.getBytes();
		for (int i = start + 1; i < end; i++) {
			if (bytes[i] == endByte[0]) {
				int k = 1;
				while (k < endByte.length) {
					if (bytes[i + k] != endByte[k]) {
						break;
					}
					k++;
				}
				if (i == 3440488) {
					//System.out.println("start");
				}
				// ���ؽ������Ŀ�ʼλ��
				if (k == endByte.length) {
					return i;
				}
			}
		}

		return 0;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/API/UploadAction?choice=UploadFind&Location=ceshi.png
		this.request = request;
		request.setCharacterEncoding("UTF-8");
        String UploadFind = request.getParameter("choice");
        if ("UploadFind".equals(UploadFind)) {
        	String localhost = request.getParameter("Location");
        	//Result r = new Result("/WEB-INF/upload/" + localhost);
    		//response.sendRedirect(r.getPath());
    		//request.getRequestDispatcher(r.getPath()).forward(request,response);
    		request.getRequestDispatcher("/WEB-INF/upload/" + localhost).forward(request,response);
    		return;
        }else{
        	uploadFile();
        }
		
		
		System.out.println("choice="+choice+",id="+id+",url="+url+",time="+time+",title="+title+",type="+type+",content="+content);
		response.sendRedirect(url);
	}

	private void uploadFile() throws ServletException, IOException {
		BufferedReader readerAttr;
		int totalBytes = request.getContentLength();
		String contentType = request.getContentType();
		int position = contentType.indexOf("boundary=");

		String startBoundary = "--" + contentType.substring(position + "boundary=".length());
		String endBoundary = startBoundary + "--";
		// ��request�����������뵽bytes��
		InputStream inputStream = request.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		byte[] bytes = new byte[totalBytes];
		dataInputStream.readFully(bytes);
		dataInputStream.close();
		// ���ֽڶ��뵽�ַ�����
		BufferedReader reader = new BufferedReader(new StringReader(new String(bytes,"utf-8")));
		readerAttr = new BufferedReader(new StringReader(new String(bytes,"utf-8")));
		// ��ʼ��ȡreader(�ָ�form���ڵı�������:�ı������ļ�)

		// ��¼��ǰ�Ķ�ȡ�ж�Ӧ��bytes;
		int temPosition = 0;
		boolean flag = false;
		int end = 0;
		int index = 1;
		while (true) {
			// ����ȡһ���ļ���Ϣ��
			if (flag) {
				bytes = subBytes(bytes, end, totalBytes);
				temPosition = 0;
				reader = new BufferedReader(new StringReader(new String(bytes,"utf-8")));
				readerAttr = new BufferedReader(new StringReader(new String(bytes,"utf-8")));
			}
			// ��ȡһ�е���Ϣ:------WebKitFormBoundary5R7esAd459uwQsd5,��:lastBoundary
			String str = reader.readLine();
			String str2 = readerAttr.readLine();
			//System.out.println(str2);
			// �����������ַ�
			temPosition += str.getBytes().length + 2;
			// endBoundary:����
			if (str == null || str.equals(endBoundary)) {
				break;
			}
			if(str2.startsWith(startBoundary)){
				readerAttr.readLine();
				switch(index){
					case 1:
						readerAttr.readLine();
						choice = readerAttr.readLine();
						index++;
						break;
					case 2:
						readerAttr.readLine();
						id = readerAttr.readLine();
						index++;
						break;
					case 3:
						readerAttr.readLine();
						url = readerAttr.readLine();
						index++;
						break;
					case 4:
						readerAttr.readLine();
						time = readerAttr.readLine();
						index++;
						break;
					case 5:
						readerAttr.readLine();
						title = readerAttr.readLine();
						index++;
						break;
					case 6:
						readerAttr.readLine();
						type = readerAttr.readLine();
						index++;
						break;
					case 7:
						readerAttr.readLine();
						content = readerAttr.readLine();
						index++;
						break;
					default:
						break;
				}
			}
			// ��ʾͷ��Ϣ�Ŀ�ʼ(һ����ǩ,input,select��)
			if (str.startsWith(startBoundary)) {
				// �жϵ�ǰͷ��Ӧ�ı�������

				str = reader.readLine(); // ��ȡ��ǰͷ��Ϣ����һ��:Content-Disposition��
				
				temPosition += str.getBytes().length + 2;

				int position1 = str.indexOf("filename="); // �ж��Ƿ����ļ��ϴ�
				
				// such as:Content-Disposition: form-data; name="fileName";
				// filename="P50611-162907.jpg"
				if (position1 == -1) {// ��ʾ����ͨ�ı����ϴ�

				} else {// position1!=-1,��ʾ���ļ��ϴ�
						// ������ǰ�ϴ����ļ���Ӧ��name(input��ǩ��name),�Լ�fieldname:�ļ���
					int position2 = str.indexOf("name=");
					// ȥ��name��filename֮���"��;�Լ��ո�
					String name = str.substring(position2 + "name=".length() + 1, position1 - 3);
					// ȥ������"
					filename = str.substring(position1 + "filename=".length() + +1, str.length() - 1);
					fileType = str.substring(str.lastIndexOf(".")+1,str.length() - 1);

					// ��ȡ��,such as:Content-Type: image/jpeg,��¼�ֽ���,�˴����λ���
					temPosition += (reader.readLine().getBytes().length + 4);
					end = this.locateEnd(bytes, temPosition, totalBytes, endBoundary);
					String path = request.getSession().getServletContext().getRealPath("/");
					DataOutputStream dOutputStream = new DataOutputStream(
							new FileOutputStream(new File(path + "/WEB-INF/upload/"+time+"."+fileType)));
					dOutputStream.write(bytes, temPosition, end - temPosition - 2);
					dOutputStream.close();

					flag = true;

				}
			}
		}
		
		FjLbtService fjLbtService = (FjLbtService)new TransactionUtil().newProxy(new FjLbtServiceImpl());
		FjRmjxService fjRmjxService = (FjRmjxService)new TransactionUtil().newProxy(new FjRmjxServiceImpl());
		FjQdymService fjQdymService = (FjQdymService)new TransactionUtil().newProxy(new FjQdymServiceImpl());
		BslcCflcService bslcCflcService = (BslcCflcService)new TransactionUtil().newProxy(new BslcCflcServiceImpl());
		BslcJclcService bslcJclcService = (BslcJclcService)new TransactionUtil().newProxy(new BslcJclcServiceImpl());
		BslcXklcService bslcXklcService = (BslcXklcService)new TransactionUtil().newProxy(new BslcXklcServiceImpl());
		BslcZzlcService bslcZzlcService = (BslcZzlcService)new TransactionUtil().newProxy(new BslcZzlcServiceImpl());
		if(!"".equals(type) && type != null && "FjLbtAction".equals(type)){
			
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(title)&&title!=null&&!"".equals(time)&&time!=null){
	        	FjLbt fjLbt = fjLbtService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",fjLbt.getContent());
	        	fjLbt.setId(Integer.parseInt(id));
	            fjLbt.setTitle(title);
	            fjLbt.setContent(time+"."+fileType);
	            fjLbt.setDate(time);
	            fjLbt.setPerson("����Ա");
	            fjLbtService.update(fjLbt);
	        }else if(!"".equals(title)&&title!=null&&!"".equals(time)&&time!=null){
	        	FjLbt fjLbt = new FjLbt();
	        	fjLbt.setTitle(title);
	        	fjLbt.setContent(time+"."+fileType);
	            fjLbt.setDate(time);
	            fjLbt.setPerson("����Ա");
	            fjLbtService.save(fjLbt);
	        }
		}else if(!"".equals(type) && type != null && "FjRmjxAction".equals(type)){
			
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)){
	        	FjRmjx fjRmjx = fjRmjxService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",fjRmjx.getImage());
	        	fjRmjx.setId(Integer.parseInt(id));
	        	fjRmjx.setImage(time+"."+fileType);
	            fjRmjxService.update(fjRmjx);
	        }else  if(!"".equals(title)&&title!=null&&!"".equals(time)&&time!=null&&!"".equals(content)&&content!=null){
	        	FjRmjx fjRmjx = new FjRmjx();
	        	fjRmjx.setTitle(title);
	        	fjRmjx.setContent(content);
	        	fjRmjx.setImage(time+"."+fileType);
	        	fjRmjx.setDate(format.format(new Date()));
	        	fjRmjx.setPerson("����Ա");
	            fjRmjxService.save(fjRmjx);
	        }
		}else if(!"".equals(type) && type != null && "FjQdymAction".equals(type)){
			System.out.println(id);
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(title)&&title!=null&&!"".equals(time)&&time!=null){
	        	FjQdym fjQdym = fjQdymService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",fjQdym.getContent());
	        	fjQdym.setId(Integer.parseInt(id));
	        	fjQdym.setTitle(title);
	        	fjQdym.setContent(time+"."+fileType);
	        	fjQdym.setDate(time);
	        	fjQdym.setPerson("����Ա");
	        	fjQdymService.update(fjQdym);
	        }else  if(!"".equals(title)&&title!=null&&!"".equals(time)&&time!=null){
	        	FjQdym fjQdym = new FjQdym();
	        	fjQdym.setTitle(title);
	        	fjQdym.setContent(time+"."+fileType);
	        	fjQdym.setDate(time);
	        	fjQdym.setPerson("����Ա");
	        	fjQdymService.save(fjQdym);
	        }
		}else if(!"".equals(type) && type != null && "BslcXklcAction".equals(type)){
			
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(time)&&time!=null){
	        	BslcXklc bslcXklc = bslcXklcService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",bslcXklc.getContent());
	        	bslcXklc.setTitle(time);
	        	bslcXklc.setContent(time+"."+fileType);
	        	bslcXklc.setDate(time);
	        	bslcXklc.setPerson("����Ա");
	        	bslcXklcService.update(bslcXklc);
	        }
		}else if(!"".equals(type) && type != null && "BslcJclcAction".equals(type)){
			
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(time)&&time!=null){
	        	BslcJclc bslcJclc = bslcJclcService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",bslcJclc.getContent());
	        	bslcJclc.setTitle(time);
	        	bslcJclc.setContent(time+"."+fileType);
	        	bslcJclc.setDate(time);
	        	bslcJclc.setPerson("����Ա");
	        	bslcJclcService.update(bslcJclc);
	        }
		}else if(!"".equals(type) && type != null && "BslcCflcAction".equals(type)){
			
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(time)&&time!=null){
	        	BslcCflc bslcCflc = bslcCflcService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",bslcCflc.getContent());
	        	bslcCflc.setTitle(time);
	        	bslcCflc.setContent(time+"."+fileType);
	        	bslcCflc.setDate(time);
	        	bslcCflc.setPerson("����Ա");
	        	bslcCflcService.update(bslcCflc);
	        }
		}else if(!"".equals(type) && type != null && "BslcZzlcAction".equals(type)){
			
	        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(time)&&time!=null){
	        	BslcZzlc bslcZzlc = bslcZzlcService.find(Integer.parseInt(id));
	        	FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",bslcZzlc.getContent());
	        	bslcZzlc.setTitle(time);
	        	bslcZzlc.setContent(time+"."+fileType);
	        	bslcZzlc.setDate(time);
	        	bslcZzlc.setPerson("����Ա");
	        	bslcZzlcService.update(bslcZzlc);
	        }
		}
		

		request.setAttribute("message", message);
	}

	private Result uploadList() {
		String localhost = request.getParameter("Location");
		return new Result("/upload/" + localhost);
	}
}
