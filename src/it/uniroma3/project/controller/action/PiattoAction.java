package it.uniroma3.project.controller.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.fileupload.servlet.*;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.Piatto;
import it.uniroma3.project.services.validator.DoubleValidator;
import it.uniroma3.project.services.validator.PathValidator;
import java.util.List;

public class PiattoAction {

	public PiattoAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		DoubleValidator validator = new DoubleValidator();
		CategoriaPiatto categoria = null;
		Piatto piatto = null;
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input
					// type="text|radio|checkbox|etc", select, etc).
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					if (fieldName.equals("descrizione"))
						descrizionePiatto.setDescrizione(fieldValue);
					if (fieldName.equals("prezzo"))
						descrizionePiatto.setPrezzo(validator.doubleValidator(fieldValue));
					if (fieldName.equals("allergeni"))
						descrizionePiatto.setProdottiAllergizzanti(Boolean.parseBoolean(fieldValue));
					if (fieldName.equals("surgelati"))
						descrizionePiatto.setProdottiSurgelati(Boolean.parseBoolean(fieldValue));

				} else {
					// Process form file field (input type="file").
					String fieldName = item.getFieldName();
					String fileName = FilenameUtils.getName(item.getName());
					InputStream fileContent = item.getInputStream();
					byte[] img = IOUtils.toByteArray(fileContent);
					descrizionePiatto.setImg(img);
				}

				String fieldName = item.getFieldName();
				String fieldValue = item.getString();

				if (fieldName.equals("categoria")) {
					categoria = facade.findCategoria(fieldValue);

				}

				if (fieldName.equals("nome") && categoria != null)
					piatto = new Piatto(fieldValue, descrizionePiatto, categoria);
			}
		} catch (FileUploadException e) {
			try {
				throw new ServletException("Cannot parse multipart request.", e);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (piatto != null)
			facade.inserisciPiatto(piatto);
		facade.closeEntityManager();

		return "/inserimentoPiatti.jsp";
	}

}
