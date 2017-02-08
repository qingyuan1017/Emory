import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;



public class Blur extends JFrame implements ActionListener {
	private JPanel jPanel = new JPanel(); 
	private JButton buttonFile; 
	private JButton buttonBlur; 
	private JButton buttonReset; 
	ImagePanel imagePanel = new ImagePanel(); 
	
	public Blur() {
		super("Blur image"); 
		Container contentPane = getContentPane(); 
		buttonFile = new JButton("Input Image"); 
		buttonFile.addActionListener(this); 		
		buttonBlur = new JButton("Blur");
		
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(this);
		
		jPanel.add(buttonBlur);  
		jPanel.add(buttonReset);
		contentPane.add(jPanel, BorderLayout.SOUTH); 
		contentPane.add(buttonFile, BorderLayout.NORTH);
		contentPane.add(imagePanel, BorderLayout.CENTER);
		
		this.setSize(280, 230); 
		this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public void actionPerformed(ActionEvent e) {
		 JButton button = (JButton)e.getSource(); 	 
				 
		if(button==this.buttonFile) {
			JFileChooser chooser = new JFileChooser(); 
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			chooser.setCurrentDirectory(new File(".")); 
			
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File file) { 
					String name = file.getName().toLowerCase();
					return name.endsWith(".gif")
						|| name.endsWith(".jpg")
						|| name.endsWith(".jpeg")
						|| file.isDirectory();
				}
				public String getDescription() { 
					return "gif/jpg/jpeg";
				}
			});
			int result = chooser.showOpenDialog(this); 
			if (result == JFileChooser.APPROVE_OPTION) { 
				String fileName = chooser.getSelectedFile().getAbsolutePath();
				imagePanel.loadImage(fileName); 
			}		 	
		}
		
		else if(button==this.buttonBlur) {
			imagePanel.blur(); 
			buttonReset.setEnabled(true); 
		}
			
		
		
		
		else if(button==this.buttonReset) {
			imagePanel.reset();
			buttonReset.setEnabled(false);
		}		
	}

	public static void main(String[] args) {
		new Blur();
	}
	
	public class ImagePanel extends JPanel {
		Image image;  
		BufferedImage bufImage;  
		BufferedImage originalBufImage;  
		Graphics2D g2D; 
	
		
		public void loadImage(String fileName) {
			image = this.getToolkit().getImage(fileName);  
			MediaTracker mt = new MediaTracker(this); 
			mt.addImage(image, 0); 
			try {
				mt.waitForAll(); 
			} catch (Exception ex) { 
				ex.printStackTrace(); 
			}
			
			originalBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);
			g2D = originalBufImage.createGraphics();  
			g2D.drawImage(image, 0, 0, this); 
			bufImage = originalBufImage;
			repaint();  
		}
	    
	    public void applyFilter(float[] data) {
			if (bufImage == null)
				return; 
			Kernel kernel = new Kernel(3, 3, data);  
			ConvolveOp imageOp=new ConvolveOp(kernel,ConvolveOp.EDGE_NO_OP, null);	
			BufferedImage filteredBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);	
			imageOp.filter(bufImage, filteredBufImage);
			bufImage = filteredBufImage; 
			repaint(); 
	
		}
		
	 	public void blur() {
			if (bufImage == null)
				return;
			float[] data = {
					0.0625f, 0.125f, 0.0625f,
					0.125f,	0.025f, 0.125f,
					0.0625f, 0.125f, 0.0625f 
			};
			applyFilter(data);
		}
		
		
		
		public void reset() {
			if (bufImage == null)
				return;
			bufImage = originalBufImage;  
			g2D.drawImage(image, 0, 0, this);
			repaint(); 
		}
	
		public void paint(Graphics g) {
			super.paintComponent(g);
			
			if (bufImage != null) {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(bufImage,(this.getWidth() - bufImage.getWidth()) / 2,	(this.getHeight() - bufImage.getHeight()) / 2,this);
			}
		}
	}
}
