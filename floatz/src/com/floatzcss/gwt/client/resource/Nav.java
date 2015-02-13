package com.floatzcss.gwt.client.resource;

import com.google.gwt.resources.client.CssResource;

/**
 * CSS bundle of floatz.nav.css for GWT.
 * <p>
 * Copyright (c) 2010-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @since 1.2.0
 */
public interface Nav extends CssResource {

	/**
	 * Skiplink target anchor class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_anchor")
	String anchor();

	/**
	 * Breadcrumb container class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_breadcrumb")
	String breadcrumb();

	/**
	 * Marker class for disabled navigation item
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_disabled")
	String disabled();

	/**
	 * Horizontal menu container class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_hmenu")
	String hmenu();

	/**
	 * Horizontal tab menu container class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_htabmenu")
	String htabmenu();

	/**
	 * Horizontal bottom aligned tab menu container class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_htabmenu_bottom")
	String htabmenu_bottom();

	/**
	 * List navigation class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_listnav")
	String listnav();

	/**
	 * Marker class for passed workflow steps
	 * @return Name of CSS class
	 */
	@ClassName("flz_passed")
	String passed();

	/**
	 * Marker class for selected navigation items
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_selected")
	String selected();

	/**
	 * Skiplink anchor class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_skiplink")
	String skiplink();

	/**
	 * Skiplink navigation container class
	 *
	 * @return Name of CSS class
	 */
	@ClassName("flz_skipnav")
	String skipnav();

	/**
	 * Toolbar navigation container class
	 * @return Name of CSS class
	 */
	@ClassName("flz_toolbar")
	String toolbar();

	/**
	 * Top navigation container class
	 * @return Name of CSS class
	 */
	@ClassName("flz_topnav")
	String topnav();

	/**
	 * Vertical menu container class
	 * @return Name of CSS class
	 */
	@ClassName("flz_vmenu")
	String vmenu();
	/**
	 * Workflow indicator
	 * @return Name of CSS class
	 */
	@ClassName("flz_workflow")
	String workflow();
}
