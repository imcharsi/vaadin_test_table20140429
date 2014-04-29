package org.imcharsi.vaadin.testapp4testtable20140429;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.imcharsi.vaadin.testtable.TestTable;
import org.vaadin.risto.mockupcontainer.MockupContainer;

/**
 * Created by KangWoo,Lee on 14. 4. 29.
 */
@Push
@Widgetset("org.imcharsi.vaadin.testtable.TestTableWidgetset")
public class TestUI extends UI {
    private VerticalLayout layout = new VerticalLayout();
    private TestTable testTable = new TestTable();
    private Table table = new Table();
    private MockupContainer container1 = new MockupContainer();
    private MockupContainer container2 = new MockupContainer();
    private TextField textField1 = new TextField();
    private TextField textField2 = new TextField();
    private Property<Integer> property1 = new ObjectProperty<Integer>(0);
    private Property<Integer> property2 = new ObjectProperty<Integer>(0);

    private class ListenerOne implements Property.ValueChangeListener {
        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            final Integer value = property1.getValue();
            container1.setItemCount(value);
            container2.setItemCount(value);
            testTable.setContainerDataSource(container1);
            table.setContainerDataSource(container2);
        }
    }

    private class ListenerTwo implements Property.ValueChangeListener {
        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            final Integer value = property2.getValue();
            container1.setItemDelay(value);
            container2.setItemDelay(value);
        }
    }

    @Override
    protected void init(VaadinRequest request) {
        testTable.setCaption("testtable");
        testTable.setPageLength(5);
        testTable.setContainerDataSource(container1);
        testTable.setSelectable(true);
        testTable.setImmediate(true);
        table.setCaption("originaltable");
        table.setPageLength(5);
        table.setContainerDataSource(container2);
        table.setSelectable(true);
        table.setImmediate(true);
        textField1.setCaption("itemcount");
        textField1.setPropertyDataSource(property1);
        textField1.setImmediate(true);
        textField1.addValueChangeListener(new ListenerOne());
        textField2.setCaption("itemdelay");
        textField2.setPropertyDataSource(property2);
        textField2.setImmediate(true);
        textField2.addValueChangeListener(new ListenerTwo());
        layout.addComponents(testTable, table, textField1, textField2);
        setContent(layout);
    }
}
