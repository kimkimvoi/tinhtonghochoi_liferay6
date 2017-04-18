package com.fsoft.bn.portlet.picturelibrary;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.portlet.delegate.PictureGalleryDelegate;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PictureLibraryPortlet
 */
public class PictureLibraryPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// init
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PictureModel picture;
		
		// get display picture id from portlet config
		PortletPreferences prefs = PortalUtil.getPortletPreferences(renderRequest);
		String radioPicture = prefs.getValue("radioPicture", "");
		try {
			long pictureId = Long.parseLong(radioPicture);
			picture = pictureGalleryDelegate.getPictureById(pictureId, themeDisplay);
			renderRequest.setAttribute("picture", picture);
		} catch(Exception ex) {
			// TODO: get default picture
			picture = pictureGalleryDelegate.getLastestPicture(themeDisplay);
			renderRequest.setAttribute("picture", picture);
		}
		
		super.doView(renderRequest, renderResponse);
	}

}
