package com.SoftWoehr.FIJI;

import java.beans.*;

public class FijiInputComboBoxBeanInfo extends SimpleBeanInfo {


  // Bean descriptor //GEN-FIRST:BeanDescriptor
  private static BeanDescriptor beanDescriptor = new BeanDescriptor  ( FijiInputComboBox.class , null );

  static {//GEN-HEADEREND:BeanDescriptor

    // Here you can add code for customizing the BeanDescriptor.

}//GEN-LAST:BeanDescriptor

  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY_validateRoot = 0;
  private static final int PROPERTY_graphicsConfiguration = 1;
  private static final int PROPERTY_minimumSizeSet = 2;
  private static final int PROPERTY_displayable = 3;
  private static final int PROPERTY_inputContext = 4;
  private static final int PROPERTY_minimumSize = 5;
  private static final int PROPERTY_requestFocusEnabled = 6;
  private static final int PROPERTY_doubleBuffered = 7;
  private static final int PROPERTY_colorModel = 8;
  private static final int PROPERTY_model = 9;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 10;
  private static final int PROPERTY_background = 11;
  private static final int PROPERTY_accessibleContext = 12;
  private static final int PROPERTY_foreground = 13;
  private static final int PROPERTY_selectedObjects = 14;
  private static final int PROPERTY_debugGraphicsOptions = 15;
  private static final int PROPERTY_maximumRowCount = 16;
  private static final int PROPERTY_layout = 17;
  private static final int PROPERTY_selectedItem = 18;
  private static final int PROPERTY_toolTipText = 19;
  private static final int PROPERTY_y = 20;
  private static final int PROPERTY_alignmentY = 21;
  private static final int PROPERTY_x = 22;
  private static final int PROPERTY_alignmentX = 23;
  private static final int PROPERTY_keySelectionManager = 24;
  private static final int PROPERTY_bounds = 25;
  private static final int PROPERTY_preferredSizeSet = 26;
  private static final int PROPERTY_peer = 27;
  private static final int PROPERTY_visibleRect = 28;
  private static final int PROPERTY_optimizedDrawingEnabled = 29;
  private static final int PROPERTY_paintingTile = 30;
  private static final int PROPERTY_width = 31;
  private static final int PROPERTY_showing = 32;
  private static final int PROPERTY_registeredKeyStrokes = 33;
  private static final int PROPERTY_parent = 34;
  private static final int PROPERTY_valid = 35;
  private static final int PROPERTY_locale = 36;
  private static final int PROPERTY_preferredSize = 37;
  private static final int PROPERTY_focusCycleRoot = 38;
  private static final int PROPERTY_autoscrolls = 39;
  private static final int PROPERTY_editable = 40;
  private static final int PROPERTY_lightweight = 41;
  private static final int PROPERTY_enabled = 42;
  private static final int PROPERTY_rootPane = 43;
  private static final int PROPERTY_maximumSizeSet = 44;
  private static final int PROPERTY_selectedIndex = 45;
  private static final int PROPERTY_cursor = 46;
  private static final int PROPERTY_toolkit = 47;
  private static final int PROPERTY_border = 48;
  private static final int PROPERTY_inputVerifier = 49;
  private static final int PROPERTY_dropTarget = 50;
  private static final int PROPERTY_UIClassID = 51;
  private static final int PROPERTY_nextFocusableComponent = 52;
  private static final int PROPERTY_opaque = 53;
  private static final int PROPERTY_name = 54;
  private static final int PROPERTY_componentCount = 55;
  private static final int PROPERTY_insets = 56;
  private static final int PROPERTY_managingFocus = 57;
  private static final int PROPERTY_font = 58;
  private static final int PROPERTY_maximumSize = 59;
  private static final int PROPERTY_actionCommand = 60;
  private static final int PROPERTY_lightWeightPopupEnabled = 61;
  private static final int PROPERTY_actionMap = 62;
  private static final int PROPERTY_popupVisible = 63;
  private static final int PROPERTY_inputMethodRequests = 64;
  private static final int PROPERTY_visible = 65;
  private static final int PROPERTY_components = 66;
  private static final int PROPERTY_locationOnScreen = 67;
  private static final int PROPERTY_componentOrientation = 68;
  private static final int PROPERTY_focusTraversable = 69;
  private static final int PROPERTY_graphics = 70;
  private static final int PROPERTY_height = 71;
  private static final int PROPERTY_topLevelAncestor = 72;
  private static final int PROPERTY_UI = 73;
  private static final int PROPERTY_itemCount = 74;
  private static final int PROPERTY_editor = 75;
  private static final int PROPERTY_treeLock = 76;
  private static final int PROPERTY_renderer = 77;
  private static final int PROPERTY_action = 78;
  private static final int PROPERTY_component = 79;
  private static final int PROPERTY_itemAt = 80;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[81];

  static {
    try {
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", FijiInputComboBox.class, "isValidateRoot", null );
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", FijiInputComboBox.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", FijiInputComboBox.class, "isMinimumSizeSet", null );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", FijiInputComboBox.class, "isDisplayable", null );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", FijiInputComboBox.class, "getInputContext", null );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", FijiInputComboBox.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", FijiInputComboBox.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", FijiInputComboBox.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", FijiInputComboBox.class, "getColorModel", null );
      properties[PROPERTY_model] = new PropertyDescriptor ( "model", FijiInputComboBox.class, "getModel", "setModel" );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", FijiInputComboBox.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", FijiInputComboBox.class, "getBackground", "setBackground" );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", FijiInputComboBox.class, "getAccessibleContext", null );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", FijiInputComboBox.class, "getForeground", "setForeground" );
      properties[PROPERTY_selectedObjects] = new PropertyDescriptor ( "selectedObjects", FijiInputComboBox.class, "getSelectedObjects", null );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", FijiInputComboBox.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_maximumRowCount] = new PropertyDescriptor ( "maximumRowCount", FijiInputComboBox.class, "getMaximumRowCount", "setMaximumRowCount" );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", FijiInputComboBox.class, "getLayout", "setLayout" );
      properties[PROPERTY_selectedItem] = new PropertyDescriptor ( "selectedItem", FijiInputComboBox.class, "getSelectedItem", "setSelectedItem" );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", FijiInputComboBox.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", FijiInputComboBox.class, "getY", null );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", FijiInputComboBox.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", FijiInputComboBox.class, "getX", null );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", FijiInputComboBox.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_keySelectionManager] = new PropertyDescriptor ( "keySelectionManager", FijiInputComboBox.class, "getKeySelectionManager", "setKeySelectionManager" );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", FijiInputComboBox.class, "getBounds", "setBounds" );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", FijiInputComboBox.class, "isPreferredSizeSet", null );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", FijiInputComboBox.class, "getPeer", null );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", FijiInputComboBox.class, "getVisibleRect", null );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", FijiInputComboBox.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", FijiInputComboBox.class, "isPaintingTile", null );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", FijiInputComboBox.class, "getWidth", null );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", FijiInputComboBox.class, "isShowing", null );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", FijiInputComboBox.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", FijiInputComboBox.class, "getParent", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", FijiInputComboBox.class, "isValid", null );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", FijiInputComboBox.class, "getLocale", "setLocale" );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", FijiInputComboBox.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", FijiInputComboBox.class, "isFocusCycleRoot", null );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", FijiInputComboBox.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_editable] = new PropertyDescriptor ( "editable", FijiInputComboBox.class, "isEditable", "setEditable" );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", FijiInputComboBox.class, "isLightweight", null );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", FijiInputComboBox.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", FijiInputComboBox.class, "getRootPane", null );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", FijiInputComboBox.class, "isMaximumSizeSet", null );
      properties[PROPERTY_selectedIndex] = new PropertyDescriptor ( "selectedIndex", FijiInputComboBox.class, "getSelectedIndex", "setSelectedIndex" );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", FijiInputComboBox.class, "getCursor", "setCursor" );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", FijiInputComboBox.class, "getToolkit", null );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", FijiInputComboBox.class, "getBorder", "setBorder" );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", FijiInputComboBox.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", FijiInputComboBox.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", FijiInputComboBox.class, "getUIClassID", null );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", FijiInputComboBox.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", FijiInputComboBox.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", FijiInputComboBox.class, "getName", "setName" );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", FijiInputComboBox.class, "getComponentCount", null );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", FijiInputComboBox.class, "getInsets", null );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", FijiInputComboBox.class, "isManagingFocus", null );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", FijiInputComboBox.class, "getFont", "setFont" );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", FijiInputComboBox.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_actionCommand] = new PropertyDescriptor ( "actionCommand", FijiInputComboBox.class, "getActionCommand", "setActionCommand" );
      properties[PROPERTY_lightWeightPopupEnabled] = new PropertyDescriptor ( "lightWeightPopupEnabled", FijiInputComboBox.class, "isLightWeightPopupEnabled", "setLightWeightPopupEnabled" );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", FijiInputComboBox.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_popupVisible] = new PropertyDescriptor ( "popupVisible", FijiInputComboBox.class, "isPopupVisible", "setPopupVisible" );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", FijiInputComboBox.class, "getInputMethodRequests", null );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", FijiInputComboBox.class, "isVisible", "setVisible" );
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", FijiInputComboBox.class, "getComponents", null );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", FijiInputComboBox.class, "getLocationOnScreen", null );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", FijiInputComboBox.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", FijiInputComboBox.class, "isFocusTraversable", null );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", FijiInputComboBox.class, "getGraphics", null );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", FijiInputComboBox.class, "getHeight", null );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", FijiInputComboBox.class, "getTopLevelAncestor", null );
      properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", FijiInputComboBox.class, "getUI", "setUI" );
      properties[PROPERTY_itemCount] = new PropertyDescriptor ( "itemCount", FijiInputComboBox.class, "getItemCount", null );
      properties[PROPERTY_editor] = new PropertyDescriptor ( "editor", FijiInputComboBox.class, "getEditor", "setEditor" );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", FijiInputComboBox.class, "getTreeLock", null );
      properties[PROPERTY_renderer] = new PropertyDescriptor ( "renderer", FijiInputComboBox.class, "getRenderer", "setRenderer" );
      properties[PROPERTY_action] = new PropertyDescriptor ( "action", FijiInputComboBox.class, "getAction", "setAction" );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", FijiInputComboBox.class, null, null, "getComponent", null );
      properties[PROPERTY_itemAt] = new IndexedPropertyDescriptor ( "itemAt", FijiInputComboBox.class, null, null, "getItemAt", null );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Properties

    // Here you can add code for customizing the properties array.

}//GEN-LAST:Properties

  // EventSet identifiers//GEN-FIRST:Events
  private static final int EVENT_mouseMotionListener = 0;
  private static final int EVENT_inputMethodListener = 1;
  private static final int EVENT_ancestorListener = 2;
  private static final int EVENT_componentListener = 3;
  private static final int EVENT_hierarchyBoundsListener = 4;
  private static final int EVENT_mouseListener = 5;
  private static final int EVENT_focusListener = 6;
  private static final int EVENT_itemListener = 7;
  private static final int EVENT_propertyChangeListener = 8;
  private static final int EVENT_keyListener = 9;
  private static final int EVENT_hierarchyListener = 10;
  private static final int EVENT_containerListener = 11;
  private static final int EVENT_actionListener = 12;
  private static final int EVENT_vetoableChangeListener = 13;

  // EventSet array
  private static EventSetDescriptor[] eventSets = new EventSetDescriptor[14];

  static {
    try {
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentShown", "componentResized", "componentHidden", "componentMoved"}, "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorResized", "ancestorMoved"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseReleased", "mouseEntered", "mouseClicked", "mousePressed", "mouseExited"}, "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_itemListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "itemListener", java.awt.event.ItemListener.class, new String[] {"itemStateChanged"}, "addItemListener", "removeItemListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyReleased", "keyPressed", "keyTyped"}, "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentRemoved", "componentAdded"}, "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_actionListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Events

    // Here you can add code for customizing the event sets array.

}//GEN-LAST:Events

  // Method identifiers //GEN-FIRST:Methods
  private static final int METHOD_contentsChanged0 = 0;
  private static final int METHOD_intervalRemoved1 = 1;
  private static final int METHOD_addItem2 = 2;
  private static final int METHOD_processKeyEvent3 = 3;
  private static final int METHOD_hidePopup4 = 4;
  private static final int METHOD_updateUI5 = 5;
  private static final int METHOD_showPopup6 = 6;
  private static final int METHOD_removeAllItems7 = 7;
  private static final int METHOD_intervalAdded8 = 8;
  private static final int METHOD_configureEditor9 = 9;
  private static final int METHOD_removeItem10 = 10;
  private static final int METHOD_removeItemAt11 = 11;
  private static final int METHOD_insertItemAt12 = 12;
  private static final int METHOD_actionPerformed13 = 13;
  private static final int METHOD_selectWithKeyChar14 = 14;
  private static final int METHOD_hasFocus15 = 15;
  private static final int METHOD_unregisterKeyboardAction16 = 16;
  private static final int METHOD_revalidate17 = 17;
  private static final int METHOD_getListeners18 = 18;
  private static final int METHOD_getInputMap19 = 19;
  private static final int METHOD_removeNotify20 = 20;
  private static final int METHOD_getToolTipLocation21 = 21;
  private static final int METHOD_getBounds22 = 22;
  private static final int METHOD_firePropertyChange23 = 23;
  private static final int METHOD_getActionForKeyStroke24 = 24;
  private static final int METHOD_firePropertyChange25 = 25;
  private static final int METHOD_repaint26 = 26;
  private static final int METHOD_getInputMap27 = 27;
  private static final int METHOD_firePropertyChange28 = 28;
  private static final int METHOD_firePropertyChange29 = 29;
  private static final int METHOD_repaint30 = 30;
  private static final int METHOD_addPropertyChangeListener31 = 31;
  private static final int METHOD_computeVisibleRect32 = 32;
  private static final int METHOD_hide33 = 33;
  private static final int METHOD_reshape34 = 34;
  private static final int METHOD_putClientProperty35 = 35;
  private static final int METHOD_getLocation36 = 36;
  private static final int METHOD_setInputMap37 = 37;
  private static final int METHOD_paintImmediately38 = 38;
  private static final int METHOD_disable39 = 39;
  private static final int METHOD_resetKeyboardActions40 = 40;
  private static final int METHOD_enable41 = 41;
  private static final int METHOD_grabFocus42 = 42;
  private static final int METHOD_getToolTipText43 = 43;
  private static final int METHOD_getClientProperty44 = 44;
  private static final int METHOD_getSize45 = 45;
  private static final int METHOD_firePropertyChange46 = 46;
  private static final int METHOD_removePropertyChangeListener47 = 47;
  private static final int METHOD_requestDefaultFocus48 = 48;
  private static final int METHOD_addNotify49 = 49;
  private static final int METHOD_firePropertyChange50 = 50;
  private static final int METHOD_requestFocus51 = 51;
  private static final int METHOD_getConditionForKeyStroke52 = 52;
  private static final int METHOD_firePropertyChange53 = 53;
  private static final int METHOD_registerKeyboardAction54 = 54;
  private static final int METHOD_registerKeyboardAction55 = 55;
  private static final int METHOD_isLightweightComponent56 = 56;
  private static final int METHOD_paint57 = 57;
  private static final int METHOD_createToolTip58 = 58;
  private static final int METHOD_print59 = 59;
  private static final int METHOD_update60 = 60;
  private static final int METHOD_paintImmediately61 = 61;
  private static final int METHOD_getInsets62 = 62;
  private static final int METHOD_printAll63 = 63;
  private static final int METHOD_contains64 = 64;
  private static final int METHOD_firePropertyChange65 = 65;
  private static final int METHOD_scrollRectToVisible66 = 66;
  private static final int METHOD_getComponentAt67 = 67;
  private static final int METHOD_add68 = 68;
  private static final int METHOD_preferredSize69 = 69;
  private static final int METHOD_locate70 = 70;
  private static final int METHOD_list71 = 71;
  private static final int METHOD_add72 = 72;
  private static final int METHOD_add73 = 73;
  private static final int METHOD_invalidate74 = 74;
  private static final int METHOD_printComponents75 = 75;
  private static final int METHOD_doLayout76 = 76;
  private static final int METHOD_layout77 = 77;
  private static final int METHOD_list78 = 78;
  private static final int METHOD_add79 = 79;
  private static final int METHOD_remove80 = 80;
  private static final int METHOD_isAncestorOf81 = 81;
  private static final int METHOD_findComponentAt82 = 82;
  private static final int METHOD_findComponentAt83 = 83;
  private static final int METHOD_insets84 = 84;
  private static final int METHOD_getComponentAt85 = 85;
  private static final int METHOD_paintComponents86 = 86;
  private static final int METHOD_countComponents87 = 87;
  private static final int METHOD_minimumSize88 = 88;
  private static final int METHOD_deliverEvent89 = 89;
  private static final int METHOD_removeAll90 = 90;
  private static final int METHOD_remove91 = 91;
  private static final int METHOD_add92 = 92;
  private static final int METHOD_validate93 = 93;
  private static final int METHOD_gotFocus94 = 94;
  private static final int METHOD_toString95 = 95;
  private static final int METHOD_list96 = 96;
  private static final int METHOD_enableInputMethods97 = 97;
  private static final int METHOD_mouseEnter98 = 98;
  private static final int METHOD_getSize99 = 99;
  private static final int METHOD_add100 = 100;
  private static final int METHOD_contains101 = 101;
  private static final int METHOD_transferFocus102 = 102;
  private static final int METHOD_action103 = 103;
  private static final int METHOD_setSize104 = 104;
  private static final int METHOD_show105 = 105;
  private static final int METHOD_mouseDown106 = 106;
  private static final int METHOD_imageUpdate107 = 107;
  private static final int METHOD_repaint108 = 108;
  private static final int METHOD_getFontMetrics109 = 109;
  private static final int METHOD_lostFocus110 = 110;
  private static final int METHOD_postEvent111 = 111;
  private static final int METHOD_show112 = 112;
  private static final int METHOD_handleEvent113 = 113;
  private static final int METHOD_list114 = 114;
  private static final int METHOD_setBounds115 = 115;
  private static final int METHOD_mouseDrag116 = 116;
  private static final int METHOD_enable117 = 117;
  private static final int METHOD_createImage118 = 118;
  private static final int METHOD_keyUp119 = 119;
  private static final int METHOD_createImage120 = 120;
  private static final int METHOD_setLocation121 = 121;
  private static final int METHOD_repaint122 = 122;
  private static final int METHOD_repaint123 = 123;
  private static final int METHOD_keyDown124 = 124;
  private static final int METHOD_nextFocus125 = 125;
  private static final int METHOD_bounds126 = 126;
  private static final int METHOD_move127 = 127;
  private static final int METHOD_prepareImage128 = 128;
  private static final int METHOD_prepareImage129 = 129;
  private static final int METHOD_resize130 = 130;
  private static final int METHOD_getLocation131 = 131;
  private static final int METHOD_remove132 = 132;
  private static final int METHOD_setSize133 = 133;
  private static final int METHOD_list134 = 134;
  private static final int METHOD_location135 = 135;
  private static final int METHOD_paintAll136 = 136;
  private static final int METHOD_dispatchEvent137 = 137;
  private static final int METHOD_checkImage138 = 138;
  private static final int METHOD_checkImage139 = 139;
  private static final int METHOD_mouseExit140 = 140;
  private static final int METHOD_mouseMove141 = 141;
  private static final int METHOD_setLocation142 = 142;
  private static final int METHOD_mouseUp143 = 143;
  private static final int METHOD_size144 = 144;
  private static final int METHOD_inside145 = 145;
  private static final int METHOD_resize146 = 146;

  // Method array 
  private static MethodDescriptor[] methods = new MethodDescriptor[147];

  static {
    try {
      methods[METHOD_contentsChanged0] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("contentsChanged", new Class[] {javax.swing.event.ListDataEvent.class}));
      methods[METHOD_contentsChanged0].setDisplayName ( "" );
      methods[METHOD_intervalRemoved1] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("intervalRemoved", new Class[] {javax.swing.event.ListDataEvent.class}));
      methods[METHOD_intervalRemoved1].setDisplayName ( "" );
      methods[METHOD_addItem2] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("addItem", new Class[] {java.lang.Object.class}));
      methods[METHOD_addItem2].setDisplayName ( "" );
      methods[METHOD_processKeyEvent3] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("processKeyEvent", new Class[] {java.awt.event.KeyEvent.class}));
      methods[METHOD_processKeyEvent3].setDisplayName ( "" );
      methods[METHOD_hidePopup4] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("hidePopup", new Class[] {}));
      methods[METHOD_hidePopup4].setDisplayName ( "" );
      methods[METHOD_updateUI5] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("updateUI", new Class[] {}));
      methods[METHOD_updateUI5].setDisplayName ( "" );
      methods[METHOD_showPopup6] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("showPopup", new Class[] {}));
      methods[METHOD_showPopup6].setDisplayName ( "" );
      methods[METHOD_removeAllItems7] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removeAllItems", new Class[] {}));
      methods[METHOD_removeAllItems7].setDisplayName ( "" );
      methods[METHOD_intervalAdded8] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("intervalAdded", new Class[] {javax.swing.event.ListDataEvent.class}));
      methods[METHOD_intervalAdded8].setDisplayName ( "" );
      methods[METHOD_configureEditor9] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("configureEditor", new Class[] {javax.swing.ComboBoxEditor.class, java.lang.Object.class}));
      methods[METHOD_configureEditor9].setDisplayName ( "" );
      methods[METHOD_removeItem10] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removeItem", new Class[] {java.lang.Object.class}));
      methods[METHOD_removeItem10].setDisplayName ( "" );
      methods[METHOD_removeItemAt11] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removeItemAt", new Class[] {Integer.TYPE}));
      methods[METHOD_removeItemAt11].setDisplayName ( "" );
      methods[METHOD_insertItemAt12] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("insertItemAt", new Class[] {java.lang.Object.class, Integer.TYPE}));
      methods[METHOD_insertItemAt12].setDisplayName ( "" );
      methods[METHOD_actionPerformed13] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("actionPerformed", new Class[] {java.awt.event.ActionEvent.class}));
      methods[METHOD_actionPerformed13].setDisplayName ( "" );
      methods[METHOD_selectWithKeyChar14] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("selectWithKeyChar", new Class[] {Character.TYPE}));
      methods[METHOD_selectWithKeyChar14].setDisplayName ( "" );
      methods[METHOD_hasFocus15] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("hasFocus", new Class[] {}));
      methods[METHOD_hasFocus15].setDisplayName ( "" );
      methods[METHOD_unregisterKeyboardAction16] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_unregisterKeyboardAction16].setDisplayName ( "" );
      methods[METHOD_revalidate17] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("revalidate", new Class[] {}));
      methods[METHOD_revalidate17].setDisplayName ( "" );
      methods[METHOD_getListeners18] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getListeners", new Class[] {java.lang.Class.class}));
      methods[METHOD_getListeners18].setDisplayName ( "" );
      methods[METHOD_getInputMap19] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getInputMap", new Class[] {}));
      methods[METHOD_getInputMap19].setDisplayName ( "" );
      methods[METHOD_removeNotify20] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removeNotify", new Class[] {}));
      methods[METHOD_removeNotify20].setDisplayName ( "" );
      methods[METHOD_getToolTipLocation21] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipLocation21].setDisplayName ( "" );
      methods[METHOD_getBounds22] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_getBounds22].setDisplayName ( "" );
      methods[METHOD_firePropertyChange23] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Double.TYPE, Double.TYPE}));
      methods[METHOD_firePropertyChange23].setDisplayName ( "" );
      methods[METHOD_getActionForKeyStroke24] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getActionForKeyStroke24].setDisplayName ( "" );
      methods[METHOD_firePropertyChange25] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Character.TYPE, Character.TYPE}));
      methods[METHOD_firePropertyChange25].setDisplayName ( "" );
      methods[METHOD_repaint26] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_repaint26].setDisplayName ( "" );
      methods[METHOD_getInputMap27] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getInputMap", new Class[] {Integer.TYPE}));
      methods[METHOD_getInputMap27].setDisplayName ( "" );
      methods[METHOD_firePropertyChange28] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Float.TYPE, Float.TYPE}));
      methods[METHOD_firePropertyChange28].setDisplayName ( "" );
      methods[METHOD_firePropertyChange29] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_firePropertyChange29].setDisplayName ( "" );
      methods[METHOD_repaint30] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("repaint", new Class[] {Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint30].setDisplayName ( "" );
      methods[METHOD_addPropertyChangeListener31] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_addPropertyChangeListener31].setDisplayName ( "" );
      methods[METHOD_computeVisibleRect32] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_computeVisibleRect32].setDisplayName ( "" );
      methods[METHOD_hide33] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("hide", new Class[] {}));
      methods[METHOD_hide33].setDisplayName ( "" );
      methods[METHOD_reshape34] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("reshape", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_reshape34].setDisplayName ( "" );
      methods[METHOD_putClientProperty35] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class}));
      methods[METHOD_putClientProperty35].setDisplayName ( "" );
      methods[METHOD_getLocation36] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_getLocation36].setDisplayName ( "" );
      methods[METHOD_setInputMap37] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setInputMap", new Class[] {Integer.TYPE, javax.swing.InputMap.class}));
      methods[METHOD_setInputMap37].setDisplayName ( "" );
      methods[METHOD_paintImmediately38] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_paintImmediately38].setDisplayName ( "" );
      methods[METHOD_disable39] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("disable", new Class[] {}));
      methods[METHOD_disable39].setDisplayName ( "" );
      methods[METHOD_resetKeyboardActions40] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("resetKeyboardActions", new Class[] {}));
      methods[METHOD_resetKeyboardActions40].setDisplayName ( "" );
      methods[METHOD_enable41] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("enable", new Class[] {}));
      methods[METHOD_enable41].setDisplayName ( "" );
      methods[METHOD_grabFocus42] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("grabFocus", new Class[] {}));
      methods[METHOD_grabFocus42].setDisplayName ( "" );
      methods[METHOD_getToolTipText43] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipText43].setDisplayName ( "" );
      methods[METHOD_getClientProperty44] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class}));
      methods[METHOD_getClientProperty44].setDisplayName ( "" );
      methods[METHOD_getSize45] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_getSize45].setDisplayName ( "" );
      methods[METHOD_firePropertyChange46] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Long.TYPE, Long.TYPE}));
      methods[METHOD_firePropertyChange46].setDisplayName ( "" );
      methods[METHOD_removePropertyChangeListener47] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_removePropertyChangeListener47].setDisplayName ( "" );
      methods[METHOD_requestDefaultFocus48] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("requestDefaultFocus", new Class[] {}));
      methods[METHOD_requestDefaultFocus48].setDisplayName ( "" );
      methods[METHOD_addNotify49] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("addNotify", new Class[] {}));
      methods[METHOD_addNotify49].setDisplayName ( "" );
      methods[METHOD_firePropertyChange50] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Byte.TYPE, Byte.TYPE}));
      methods[METHOD_firePropertyChange50].setDisplayName ( "" );
      methods[METHOD_requestFocus51] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("requestFocus", new Class[] {}));
      methods[METHOD_requestFocus51].setDisplayName ( "" );
      methods[METHOD_getConditionForKeyStroke52] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getConditionForKeyStroke52].setDisplayName ( "" );
      methods[METHOD_firePropertyChange53] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Short.TYPE, Short.TYPE}));
      methods[METHOD_firePropertyChange53].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction54] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction54].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction55] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction55].setDisplayName ( "" );
      methods[METHOD_isLightweightComponent56] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class}));
      methods[METHOD_isLightweightComponent56].setDisplayName ( "" );
      methods[METHOD_paint57] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("paint", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paint57].setDisplayName ( "" );
      methods[METHOD_createToolTip58] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("createToolTip", new Class[] {}));
      methods[METHOD_createToolTip58].setDisplayName ( "" );
      methods[METHOD_print59] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("print", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_print59].setDisplayName ( "" );
      methods[METHOD_update60] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("update", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_update60].setDisplayName ( "" );
      methods[METHOD_paintImmediately61] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("paintImmediately", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_paintImmediately61].setDisplayName ( "" );
      methods[METHOD_getInsets62] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getInsets", new Class[] {java.awt.Insets.class}));
      methods[METHOD_getInsets62].setDisplayName ( "" );
      methods[METHOD_printAll63] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("printAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printAll63].setDisplayName ( "" );
      methods[METHOD_contains64] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("contains", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_contains64].setDisplayName ( "" );
      methods[METHOD_firePropertyChange65] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Boolean.TYPE, Boolean.TYPE}));
      methods[METHOD_firePropertyChange65].setDisplayName ( "" );
      methods[METHOD_scrollRectToVisible66] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_scrollRectToVisible66].setDisplayName ( "" );
      methods[METHOD_getComponentAt67] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_getComponentAt67].setDisplayName ( "" );
      methods[METHOD_add68] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.awt.Component.class}));
      methods[METHOD_add68].setDisplayName ( "" );
      methods[METHOD_preferredSize69] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("preferredSize", new Class[] {}));
      methods[METHOD_preferredSize69].setDisplayName ( "" );
      methods[METHOD_locate70] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("locate", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_locate70].setDisplayName ( "" );
      methods[METHOD_list71] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("list", new Class[] {java.io.PrintWriter.class, Integer.TYPE}));
      methods[METHOD_list71].setDisplayName ( "" );
      methods[METHOD_add72] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, Integer.TYPE}));
      methods[METHOD_add72].setDisplayName ( "" );
      methods[METHOD_add73] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.awt.Component.class, Integer.TYPE}));
      methods[METHOD_add73].setDisplayName ( "" );
      methods[METHOD_invalidate74] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("invalidate", new Class[] {}));
      methods[METHOD_invalidate74].setDisplayName ( "" );
      methods[METHOD_printComponents75] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printComponents75].setDisplayName ( "" );
      methods[METHOD_doLayout76] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("doLayout", new Class[] {}));
      methods[METHOD_doLayout76].setDisplayName ( "" );
      methods[METHOD_layout77] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("layout", new Class[] {}));
      methods[METHOD_layout77].setDisplayName ( "" );
      methods[METHOD_list78] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("list", new Class[] {java.io.PrintStream.class, Integer.TYPE}));
      methods[METHOD_list78].setDisplayName ( "" );
      methods[METHOD_add79] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class}));
      methods[METHOD_add79].setDisplayName ( "" );
      methods[METHOD_remove80] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("remove", new Class[] {Integer.TYPE}));
      methods[METHOD_remove80].setDisplayName ( "" );
      methods[METHOD_isAncestorOf81] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class}));
      methods[METHOD_isAncestorOf81].setDisplayName ( "" );
      methods[METHOD_findComponentAt82] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("findComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_findComponentAt82].setDisplayName ( "" );
      methods[METHOD_findComponentAt83] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_findComponentAt83].setDisplayName ( "" );
      methods[METHOD_insets84] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("insets", new Class[] {}));
      methods[METHOD_insets84].setDisplayName ( "" );
      methods[METHOD_getComponentAt85] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getComponentAt85].setDisplayName ( "" );
      methods[METHOD_paintComponents86] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintComponents86].setDisplayName ( "" );
      methods[METHOD_countComponents87] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("countComponents", new Class[] {}));
      methods[METHOD_countComponents87].setDisplayName ( "" );
      methods[METHOD_minimumSize88] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("minimumSize", new Class[] {}));
      methods[METHOD_minimumSize88].setDisplayName ( "" );
      methods[METHOD_deliverEvent89] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_deliverEvent89].setDisplayName ( "" );
      methods[METHOD_removeAll90] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("removeAll", new Class[] {}));
      methods[METHOD_removeAll90].setDisplayName ( "" );
      methods[METHOD_remove91] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("remove", new Class[] {java.awt.Component.class}));
      methods[METHOD_remove91].setDisplayName ( "" );
      methods[METHOD_add92] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class}));
      methods[METHOD_add92].setDisplayName ( "" );
      methods[METHOD_validate93] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("validate", new Class[] {}));
      methods[METHOD_validate93].setDisplayName ( "" );
      methods[METHOD_gotFocus94] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_gotFocus94].setDisplayName ( "" );
      methods[METHOD_toString95] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("toString", new Class[] {}));
      methods[METHOD_toString95].setDisplayName ( "" );
      methods[METHOD_list96] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("list", new Class[] {java.io.PrintStream.class}));
      methods[METHOD_list96].setDisplayName ( "" );
      methods[METHOD_enableInputMethods97] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("enableInputMethods", new Class[] {Boolean.TYPE}));
      methods[METHOD_enableInputMethods97].setDisplayName ( "" );
      methods[METHOD_mouseEnter98] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseEnter98].setDisplayName ( "" );
      methods[METHOD_getSize99] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getSize", new Class[] {}));
      methods[METHOD_getSize99].setDisplayName ( "" );
      methods[METHOD_add100] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("add", new Class[] {java.awt.PopupMenu.class}));
      methods[METHOD_add100].setDisplayName ( "" );
      methods[METHOD_contains101] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("contains", new Class[] {java.awt.Point.class}));
      methods[METHOD_contains101].setDisplayName ( "" );
      methods[METHOD_transferFocus102] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("transferFocus", new Class[] {}));
      methods[METHOD_transferFocus102].setDisplayName ( "" );
      methods[METHOD_action103] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_action103].setDisplayName ( "" );
      methods[METHOD_setSize104] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setSize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setSize104].setDisplayName ( "" );
      methods[METHOD_show105] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("show", new Class[] {}));
      methods[METHOD_show105].setDisplayName ( "" );
      methods[METHOD_mouseDown106] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDown106].setDisplayName ( "" );
      methods[METHOD_imageUpdate107] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_imageUpdate107].setDisplayName ( "" );
      methods[METHOD_repaint108] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("repaint", new Class[] {Long.TYPE}));
      methods[METHOD_repaint108].setDisplayName ( "" );
      methods[METHOD_getFontMetrics109] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class}));
      methods[METHOD_getFontMetrics109].setDisplayName ( "" );
      methods[METHOD_lostFocus110] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_lostFocus110].setDisplayName ( "" );
      methods[METHOD_postEvent111] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("postEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_postEvent111].setDisplayName ( "" );
      methods[METHOD_show112] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("show", new Class[] {Boolean.TYPE}));
      methods[METHOD_show112].setDisplayName ( "" );
      methods[METHOD_handleEvent113] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("handleEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_handleEvent113].setDisplayName ( "" );
      methods[METHOD_list114] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("list", new Class[] {java.io.PrintWriter.class}));
      methods[METHOD_list114].setDisplayName ( "" );
      methods[METHOD_setBounds115] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setBounds", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setBounds115].setDisplayName ( "" );
      methods[METHOD_mouseDrag116] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDrag116].setDisplayName ( "" );
      methods[METHOD_enable117] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("enable", new Class[] {Boolean.TYPE}));
      methods[METHOD_enable117].setDisplayName ( "" );
      methods[METHOD_createImage118] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class}));
      methods[METHOD_createImage118].setDisplayName ( "" );
      methods[METHOD_keyUp119] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("keyUp", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyUp119].setDisplayName ( "" );
      methods[METHOD_createImage120] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("createImage", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_createImage120].setDisplayName ( "" );
      methods[METHOD_setLocation121] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setLocation", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setLocation121].setDisplayName ( "" );
      methods[METHOD_repaint122] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("repaint", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint122].setDisplayName ( "" );
      methods[METHOD_repaint123] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("repaint", new Class[] {}));
      methods[METHOD_repaint123].setDisplayName ( "" );
      methods[METHOD_keyDown124] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("keyDown", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyDown124].setDisplayName ( "" );
      methods[METHOD_nextFocus125] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("nextFocus", new Class[] {}));
      methods[METHOD_nextFocus125].setDisplayName ( "" );
      methods[METHOD_bounds126] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("bounds", new Class[] {}));
      methods[METHOD_bounds126].setDisplayName ( "" );
      methods[METHOD_move127] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("move", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_move127].setDisplayName ( "" );
      methods[METHOD_prepareImage128] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage128].setDisplayName ( "" );
      methods[METHOD_prepareImage129] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage129].setDisplayName ( "" );
      methods[METHOD_resize130] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("resize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_resize130].setDisplayName ( "" );
      methods[METHOD_getLocation131] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("getLocation", new Class[] {}));
      methods[METHOD_getLocation131].setDisplayName ( "" );
      methods[METHOD_remove132] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class}));
      methods[METHOD_remove132].setDisplayName ( "" );
      methods[METHOD_setSize133] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_setSize133].setDisplayName ( "" );
      methods[METHOD_list134] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("list", new Class[] {}));
      methods[METHOD_list134].setDisplayName ( "" );
      methods[METHOD_location135] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("location", new Class[] {}));
      methods[METHOD_location135].setDisplayName ( "" );
      methods[METHOD_paintAll136] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintAll136].setDisplayName ( "" );
      methods[METHOD_dispatchEvent137] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class}));
      methods[METHOD_dispatchEvent137].setDisplayName ( "" );
      methods[METHOD_checkImage138] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage138].setDisplayName ( "" );
      methods[METHOD_checkImage139] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("checkImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage139].setDisplayName ( "" );
      methods[METHOD_mouseExit140] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseExit140].setDisplayName ( "" );
      methods[METHOD_mouseMove141] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseMove141].setDisplayName ( "" );
      methods[METHOD_setLocation142] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("setLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_setLocation142].setDisplayName ( "" );
      methods[METHOD_mouseUp143] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseUp143].setDisplayName ( "" );
      methods[METHOD_size144] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("size", new Class[] {}));
      methods[METHOD_size144].setDisplayName ( "" );
      methods[METHOD_inside145] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("inside", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_inside145].setDisplayName ( "" );
      methods[METHOD_resize146] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputComboBox.class.getMethod("resize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_resize146].setDisplayName ( "" );
    }
    catch( Exception e) {}//GEN-HEADEREND:Methods

    // Here you can add code for customizing the methods array.
    
}//GEN-LAST:Methods

  private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
  private static final int defaultEventIndex = -1;//GEN-END:Idx


    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     * 
     * @return BeanDescriptor describing the editable
     * properties of this bean.  May return null if the
     * information should be obtained by automatic analysis.
     */
    public BeanDescriptor getBeanDescriptor() {
	return beanDescriptor;
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     * 
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean.  May return null if the
     * information should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will
     * belong to the IndexedPropertyDescriptor subclass of PropertyDescriptor.
     * A client of getPropertyDescriptors can use "instanceof" to check
     * if a given PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    public PropertyDescriptor[] getPropertyDescriptors() {
        return properties;
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     * 
     * @return  An array of EventSetDescriptors describing the kinds of 
     * events fired by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public EventSetDescriptor[] getEventSetDescriptors() {
        return eventSets;
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     * 
     * @return  An array of MethodDescriptors describing the methods 
     * implemented by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public MethodDescriptor[] getMethodDescriptors() {
        return methods;
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are 
     * customizing the bean.
     * @return  Index of default property in the PropertyDescriptor array
     * 		returned by getPropertyDescriptors.
     * <P>	Returns -1 if there is no default property.
     */
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will
     * mostly commonly be used by human's when using the bean. 
     * @return Index of default event in the EventSetDescriptor array
     *		returned by getEventSetDescriptors.
     * <P>	Returns -1 if there is no default event.
     */
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }
}

