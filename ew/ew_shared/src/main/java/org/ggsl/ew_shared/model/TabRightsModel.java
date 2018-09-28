package org.ggsl.ew_shared.model;

import lombok.Data;

@Data
public class TabRightsModel {

	private Integer empTabCustId;
	private String empTabType;
	private String empSubTab;
	private String empTabApp;
	private String empTabAdd;
	private String empTabEdit;
	private String empTabDelete;
	private Integer sequence;
	private String tabsMessage;
	private String subtabsMessage;
	private String empTabAppEmploy;
	private String empSupviewApp;

}