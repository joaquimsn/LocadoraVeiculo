package br.com.locadora.view.componentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import br.com.locadora.utils.locale.LocaleUtils;

/*
 * 	CustomComboBox uses the following files:
 *   /resoureces/images/icons/bandeira_brasil.png
 *   /resoureces/images/icons/bandeira_espanha.png
 *   /resoureces/images/icons/bandeira_us.png
 */
public class CustomComboBox extends JPanel {
	private static final long serialVersionUID = 5580773222724023182L;
	
	ImageIcon[] images;
    String[] bandeiraStrings = {LocaleUtils.getLocaleView().getString("cbx_value_portugues"), LocaleUtils.getLocaleView().getString("cbx_value_espanhol"),
    		LocaleUtils.getLocaleView().getString("cbx_value_ingles")};
    public JComboBox bandeiraList;

    /*
     * Despite its use of EmptyBorder, this panel makes a fine content
     * pane because the empty border just increases the panel's size
     * and is "painted" on top of the panel's normal background.  In
     * other words, the JPanel fills its entire background if it's
     * opaque (which it is by default); adding a border doesn't change
     * that.
     */
    public CustomComboBox() {
        super(new BorderLayout());

        //Load the pet images and create an array of indexes.
        images = new ImageIcon[bandeiraStrings.length];
        Integer[] intArray = new Integer[bandeiraStrings.length];
        for (int i = 0; i < bandeiraStrings.length; i++) {
            intArray[i] = new Integer(i);
            images[i] = createImageIcon("br/com/locadora/resoureces/images/icons/bandeira_" + i + ".png");
            if (images[i] != null) {
                images[i].setDescription(bandeiraStrings[i]);
            }
        }

        //Create the combo box.
        bandeiraList = new JComboBox(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        bandeiraList.setRenderer(renderer);
        bandeiraList.setMaximumRowCount(3);
        
        //Lay out the demo.
        add(bandeiraList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
    	return new ImageIcon(ClassLoader.getSystemResource(path));
    }
    
    @SuppressWarnings("rawtypes")
	class ComboBoxRenderer extends JLabel
                           implements ListCellRenderer {
        private Font font;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        /*
		 * This method finds the image and text corresponding to the selected value and
		 * returns the label, set up to display the text and image.
		 */
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String bandeira = bandeiraStrings[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(bandeira);
                setFont(list.getFont());
            } else {
                setUhOhText(bandeira + " (no image available)",
                            list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (font == null) { //lazily create this font
                font = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(font);
            setText(uhOhText);
        }
    }
}
