package br.com.biopids.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.biopids.domain.Basic;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.model.BasicModel;
import br.com.biopids.model.ComboBasic;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;
import br.com.biopids.util.RenderedPanelsBasic;

@ManagedBean(name = "ManagerBasic")
@ViewScoped
public class ManagerBasic extends GenericBean<Basic, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * 
	 */

	public ManagerBasic() {
		super();
	}

	public String moveToKingdom() {
		return "reino";
	}

	public void save() {
		try {
			mapping();
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executeSearch();
		boolean result = false;
		if (getList().size() != 0) {

			for (int i = 0; i < getList().size(); i++) {
				if (getList().get(i).equals(
						((BasicModel) getModel()).getValor())) {
					setMessage(FacesMessage.SEVERITY_WARN, FactoreProperties
							.loadPtbr().getValor("RegistroJaCadastrado"), "");
					result = true;
				}
			}
			
		} else if (result)
			super.save();
		objectModel = getModel();
		search();
	}



	public ControlerList getControllerList() {
		return (ControlerList) AppContext.getApplicationContext().getBean(
				"ControlerList");
	}

	@Override
	public IController<Basic, Long> getIController() {
		return (IController<Basic, Long>) AppContext.getApplicationContext()
				.getBean("ControllerBasic");
	}

	@Override
	public Object getModel() {
		return new BasicModel();
	}

	@Override
	public Basic getDomain() {
		return new Basic();
	}

	public Object loadCombos() {

		return null;
	}

	public Boolean getDefaultButton() {
		return false;
	}

	public String[] getCollunsTableSearch() {
		return new String[] { "basic.codigo", "basic.valor", "basic.pai",
				"basic.tipo" };
	}

	public String[] getOrdersTableSearch() {
		return new String[] { "basic.valor", "basic.status" };
	}

}
