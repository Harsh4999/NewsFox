package com.college.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.Language;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;
public class GoogleMapsSample {
	  public static void main(String[] args) {
//		  try {
//			  Engine engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED)
//					  	
//				        .language(Language.ENGLISH_US)
//				        .build());
//		//	  Engine engine = Engine.newInstance(RenderingMode.HARDWARE_ACCELERATED);
//			  Browser browser = engine.newBrowser();
//			  browser.resize(800, 600);
//			  browser.navigation().loadUrl("http://maps.google.com");
//			 BrowserView view = BrowserView.newInstance(browser);
//			  JFrame frame = new JFrame("JxBrowser Google Maps");
//		        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		        frame.add(view, BorderLayout.CENTER);
//		        frame.setSize(700, 500);
//		        frame.setLocationRelativeTo(null);
//		        frame.setVisible(true);
//		       
//			  browser.close();
//		  }catch(Exception e) {
//			  System.out.println(e);
//		  }
		  System.setProperty("jxbrowser.license.key", "1BNDHFSC1G1UMIA03KIH6PXMHEFB3EIE84D8U3PYQMQFJ1KYJE0YQI53BUSJROKC9398OX");
		  System.out.println(System.getProperty("jxbrowser.license.key"));
		  Engine engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED)
			  	.licenseKey("1BNDHFSC1G1UMIA03KIH6PXMHEFB3EIE84D8U3PYQMQFJ1KYJE0YQI53BUSJROKC9398OX")
				 // 	.chromiumDir(Paths.get("/home/harsh/eclipse-workspace/depsForProj"))
			        .build());
	
		  // Create a Browser instance.
		  
		Browser browser = engine.newBrowser();

		SwingUtilities.invokeLater(() -> {
		    JFrame frame = new JFrame("JxBrowser AWT/Swing");
		    frame.addWindowListener(new WindowAdapter() {
		        @Override
		        public void windowClosing(WindowEvent e) {
		            // Shutdown Chromium and release allocated resources.
		            engine.close();
		        }
		    });
		    // Create and embed Swing BrowserView component to display web content.
		    frame.add(BrowserView.newInstance(browser));
		    frame.setSize(1280, 800);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);

		    // Load the required web page.
		    browser.navigation().loadUrl("https://html5test.com/");
		});
	    }
}
