package br.com.locadora.view.componentes;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import br.com.locadora.utils.locale.LocaleUtils;

public class ImageFilter extends FileFilter {

	// Accept all directories and all gif, jpg, tiff, or png files.
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = null;
		String name = f.getName();
		int index = f.getName().lastIndexOf(".");
		if (index > 0 && index < name.length() -1) {
			extension = name.substring(index + 1);
		}
		if (extension != null) {
			if (extension.equals("gif") || extension.equals("jpeg") || extension.equals("jpg") || extension.equals("png")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// The description of this filter
	public String getDescription() {
		return LocaleUtils.getLocaleView().getString("info_apenas_imagem");
	}
}