package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;

import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
//import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextArea;

public class Tela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setMinimumSize(new Dimension(900, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{85, 85, 85, 85, 85, 85, 85, 57, 84, 0};
		gbl_contentPane.rowHeights = new int[]{75, 271, 178, 0, 25, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNovo = new JButton("Novo [ctrl-n]");
		Image img = new ImageIcon(this.getClass().getResource("/novo1.png")).getImage();
		btnNovo.setIcon(new ImageIcon(img));
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.fill = GridBagConstraints.VERTICAL;
		gbc_btnNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		contentPane.add(btnNovo, gbc_btnNovo);
		
		JButton btnAbrir = new JButton("Abrir [ctrl-o]");
		Image img1 = new ImageIcon(this.getClass().getResource("/abrir.png")).getImage();
		btnAbrir.setIcon(new ImageIcon(img1));
		btnAbrir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAbrir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnAbrir = new GridBagConstraints();
		gbc_btnAbrir.fill = GridBagConstraints.VERTICAL;
		gbc_btnAbrir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbrir.gridx = 1;
		gbc_btnAbrir.gridy = 0;
		contentPane.add(btnAbrir, gbc_btnAbrir);
		
		JButton btnSalvar = new JButton("Salvar [ctrl-s]");
		Image img2 = new ImageIcon(this.getClass().getResource("/salvar.png")).getImage();
		btnSalvar.setIcon(new ImageIcon(img2));
		btnSalvar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.VERTICAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 0;
		contentPane.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnCopiar = new JButton("Copiar [ctrl-c]");
		Image img3 = new ImageIcon(this.getClass().getResource("/copiar.png")).getImage();
		btnCopiar.setIcon(new ImageIcon(img3));
		btnCopiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCopiar.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            }
        });
		GridBagConstraints gbc_btnCopiar = new GridBagConstraints();
		gbc_btnCopiar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCopiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCopiar.gridx = 3;
		gbc_btnCopiar.gridy = 0;
		contentPane.add(btnCopiar, gbc_btnCopiar);
		
		JButton btnColar = new JButton("Colar [ctrl-v]");
		Image img4 = new ImageIcon(this.getClass().getResource("/colar1.png")).getImage();
		btnColar.setIcon(new ImageIcon(img4));
		btnColar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnColar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnColar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
			}	
		});
		GridBagConstraints gbc_btnColar = new GridBagConstraints();
		gbc_btnColar.fill = GridBagConstraints.VERTICAL;
		gbc_btnColar.insets = new Insets(0, 0, 5, 5);
		gbc_btnColar.gridx = 4;
		gbc_btnColar.gridy = 0;
		contentPane.add(btnColar, gbc_btnColar);
		
		JButton btnRecortar = new JButton("Recortar[ctrl-x]");
		Image img5 = new ImageIcon(this.getClass().getResource("/recorta.png")).getImage();
		btnRecortar.setIcon(new ImageIcon(img5));
		btnRecortar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRecortar.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnRecortar = new GridBagConstraints();
		gbc_btnRecortar.fill = GridBagConstraints.BOTH;
		gbc_btnRecortar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecortar.gridx = 5;
		gbc_btnRecortar.gridy = 0;
		contentPane.add(btnRecortar, gbc_btnRecortar);
		
		JButton btnCompilar = new JButton("Compilar[F7]");
		Image img6 = new ImageIcon(this.getClass().getResource("/compilar.png")).getImage();
		btnCompilar.setIcon(new ImageIcon(img6));
		btnCompilar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCompilar.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnCompilar = new GridBagConstraints();
		gbc_btnCompilar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCompilar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCompilar.gridx = 6;
		gbc_btnCompilar.gridy = 0;
		contentPane.add(btnCompilar, gbc_btnCompilar);
		
		JButton btnEquipe = new JButton("Equipe[F1]");
		Image img7 = new ImageIcon(this.getClass().getResource("/equipe.png")).getImage();
		btnEquipe.setIcon(new ImageIcon(img7));
		btnEquipe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEquipe.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnEquipe = new GridBagConstraints();
		gbc_btnEquipe.fill = GridBagConstraints.VERTICAL;
		gbc_btnEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_btnEquipe.gridx = 7;
		gbc_btnEquipe.gridy = 0;
		contentPane.add(btnEquipe, gbc_btnEquipe);
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.gridheight = 2;
		gbc_splitPane.gridwidth = 9;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		contentPane.add(splitPane, gbc_splitPane);
		
		JScrollPane scrollPaneEditor = new JScrollPane();
		scrollPaneEditor.setMinimumSize(new Dimension(800, 200));
		splitPane.setLeftComponent(scrollPaneEditor);
		scrollPaneEditor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneEditor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextArea textAreaEditor = new JTextArea();
		scrollPaneEditor.setViewportView(textAreaEditor);
		textAreaEditor.setBorder(new NumberedBorder());
		
		JScrollPane scrollPaneMensagens = new JScrollPane();
		scrollPaneMensagens.setMinimumSize(new Dimension(800, 200));
		splitPane.setRightComponent(scrollPaneMensagens);
		scrollPaneMensagens.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneMensagens.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextPane textPaneMensagens = new JTextPane();
		textPaneMensagens.setEditable(false);
		scrollPaneMensagens.setViewportView(textPaneMensagens);
		
		JLabel lblStatus = new JLabel("");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.gridwidth = 9;
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 4;
		contentPane.add(lblStatus, gbc_lblStatus);
		
		//ações
		//Equipe[F1]
		btnEquipe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				textPaneMensagens.setText(mostrarEquipe());
			}
		});
		
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "MostrarEquipe");
		textPaneMensagens.getActionMap().put("MostrarEquipe", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPaneMensagens.setText(mostrarEquipe());
			}
			
		});
		//Compilar[F7]
		btnCompilar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				textPaneMensagens.setText("compilação de programas ainda não foi implementada");
			}
		});
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F7"), "Compilar");
		textPaneMensagens.getActionMap().put("Compilar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPaneMensagens.setText("compilação de programas ainda não foi implementada");
			}
			
		});
		
		//novo[ctrl-N]
		btnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				textAreaEditor.setText("");
				textPaneMensagens.setText("");
				lblStatus.setText("");
			}
		});
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control N"), "Novo");
		textPaneMensagens.getActionMap().put("Novo", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAreaEditor.setText("");
				textPaneMensagens.setText("");
				lblStatus.setText("");
			}
			
		});
		
		//copiar[ctrl-C]
		btnCopiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				copiar(textAreaEditor, textPaneMensagens);
			}
        });
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control C"), "Copiar");
		textPaneMensagens.getActionMap().put("Copiar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copiar(textAreaEditor, textPaneMensagens);
			}
		}
		);
		
		//colar[ctrl-V]
		btnColar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent e) {
	        	colar(textAreaEditor, textPaneMensagens);
	        }
	        });
			textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control V"), "Colar");
			textPaneMensagens.getActionMap().put("Colar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colar(textAreaEditor, textPaneMensagens);
			}
			
		});
		
		//abrir[ctrl-0]
		btnAbrir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Abrir(contentPane, lblStatus, textPaneMensagens, textAreaEditor);
			}
		});
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control O"), "Abrir");
		textPaneMensagens.getActionMap().put("Abrir", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Abrir(contentPane, lblStatus, textPaneMensagens, textAreaEditor);
			}
			
		});
		
		//recortar[ctrl-X]
		btnRecortar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recortar(textAreaEditor, textPaneMensagens);
			}
		});
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control X"), "Recortar");
		textPaneMensagens.getActionMap().put("Recortar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recortar(textAreaEditor, textPaneMensagens);
			}
			
		});
		
		//salvar [ctrl-S]
		btnSalvar.addActionListener(new java.awt.event.ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar(textAreaEditor, textPaneMensagens, lblStatus, contentPane);
			}
		});
		textPaneMensagens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control S"), "Recortar");
		textPaneMensagens.getActionMap().put("Recortar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar(textAreaEditor, textPaneMensagens, lblStatus, contentPane);
			}
			
		});
	}
	
	//METODOS AUXILIARES | |
	//					 V V
	
	private void salvar(JTextArea textAreaEditor,  JTextPane textPaneMensagens, JLabel lblStatus, JPanel ContentFrame) {
		if(lblStatus.getText().equals("")) {
			 JFileChooser fileChooser = new JFileChooser();
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
			 fileChooser.setFileFilter(filter);
		        int returnValue = fileChooser.showSaveDialog(null);

		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
		            String selectedFileTxt = selectedFile + ".txt";
		            String content = textAreaEditor.getText();

		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFileTxt))) {
		                writer.write(content);
		                lblStatus.setText(selectedFile);
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		} else {
			 String content = textAreaEditor.getText();
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(lblStatus.getText()))) {
				writer.write(content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		textPaneMensagens.setText("Arquivo Salvo!");
	}
	
	private void recortar(JTextArea textAreaEditor, JTextPane textPaneMensagens) {
		String text = textAreaEditor.getSelectedText();
        if (text != null && !text.isEmpty()) {
            textAreaEditor.cut();
            textPaneMensagens.setText("código recortado!");
        } else {
        	textPaneMensagens.setText("não há nada para recortar!");
        }
	}
	
	
	private void copiar(JTextArea textAreaEditor, JTextPane textPaneMensagens) {	
		String text = textAreaEditor.getSelectedText();
        if (text != null) {
            java.awt.datatransfer.Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
            java.awt.datatransfer.StringSelection selection = new java.awt.datatransfer.StringSelection(text);
            clipboard.setContents(selection, null);
            textPaneMensagens.setText("código copiado!");
        } else {
        	textPaneMensagens.setText("não há nada para copiar!");
        }
	}
	
	private void colar(JTextArea textAreaEditor, JTextPane textPaneMensagens) {
		Clipboard areaTransf = Toolkit.getDefaultToolkit().getSystemClipboard();
    	Transferable transf = areaTransf.getContents(null);
    	if (transf != null && transf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
    		try {
    			String textoCopiado = (String) transf.getTransferData(DataFlavor.stringFlavor);
    			textAreaEditor.setText(textAreaEditor.getText() + textoCopiado);
    			textPaneMensagens.setText("código colado!");
    		} catch (Exception ex) {
    			ex.printStackTrace();
    			textPaneMensagens.setText("não há o que colar, area de transferência vazia(ctrl-C)!");
    		}
    	} 
	}
	
	private String mostrarEquipe() {
		return "Adriano Gabriel Girardi \nGabriel De Antoni Santos \nLyan Rodrigues";
	}
	
	private void Abrir(JPanel contentPane, JLabel lblStatus, JTextPane textPaneMensagens, JTextArea textAreaEditor) {
		  JFileChooser chooser = new JFileChooser();
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		  chooser.setFileFilter(filter);
		  int returnValue = chooser.showOpenDialog(contentPane);
		  	if(returnValue == chooser.APPROVE_OPTION) {
			  try {
				  String filePath = chooser.getSelectedFile().getAbsolutePath();
				  String fileContent = readFile(filePath);
				  lblStatus.setText(filePath);
				 textAreaEditor.setText(fileContent);
				 textPaneMensagens.setText("");
			  } catch (Exception e ) {
				  e.printStackTrace();
			  }
		  }
	}
	
    private static String readFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}