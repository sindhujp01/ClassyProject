package otherjavapgms;

import java.applet.*;
import java.awt.*;

//<applet code="paramDemo" width=300 height=80>
//<param name=fontName value=dfg>
//<param name=fontSize value=14>
//<param name=leading value=2>
//<param name=accountEnabled value=true>
//</applet>
public class ParamDemo extends Applet {
	String fontName;
	int fontSize;
	float leading;
	boolean active;
	public void start(){
		String param;
		fontName=getParameter("fontName");
		if(fontName==null)
			fontName = "not found";
		param=getParameter("fontSize");
		try{
			if(param!=null)
				fontSize=Integer.parseInt(param);
			else
				fontSize=0;
		}
		catch(NumberFormatException e){
			fontSize=-1;
		}
		param=getParameter("leading");
		try{
			if(param!=null)
				leading=Float.valueOf(param).floatValue();
			else
				leading=0;
		}
		catch(NumberFormatException e){
			leading=-1;
	}
		param=getParameter("accountEnabled");
		
			if(param!=null)
				active=Boolean.valueOf(param).booleanValue();
}
public void paint(Graphics g){
	g.drawString("Font name: " + fontName, 0, 10);
	g.drawString("font size: " + fontSize, 0, 26);
	g.drawString("leading: " + leading, 0, 42);
	g.drawString("account active: " + active, 0, 58);
}
}