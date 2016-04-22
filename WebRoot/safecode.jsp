<%@ page autoFlush="false"  import="java.awt.*,java.awt.image.*,com.sun.image.codec.jpeg.*,java.util.*,javax.imageio.*"%>
<%@ page import="org.apache.commons.lang.RandomStringUtils"%>
<%@taglib uri="/WEB-INF/oscache.tld" prefix="cache"%>

<% 
String random=RandomStringUtils.randomNumeric(4);
session.setAttribute("safecode",random);
 %>
<%

        out.clear();
        response.setContentType("image/jpeg");
        response.addHeader("pragma","NO-cache");
        response.addHeader("Cache-Control","no-cache");
        response.addDateHeader("Expries",0);
		int width=80, height=20; 
		BufferedImage image = new BufferedImage(width, height, 
		BufferedImage.TYPE_INT_RGB); 

		Graphics g = image.getGraphics(); 
		
		g.setColor(new Color(0xDCDCDC)); 
		g.fillRect(0, 0, width, height); 
		
		g.setColor(Color.black); 
		g.drawRect(0,0,width-1,height-1); 
//        Font DeFont=new Font("SansSerif", Font.PLAIN, 18); 
//        g.setFont(DeFont);

		g.setColor(Color.black); 
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,18)); 
		String Str = random.substring(0,1); 
		g.drawString(Str,8,17); 
		Str = random.substring(1,2); 
		g.drawString(Str,20,15); 
		Str = random.substring(2,3); 
		g.drawString(Str,35,16); 
		Str = random.substring(3,4); 
		g.drawString(Str,52,15); 
		//add confusing point for security
		g.setColor(Color.red);
		Random rand = new Random(); 
		for (int i=0;i<20;i++) 
		{ 
			int x = rand.nextInt(width); 
			int y = rand.nextInt(height); 
			g.drawOval(x,y,1,1); 
		} 
        g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream()); 
		out.clear();
		out = pageContext.pushBody();
        //ServletOutputStream outStream = response.getOutputStream();
        //JPEGImageEncoder encoder =JPEGCodec.createJPEGEncoder(outStream);
        //encoder.encode(image);
        //outStream.close();
   %>
