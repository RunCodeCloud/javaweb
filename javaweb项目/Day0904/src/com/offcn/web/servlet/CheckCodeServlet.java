package com.offcn.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 生成图片的高度和宽度
		int height = 30;
		int width = 60;
		
		//从这个字符串中选几个字符组成图片的内容
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		Random random = new Random();
		
		//2 创建一个图片
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//3 获得画板
		Graphics g = image.getGraphics();
		
		
		//4 填充一个矩形
		// * 设置颜色
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
				
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, width-2, height-2);
		// * 设置字体
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 25));
		
		String checkcode = "";
		
		for(int i = 0 ; i < 4 ; i ++){
			
			// 设置颜色--随机数
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			
			// 获得随机字
			int index = random.nextInt(data.length());
			String str = data.substring(index, index + 1);
			checkcode+=str;  // 把四个随机字符拼成字符串
			// 写入
			g.drawString(str, width/6 * (i + 1), 20);
		}
		request.getSession().setAttribute("checkcode", checkcode);
		
		//6 干扰线
		for(int i = 0 ; i < 3 ; i ++){
			// 设置颜色--随机数
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// 随机绘制线
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width),random.nextInt(height));
			// 随机点
			g.drawOval(random.nextInt(width), random.nextInt(height), 2, 2);
		}
		
		//end 将图片响应给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

}
