package com.fedevela.thread;

//http://arashmd.blogspot.mx/2013/07/java-thread-example.html

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Parameter {// Parameter class for passing required data to threads and
					// between classes
	public static final Color backColor = Color.black;// set the background
														// color, white and
														// black are cool enough
														// :D
	public static int minDrawTime = 33;// the minimum time square drawer should
										// wait after each drawing process
	public Graphics2D g;// graphic that associated to each vertical portion, for
						// drawing easier
	public int width, height;// indicated the width and height of eahc portion

	Parameter(Graphics2D g, int width, int height) {
		this.g = g;
		this.width = width;
		this.height = height;
	}
}

/**
 * by Arash M. Dehghani arashmd.blogspot.com
 */
public class MatrixThread implements Runnable {// Runnable implemented, this is
												// the drawing thread
	public static void main(String[] args) throws Exception {
		new MatrixThread();
	}

	JLabel lab; // Label for showing the target image
	// just some string at the top of the target image, would be your name :D
	String message = "by Arash M. Dehghani (arashmd.blogspot.com) , wheel the mouse for changing the drawing speed, click to exit";
	int levelCount = 24;// number of vertical portion, change and see the
						// effects (big ones doesn't make sense)
	int capSpace;// the space reminded (unusable) at the right and left sides
	BufferedImage img;// the target image that shows the target
	Graphics2D g;// the graphic associated the the img variable(target image)

	// number of times(frame) that drawing thread needs to refresh the target
	// image in a second
	// the higher value will effects(improve) the animation smoothness and would
	// cause the vertical-synchronization also needs more power
	// the lower value needs less power, decrease the animation smoothness and
	// would cause the glitching
	int fps = 60;// do not set less than 30 and and high values

	BufferedImage[] images;// arrays of portion images
	int screenWidth, screenHeight;// the width and height of the screen

	MatrixThread() throws Exception {
		GraphicsDevice vc;
		JFrame f = new JFrame("Matrix by Arash");
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Toolkit tk = Toolkit.getDefaultToolkit();
		// hide the cursor
		f.setCursor(f.getToolkit().createCustomCursor(
				new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
				new Point(0, 0), "null"));
		screenWidth = tk.getScreenSize().width;// get the screen size
		screenHeight = tk.getScreenSize().height;
		img = new BufferedImage(screenWidth, screenHeight,
				BufferedImage.TYPE_INT_ARGB);// init the target image as screen
												// size
		lab = new JLabel(new ImageIcon(img), JLabel.CENTER);// init label and
															// pass the target
															// image to it as
															// showing parameter
		f.getContentPane().add(lab);
		g = img.createGraphics();
		vc = ge.getDefaultScreenDevice();
		f.setUndecorated(true);
		f.setResizable(false);
		vc.setFullScreenWindow(f);// set the application as full screen
		lab.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}// exit the by a click
		});
		// listening for mouse wheel for decreasing and increasing the
		// fade-out/fade-in operation
		lab.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				if (arg0.getWheelRotation() == -1) {
					if (Parameter.minDrawTime > 30) {
						Parameter.minDrawTime -= 10;
					}
				} else {
					if (Parameter.minDrawTime < 60) {
						Parameter.minDrawTime += 10;
					}
				}
			}
		});
		images = new BufferedImage[levelCount];// init the portion images array
		// calculate the remind(unusable) space at right/left sides in target
		// image
		capSpace = (int) (tk.getScreenSize().getWidth() % levelCount) / 2;
		// calculate how many pixel is required for each portion image
		int width = (int) Math
				.floor(tk.getScreenSize().getWidth() / levelCount);
		for (int i = 0; i < levelCount; i++) {// in as for loop init portion
												// image array images
			images[i] = new BufferedImage(width, tk.getScreenSize().height,
					BufferedImage.TYPE_4BYTE_ABGR);
			Parameter p = new Parameter(images[i].createGraphics(), width,
					tk.getScreenSize().height);
			new Thread(new VerticalPortion(p)).start();// starts a portion as a
														// thread
		}
		Font font = new Font("courier new", Font.BOLD, 16);// the font for
															// showing the
															// message at the
															// top screen
		g.setFont(font);
		new Thread(this).start();// starts this thread(drawing thread)
	}

	@Override
	public void run() {// drawing thread start
		while (true) {
			g.setColor(Parameter.backColor);// set the color as it should be
			g.fillRect(0, 0, screenWidth, screenHeight);// purge the screen
			for (int i = 0; i < images.length; i++) {// draw each portion to the
														// target img
				g.drawImage(images[i], (images[i].getWidth() * i)
						+ ((i == 0) ? capSpace : 0), 0, lab);
			}
			g.setColor(Color.gray);// set the color to draw the message, could
									// be anything
			g.drawString(message, 20, 20);
			lab.repaint();// force the label to refresh (refresh the image in
							// fact)
			try {
				Thread.sleep(1000 / fps);// wait for a while
			} catch (InterruptedException e) {
			}
		}
	}// drawing thread end
}

class VerticalPortion implements Runnable {
	Parameter p;
	Thread[] trds;
	int verticalSpaceCap;// remind (unusable) space in top and bottom of the
							// screen

	public VerticalPortion(Parameter p) {
		this.p = p;
		trds = new Thread[(int) Math.floor(p.height / p.width)];// calculate how
																// many possible
																// square would
																// this portion
																// have
		verticalSpaceCap = p.height % p.width;// calculate the unusable space
		p.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);// enable antialias, it draws
													// components smoother
	}

	@Override
	public void run() {
		for (int i = 0; i < trds.length; i++) {
			Parameter px = new Parameter(p.g, p.width, p.height);
			trds[i] = new Thread(new SmallSquare(px, i * p.width
					+ (verticalSpaceCap / 2)));// one thread for one small
												// square handler
			trds[i].start();// start the thread
		}
	}
}

class SmallSquare implements Runnable {
	Parameter p;
	// two 4 length array that contains the RGBA of both background color and
	// color square should be drawn by
	byte[] color, hcolor = new byte[4];
	int topSpaceCap;// indicates how many pixel from top should this thread skip
	int margin; // spaces should be skip at each edge of square
	int j;// index for saving the last alpha value
	int waitTime;// time this thread should wait after each drawing
	int shapeSize;// the target shape size
	int increaseWidth;// the increment size for each square layer
	int colorDiff = 10;// the value that effects each iteration color, could be
						// more(more differences) or less

	public SmallSquare(Parameter p, int topSpaceCap) {
		this.p = p;
		this.topSpaceCap = topSpaceCap;
		margin = (int) (p.width * 0.05);
		// split the randomized color into a 4 byte array as ARGB
		this.color = ByteBuffer.allocate(4)
				.putInt((int) (Math.random() * Integer.MIN_VALUE)).array();
		hcolor[0] = (byte) 0;
		hcolor[1] = (byte) Parameter.backColor.getRed();
		hcolor[2] = (byte) Parameter.backColor.getGreen();
		hcolor[3] = (byte) Parameter.backColor.getBlue();
		// Initialize the target full-transparent square size
		shapeSize = (p.width) - (margin * 2);
		// initialize how many pixel should increase for the next layers
		increaseWidth = (int) ((shapeSize - (shapeSize * 0.6)) / 10);
	}

	@Override
	public void run() {
		while (true) {
			waitTime = (int) (Math.random() * Parameter.minDrawTime * 3);// get
																			// a
																			// random
																			// wait
																			// time
																			// in
																			// each
																			// iteration
			if (waitTime < Parameter.minDrawTime) {
				waitTime = Parameter.minDrawTime;
			}
			int diff = (int) (Math.random() * colorDiff) + 1;
			int ndiff = (diff % 2 == 0) ? diff : diff * -1;
			color[1] = ((color[1] & 0XFF) + colorDiff < 255 && (color[1] & 0XFF)
					- colorDiff > 0) ? (byte) ((color[1] & 0xFF) + ndiff)
					: (((color[1] & 0xFF) + colorDiff > 255) ? (byte) ((color[1] & 0xFF) - diff)
							: (byte) ((color[1] & 0xFF) + diff));

			color[2] = ((color[2] & 0XFF) + colorDiff < 255 && (color[2] & 0XFF)
					- colorDiff > 0) ? (byte) ((color[2] & 0xFF) + ndiff)
					: (((color[2] & 0xFF) + colorDiff > 255) ? (byte) ((color[2] & 0xFF) - diff)
							: (byte) ((color[2] & 0xFF) + diff));

			color[3] = ((color[3] & 0XFF) + colorDiff < 255 && (color[3] & 0XFF)
					- colorDiff > 0) ? (byte) ((color[3] & 0xFF) + ndiff)
					: (((color[3] & 0xFF) + colorDiff > 255) ? (byte) ((color[3] & 0xFF) - diff)
							: (byte) ((color[3] & 0xFF) + diff));

			// fade-in method 0, comment the method 1 if you wan to use this
			/*
			 * for(int i=0;i<10;i++){ if(i==9){color[0]=(byte) 255;}
			 * else{color[0]=(byte) (i*10);} synchronized (p.g){
			 * if(i==9){p.g.setColor(new
			 * Color(color[1]&0xFF,color[2]&0xFF,color[
			 * 3]&0xFF,color[0]&0xFF).brighter());} else{p.g.setColor(new
			 * Color(color[1]&0xFF,color[2]&0xFF,color[3]&0xFF,color[0]&0xFF));}
			 * p
			 * .g.fillRoundRect(margin+(i*increaseWidth),margin+(i*increaseWidth
			 * )+this.topSpaceCap,
			 * shapeSize-(i*increaseWidth*2),shapeSize-(i*increaseWidth*2),j,j);
			 * } try {Thread.sleep(waitTime);} catch (InterruptedException e) {}
			 * }
			 */// fade-in method 0

			// fade in method 1
			for (int i = 10; i > 0; i--) {
				color[0] = (byte) (i * 5);// sets the alpha for each layer of
											// the square

				/*
				 * this synchronized block is required, because in a portion,
				 * there are(could be) more than 1 thread.so because the portion
				 * image is shared belong to every thread, each thread need to
				 * lock the graphic objectand draw it's image, if there is no
				 * synchronized method, this is possible that thread 1 draw its
				 * line bythe color that thread 2 has been specified, just omit
				 * the synchronized block and see the difference!
				 */
				synchronized (p.g) {// [0]
					// drawing brighter color for the center square
					if (i == 10) {
						p.g.setColor(new Color(color[1] & 0xFF,
								color[2] & 0xFF, color[3] & 0xFF, 255)
								.brighter().brighter().brighter());
					} else {
						p.g.setColor(new Color(color[1] & 0xFF,
								color[2] & 0xFF, color[3] & 0xFF,
								color[0] & 0xFF));
					}
					p.g.fillRoundRect(margin + (i * increaseWidth), margin
							+ (i * increaseWidth) + this.topSpaceCap, shapeSize
							- (i * increaseWidth * 2), shapeSize
							- (i * increaseWidth * 2), (10 - i) * 2,
							(10 - i) * 2);
				}
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
				}
			}// fade-in method 1

			// fade-out
			for (int i = 0; i < 50; i++) {
				hcolor[0] = (byte) (i * 5.1);
				synchronized (p.g) {
					p.g.setColor(new Color(hcolor[1] & 0xFF, hcolor[2] & 0xFF,
							hcolor[3] & 0xFF, hcolor[0] & 0xFF));
					p.g.fillRect(margin, margin + this.topSpaceCap, shapeSize,
							shapeSize);
				}
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
				}
			}// fade-out

		}
	}
}