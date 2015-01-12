package com.eclipse.eg.extrcp.extPoint;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ExtPointView extends ViewPart {
	public static final String ID = "com.eclipse.eg.extrcp.extPoint.ExtPointView";

	public ExtPointView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		CTabFolder tabFolder = new CTabFolder(parent, SWT.NONE);
		List<String> readTabNames = readTabNames();
		for (String tabName : readTabNames) {
			CTabItem cTabItem = new CTabItem(tabFolder, SWT.NONE);
			cTabItem.setText(tabName);
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	private List<String> readTabNames() {
		List<String> classNames = new ArrayList<>();
		List<String> names = new ArrayList<>();

		try {
			IExtensionRegistry extensionRegistry = Platform
					.getExtensionRegistry();
			IConfigurationElement[] configurationElementsFor = extensionRegistry
					.getConfigurationElementsFor("com.eclipse.eg.ExtRcp.ExtPoint");
			for (IConfigurationElement iConfigurationElement : configurationElementsFor) {
				names.add(iConfigurationElement.getAttribute("name"));
				Object extension = iConfigurationElement.createExecutableExtension("class");
				if (extension instanceof IExtPoint) {
					classNames.add(((IExtPoint) extension).getName());
				}
			}
		} catch (InvalidRegistryObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classNames;
	}
}
