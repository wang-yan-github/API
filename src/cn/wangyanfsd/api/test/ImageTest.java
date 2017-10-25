package cn.wangyanfsd.api.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wangyanfsd.api.util.DBUtil;
import cn.wangyanfsd.api.util.ImageUtil;

/**
 * @author wangy
 * @javaDoc 测试写入数据库以及从数据库中读取
 *
 */
public class ImageTest {

	// 将图片插入数据库
    public static void readImage2DB() {
        String path = "C:/Users/Administrator/Desktop/行政处罚流程.png";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into tb_bslccflc (name,content,date)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "行政处罚流程.png");
            ps.setBinaryStream(2, in, in.available());
            ps.setString(3, "2017-10-10");
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 读取数据库中图片
    public static void readDB2Image() {
        String targetPath = "D:/image/1.png";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from tb_bslccflc where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("content");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //测试
    public static void main(String[] args) {
        //readImage2DB();
        readDB2Image();
    }
}
