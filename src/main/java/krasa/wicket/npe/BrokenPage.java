package krasa.wicket.npe;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.*;

public class BrokenPage extends ParentPage {

	public static final String PANEL = "PANEL";

	public BrokenPage() {
		EmptyPanel panel = new EmptyPanel(PANEL);
		panel.setOutputMarkupPlaceholderTag(true);
		queue(panel);
		Form form = new Form("form");
		queue(form);
		queue(new AjaxButton("button", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget ajaxRequestTarget, Form<?> components) {
				Panel resultPanel = new EmptyPanel(PANEL);
				resultPanel.setOutputMarkupPlaceholderTag(true);
				BrokenPage.this.replace(resultPanel);
				ajaxRequestTarget.add(resultPanel);
			}
		});
	}
}
