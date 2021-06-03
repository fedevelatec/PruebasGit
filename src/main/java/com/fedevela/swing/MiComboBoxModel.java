
package com.fedevela.swing;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Locale;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class MiComboBoxModel extends AbstractListModel implements ComboBoxModel {
 Calendar micalendar;
 ArrayList anioslist=new ArrayList();
 
  public MiComboBoxModel(){
      micalendar=Calendar.getInstance();//ahora
      int ano=micalendar.get(Calendar.YEAR);
      anioslist.add(String.valueOf(ano-4));
      anioslist.add(String.valueOf(ano-3));
      anioslist.add(String.valueOf(ano-2));
      anioslist.add(String.valueOf(ano-1));
      anioslist.add(String.valueOf(ano));
      anioslist.add(String.valueOf(ano+1));
      anioslist.add(String.valueOf(ano+2));
      anioslist.add(String.valueOf(ano+3));
      anioslist.add(String.valueOf(ano+4));

  }
  String selection = null;//"2013";

 @Override
  public Object getElementAt(int index) {
    return anioslist.get(index);
  }

 @Override
  public int getSize() {
    return anioslist.size();
  }

 @Override
  public void setSelectedItem(Object anItem) {
    selection = (String) anItem; // to select and register an
  } // item from the pull-down list

  // Methods implemented from the interface ComboBoxModel
 @Override
  public Object getSelectedItem() {
    return selection; // to add the selection to the combo box
  }
}