package krasa.wicket.npe;

import org.apache.wicket.markup.html.*;

public abstract class ParentPage extends WebPage {

	protected WebMarkupContainer centerColumn = new WebMarkupContainer("center-column");

	@Override
	protected void onBeforeRender() {
		if (get("center-column") == null) {
			queue(centerColumn);
		}

		/** cascades the call to its children */
		super.onBeforeRender();
	}
}
