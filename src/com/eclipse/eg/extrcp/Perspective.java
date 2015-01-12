package com.eclipse.eg.extrcp;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.eclipse.eg.extrcp.extPoint.ExtPointView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		layout.addStandaloneView(ExtPointView.ID, false, IPageLayout.LEFT, 0.95f, editorArea);
	}
}
