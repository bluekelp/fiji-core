package com.SoftWoehr.FIJI;

import java.beans.*;

public class FijiPanelBeanInfo extends SimpleBeanInfo {


  // Bean descriptor //GEN-FIRST:BeanDescriptor
  private static BeanDescriptor beanDescriptor = new BeanDescriptor  ( FijiPanel.class , null );

  static {//GEN-HEADEREND:BeanDescriptor

    // Here you can add code for customizing the BeanDescriptor.

}//GEN-LAST:BeanDescriptor

  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY_doubleBuffered = 0;
  private static final int PROPERTY_inputVerifier = 1;
  private static final int PROPERTY_preferredSize = 2;
  private static final int PROPERTY_managingFocus = 3;
  private static final int PROPERTY_rootPane = 4;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 5;
  private static final int PROPERTY__text_area = 6;
  private static final int PROPERTY_componentOrientation = 7;
  private static final int PROPERTY_parent = 8;
  private static final int PROPERTY_y = 9;
  private static final int PROPERTY_x = 10;
  private static final int PROPERTY_treeLock = 11;
  private static final int PROPERTY_peer = 12;
  private static final int PROPERTY_bounds = 13;
  private static final int PROPERTY_foreground = 14;
  private static final int PROPERTY_alignmentY = 15;
  private static final int PROPERTY_alignmentX = 16;
  private static final int PROPERTY_paintingTile = 17;
  private static final int PROPERTY_accessibleContext = 18;
  private static final int PROPERTY_UIClassID = 19;
  private static final int PROPERTY_insets = 20;
  private static final int PROPERTY_registeredKeyStrokes = 21;
  private static final int PROPERTY_lightweight = 22;
  private static final int PROPERTY_displayable = 23;
  private static final int PROPERTY_validateRoot = 24;
  private static final int PROPERTY_preferredSizeSet = 25;
  private static final int PROPERTY_componentCount = 26;
  private static final int PROPERTY_topLevelAncestor = 27;
  private static final int PROPERTY_name = 28;
  private static final int PROPERTY_toolTipText = 29;
  private static final int PROPERTY_maximumSizeSet = 30;
  private static final int PROPERTY_border = 31;
  private static final int PROPERTY_visibleRect = 32;
  private static final int PROPERTY_colorModel = 33;
  private static final int PROPERTY_font = 34;
  private static final int PROPERTY_focusCycleRoot = 35;
  private static final int PROPERTY_dropTarget = 36;
  private static final int PROPERTY_maximumSize = 37;
  private static final int PROPERTY_enabled = 38;
  private static final int PROPERTY_width = 39;
  private static final int PROPERTY_toolkit = 40;
  private static final int PROPERTY_valid = 41;
  private static final int PROPERTY_autoscrolls = 42;
  private static final int PROPERTY_debugGraphicsOptions = 43;
  private static final int PROPERTY_inputMethodRequests = 44;
  private static final int PROPERTY_opaque = 45;
  private static final int PROPERTY_actionMap = 46;
  private static final int PROPERTY_height = 47;
  private static final int PROPERTY_background = 48;
  private static final int PROPERTY_locationOnScreen = 49;
  private static final int PROPERTY_requestFocusEnabled = 50;
  private static final int PROPERTY__input_panel = 51;
  private static final int PROPERTY_locale = 52;
  private static final int PROPERTY_graphics = 53;
  private static final int PROPERTY_minimumSizeSet = 54;
  private static final int PROPERTY_inputContext = 55;
  private static final int PROPERTY_visible = 56;
  private static final int PROPERTY_focusTraversable = 57;
  private static final int PROPERTY_showing = 58;
  private static final int PROPERTY_layout = 59;
  private static final int PROPERTY_optimizedDrawingEnabled = 60;
  private static final int PROPERTY_cursor = 61;
  private static final int PROPERTY_nextFocusableComponent = 62;
  private static final int PROPERTY_components = 63;
  private static final int PROPERTY_graphicsConfiguration = 64;
  private static final int PROPERTY_minimumSize = 65;
  private static final int PROPERTY_component = 66;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[67];

  static {
    try {
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", FijiPanel.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", FijiPanel.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", FijiPanel.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", FijiPanel.class, "isManagingFocus", null );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", FijiPanel.class, "getRootPane", null );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", FijiPanel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY__text_area] = new PropertyDescriptor ( "_text_area", FijiPanel.class, "get_text_area", null );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", FijiPanel.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", FijiPanel.class, "getParent", null );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", FijiPanel.class, "getY", null );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", FijiPanel.class, "getX", null );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", FijiPanel.class, "getTreeLock", null );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", FijiPanel.class, "getPeer", null );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", FijiPanel.class, "getBounds", "setBounds" );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", FijiPanel.class, "getForeground", "setForeground" );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", FijiPanel.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", FijiPanel.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", FijiPanel.class, "isPaintingTile", null );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", FijiPanel.class, "getAccessibleContext", null );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", FijiPanel.class, "getUIClassID", null );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", FijiPanel.class, "getInsets", null );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", FijiPanel.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", FijiPanel.class, "isLightweight", null );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", FijiPanel.class, "isDisplayable", null );
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", FijiPanel.class, "isValidateRoot", null );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", FijiPanel.class, "isPreferredSizeSet", null );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", FijiPanel.class, "getComponentCount", null );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", FijiPanel.class, "getTopLevelAncestor", null );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", FijiPanel.class, "getName", "setName" );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", FijiPanel.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", FijiPanel.class, "isMaximumSizeSet", null );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", FijiPanel.class, "getBorder", "setBorder" );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", FijiPanel.class, "getVisibleRect", null );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", FijiPanel.class, "getColorModel", null );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", FijiPanel.class, "getFont", "setFont" );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", FijiPanel.class, "isFocusCycleRoot", null );
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", FijiPanel.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", FijiPanel.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", FijiPanel.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", FijiPanel.class, "getWidth", null );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", FijiPanel.class, "getToolkit", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", FijiPanel.class, "isValid", null );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", FijiPanel.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", FijiPanel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", FijiPanel.class, "getInputMethodRequests", null );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", FijiPanel.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", FijiPanel.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", FijiPanel.class, "getHeight", null );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", FijiPanel.class, "getBackground", "setBackground" );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", FijiPanel.class, "getLocationOnScreen", null );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", FijiPanel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY__input_panel] = new PropertyDescriptor ( "_input_panel", FijiPanel.class, "get_input_panel", null );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", FijiPanel.class, "getLocale", "setLocale" );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", FijiPanel.class, "getGraphics", null );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", FijiPanel.class, "isMinimumSizeSet", null );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", FijiPanel.class, "getInputContext", null );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", FijiPanel.class, "isVisible", "setVisible" );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", FijiPanel.class, "isFocusTraversable", null );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", FijiPanel.class, "isShowing", null );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", FijiPanel.class, "getLayout", "setLayout" );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", FijiPanel.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", FijiPanel.class, "getCursor", "setCursor" );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", FijiPanel.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", FijiPanel.class, "getComponents", null );
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", FijiPanel.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", FijiPanel.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", FijiPanel.class, null, null, "getComponent", null );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Properties

    // Here you can add code for customizing the properties array.

}//GEN-LAST:Properties

  // EventSet identifiers//GEN-FIRST:Events
  private static final int EVENT_mouseMotionListener = 0;
  private static final int EVENT_ancestorListener = 1;
  private static final int EVENT_inputMethodListener = 2;
  private static final int EVENT_componentListener = 3;
  private static final int EVENT_hierarchyBoundsListener = 4;
  private static final int EVENT_mouseListener = 5;
  private static final int EVENT_focusListener = 6;
  private static final int EVENT_propertyChangeListener = 7;
  private static final int EVENT_keyListener = 8;
  private static final int EVENT_hierarchyListener = 9;
  private static final int EVENT_containerListener = 10;
  private static final int EVENT_vetoableChangeListener = 11;

  // EventSet array
  private static EventSetDescriptor[] eventSets = new EventSetDescriptor[12];

  static {
    try {
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentShown", "componentResized", "componentHidden", "componentMoved"}, "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorResized", "ancestorMoved"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseReleased", "mouseEntered", "mouseClicked", "mousePressed", "mouseExited"}, "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyReleased", "keyPressed", "keyTyped"}, "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentRemoved", "componentAdded"}, "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Events

    // Here you can add code for customizing the event sets array.

}//GEN-LAST:Events

  // Method identifiers //GEN-FIRST:Methods
  private static final int METHOD_updateUI0 = 0;
  private static final int METHOD_hasFocus1 = 1;
  private static final int METHOD_unregisterKeyboardAction2 = 2;
  private static final int METHOD_revalidate3 = 3;
  private static final int METHOD_getListeners4 = 4;
  private static final int METHOD_getInputMap5 = 5;
  private static final int METHOD_removeNotify6 = 6;
  private static final int METHOD_getToolTipLocation7 = 7;
  private static final int METHOD_getBounds8 = 8;
  private static final int METHOD_firePropertyChange9 = 9;
  private static final int METHOD_getActionForKeyStroke10 = 10;
  private static final int METHOD_firePropertyChange11 = 11;
  private static final int METHOD_repaint12 = 12;
  private static final int METHOD_getInputMap13 = 13;
  private static final int METHOD_firePropertyChange14 = 14;
  private static final int METHOD_firePropertyChange15 = 15;
  private static final int METHOD_repaint16 = 16;
  private static final int METHOD_addPropertyChangeListener17 = 17;
  private static final int METHOD_computeVisibleRect18 = 18;
  private static final int METHOD_hide19 = 19;
  private static final int METHOD_reshape20 = 20;
  private static final int METHOD_putClientProperty21 = 21;
  private static final int METHOD_getLocation22 = 22;
  private static final int METHOD_setInputMap23 = 23;
  private static final int METHOD_paintImmediately24 = 24;
  private static final int METHOD_disable25 = 25;
  private static final int METHOD_resetKeyboardActions26 = 26;
  private static final int METHOD_enable27 = 27;
  private static final int METHOD_grabFocus28 = 28;
  private static final int METHOD_getToolTipText29 = 29;
  private static final int METHOD_getClientProperty30 = 30;
  private static final int METHOD_getSize31 = 31;
  private static final int METHOD_firePropertyChange32 = 32;
  private static final int METHOD_removePropertyChangeListener33 = 33;
  private static final int METHOD_requestDefaultFocus34 = 34;
  private static final int METHOD_addNotify35 = 35;
  private static final int METHOD_firePropertyChange36 = 36;
  private static final int METHOD_requestFocus37 = 37;
  private static final int METHOD_getConditionForKeyStroke38 = 38;
  private static final int METHOD_firePropertyChange39 = 39;
  private static final int METHOD_registerKeyboardAction40 = 40;
  private static final int METHOD_registerKeyboardAction41 = 41;
  private static final int METHOD_isLightweightComponent42 = 42;
  private static final int METHOD_paint43 = 43;
  private static final int METHOD_createToolTip44 = 44;
  private static final int METHOD_print45 = 45;
  private static final int METHOD_update46 = 46;
  private static final int METHOD_paintImmediately47 = 47;
  private static final int METHOD_getInsets48 = 48;
  private static final int METHOD_printAll49 = 49;
  private static final int METHOD_contains50 = 50;
  private static final int METHOD_firePropertyChange51 = 51;
  private static final int METHOD_scrollRectToVisible52 = 52;
  private static final int METHOD_getComponentAt53 = 53;
  private static final int METHOD_add54 = 54;
  private static final int METHOD_preferredSize55 = 55;
  private static final int METHOD_locate56 = 56;
  private static final int METHOD_list57 = 57;
  private static final int METHOD_add58 = 58;
  private static final int METHOD_add59 = 59;
  private static final int METHOD_invalidate60 = 60;
  private static final int METHOD_printComponents61 = 61;
  private static final int METHOD_doLayout62 = 62;
  private static final int METHOD_layout63 = 63;
  private static final int METHOD_list64 = 64;
  private static final int METHOD_add65 = 65;
  private static final int METHOD_remove66 = 66;
  private static final int METHOD_isAncestorOf67 = 67;
  private static final int METHOD_findComponentAt68 = 68;
  private static final int METHOD_findComponentAt69 = 69;
  private static final int METHOD_insets70 = 70;
  private static final int METHOD_getComponentAt71 = 71;
  private static final int METHOD_paintComponents72 = 72;
  private static final int METHOD_countComponents73 = 73;
  private static final int METHOD_minimumSize74 = 74;
  private static final int METHOD_deliverEvent75 = 75;
  private static final int METHOD_removeAll76 = 76;
  private static final int METHOD_remove77 = 77;
  private static final int METHOD_add78 = 78;
  private static final int METHOD_validate79 = 79;
  private static final int METHOD_gotFocus80 = 80;
  private static final int METHOD_toString81 = 81;
  private static final int METHOD_list82 = 82;
  private static final int METHOD_enableInputMethods83 = 83;
  private static final int METHOD_mouseEnter84 = 84;
  private static final int METHOD_getSize85 = 85;
  private static final int METHOD_add86 = 86;
  private static final int METHOD_contains87 = 87;
  private static final int METHOD_transferFocus88 = 88;
  private static final int METHOD_action89 = 89;
  private static final int METHOD_setSize90 = 90;
  private static final int METHOD_show91 = 91;
  private static final int METHOD_mouseDown92 = 92;
  private static final int METHOD_imageUpdate93 = 93;
  private static final int METHOD_repaint94 = 94;
  private static final int METHOD_getFontMetrics95 = 95;
  private static final int METHOD_lostFocus96 = 96;
  private static final int METHOD_postEvent97 = 97;
  private static final int METHOD_show98 = 98;
  private static final int METHOD_handleEvent99 = 99;
  private static final int METHOD_list100 = 100;
  private static final int METHOD_setBounds101 = 101;
  private static final int METHOD_mouseDrag102 = 102;
  private static final int METHOD_enable103 = 103;
  private static final int METHOD_createImage104 = 104;
  private static final int METHOD_keyUp105 = 105;
  private static final int METHOD_createImage106 = 106;
  private static final int METHOD_setLocation107 = 107;
  private static final int METHOD_repaint108 = 108;
  private static final int METHOD_repaint109 = 109;
  private static final int METHOD_keyDown110 = 110;
  private static final int METHOD_nextFocus111 = 111;
  private static final int METHOD_bounds112 = 112;
  private static final int METHOD_move113 = 113;
  private static final int METHOD_prepareImage114 = 114;
  private static final int METHOD_prepareImage115 = 115;
  private static final int METHOD_resize116 = 116;
  private static final int METHOD_getLocation117 = 117;
  private static final int METHOD_remove118 = 118;
  private static final int METHOD_setSize119 = 119;
  private static final int METHOD_list120 = 120;
  private static final int METHOD_location121 = 121;
  private static final int METHOD_paintAll122 = 122;
  private static final int METHOD_dispatchEvent123 = 123;
  private static final int METHOD_checkImage124 = 124;
  private static final int METHOD_checkImage125 = 125;
  private static final int METHOD_mouseExit126 = 126;
  private static final int METHOD_mouseMove127 = 127;
  private static final int METHOD_setLocation128 = 128;
  private static final int METHOD_mouseUp129 = 129;
  private static final int METHOD_size130 = 130;
  private static final int METHOD_inside131 = 131;
  private static final int METHOD_resize132 = 132;

  // Method array 
  private static MethodDescriptor[] methods = new MethodDescriptor[133];

  static {
    try {
      methods[METHOD_updateUI0] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("updateUI", new Class[] {}));
      methods[METHOD_updateUI0].setDisplayName ( "" );
      methods[METHOD_hasFocus1] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("hasFocus", new Class[] {}));
      methods[METHOD_hasFocus1].setDisplayName ( "" );
      methods[METHOD_unregisterKeyboardAction2] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_unregisterKeyboardAction2].setDisplayName ( "" );
      methods[METHOD_revalidate3] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("revalidate", new Class[] {}));
      methods[METHOD_revalidate3].setDisplayName ( "" );
      methods[METHOD_getListeners4] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getListeners", new Class[] {java.lang.Class.class}));
      methods[METHOD_getListeners4].setDisplayName ( "" );
      methods[METHOD_getInputMap5] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getInputMap", new Class[] {}));
      methods[METHOD_getInputMap5].setDisplayName ( "" );
      methods[METHOD_removeNotify6] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("removeNotify", new Class[] {}));
      methods[METHOD_removeNotify6].setDisplayName ( "" );
      methods[METHOD_getToolTipLocation7] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipLocation7].setDisplayName ( "" );
      methods[METHOD_getBounds8] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_getBounds8].setDisplayName ( "" );
      methods[METHOD_firePropertyChange9] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Double.TYPE, Double.TYPE}));
      methods[METHOD_firePropertyChange9].setDisplayName ( "" );
      methods[METHOD_getActionForKeyStroke10] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getActionForKeyStroke10].setDisplayName ( "" );
      methods[METHOD_firePropertyChange11] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Character.TYPE, Character.TYPE}));
      methods[METHOD_firePropertyChange11].setDisplayName ( "" );
      methods[METHOD_repaint12] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_repaint12].setDisplayName ( "" );
      methods[METHOD_getInputMap13] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getInputMap", new Class[] {Integer.TYPE}));
      methods[METHOD_getInputMap13].setDisplayName ( "" );
      methods[METHOD_firePropertyChange14] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Float.TYPE, Float.TYPE}));
      methods[METHOD_firePropertyChange14].setDisplayName ( "" );
      methods[METHOD_firePropertyChange15] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_firePropertyChange15].setDisplayName ( "" );
      methods[METHOD_repaint16] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("repaint", new Class[] {Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint16].setDisplayName ( "" );
      methods[METHOD_addPropertyChangeListener17] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_addPropertyChangeListener17].setDisplayName ( "" );
      methods[METHOD_computeVisibleRect18] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_computeVisibleRect18].setDisplayName ( "" );
      methods[METHOD_hide19] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("hide", new Class[] {}));
      methods[METHOD_hide19].setDisplayName ( "" );
      methods[METHOD_reshape20] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("reshape", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_reshape20].setDisplayName ( "" );
      methods[METHOD_putClientProperty21] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class}));
      methods[METHOD_putClientProperty21].setDisplayName ( "" );
      methods[METHOD_getLocation22] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_getLocation22].setDisplayName ( "" );
      methods[METHOD_setInputMap23] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setInputMap", new Class[] {Integer.TYPE, javax.swing.InputMap.class}));
      methods[METHOD_setInputMap23].setDisplayName ( "" );
      methods[METHOD_paintImmediately24] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_paintImmediately24].setDisplayName ( "" );
      methods[METHOD_disable25] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("disable", new Class[] {}));
      methods[METHOD_disable25].setDisplayName ( "" );
      methods[METHOD_resetKeyboardActions26] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("resetKeyboardActions", new Class[] {}));
      methods[METHOD_resetKeyboardActions26].setDisplayName ( "" );
      methods[METHOD_enable27] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("enable", new Class[] {}));
      methods[METHOD_enable27].setDisplayName ( "" );
      methods[METHOD_grabFocus28] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("grabFocus", new Class[] {}));
      methods[METHOD_grabFocus28].setDisplayName ( "" );
      methods[METHOD_getToolTipText29] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipText29].setDisplayName ( "" );
      methods[METHOD_getClientProperty30] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class}));
      methods[METHOD_getClientProperty30].setDisplayName ( "" );
      methods[METHOD_getSize31] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_getSize31].setDisplayName ( "" );
      methods[METHOD_firePropertyChange32] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Long.TYPE, Long.TYPE}));
      methods[METHOD_firePropertyChange32].setDisplayName ( "" );
      methods[METHOD_removePropertyChangeListener33] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_removePropertyChangeListener33].setDisplayName ( "" );
      methods[METHOD_requestDefaultFocus34] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("requestDefaultFocus", new Class[] {}));
      methods[METHOD_requestDefaultFocus34].setDisplayName ( "" );
      methods[METHOD_addNotify35] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("addNotify", new Class[] {}));
      methods[METHOD_addNotify35].setDisplayName ( "" );
      methods[METHOD_firePropertyChange36] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Byte.TYPE, Byte.TYPE}));
      methods[METHOD_firePropertyChange36].setDisplayName ( "" );
      methods[METHOD_requestFocus37] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("requestFocus", new Class[] {}));
      methods[METHOD_requestFocus37].setDisplayName ( "" );
      methods[METHOD_getConditionForKeyStroke38] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getConditionForKeyStroke38].setDisplayName ( "" );
      methods[METHOD_firePropertyChange39] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Short.TYPE, Short.TYPE}));
      methods[METHOD_firePropertyChange39].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction40] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction40].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction41] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction41].setDisplayName ( "" );
      methods[METHOD_isLightweightComponent42] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class}));
      methods[METHOD_isLightweightComponent42].setDisplayName ( "" );
      methods[METHOD_paint43] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("paint", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paint43].setDisplayName ( "" );
      methods[METHOD_createToolTip44] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("createToolTip", new Class[] {}));
      methods[METHOD_createToolTip44].setDisplayName ( "" );
      methods[METHOD_print45] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("print", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_print45].setDisplayName ( "" );
      methods[METHOD_update46] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("update", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_update46].setDisplayName ( "" );
      methods[METHOD_paintImmediately47] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("paintImmediately", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_paintImmediately47].setDisplayName ( "" );
      methods[METHOD_getInsets48] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getInsets", new Class[] {java.awt.Insets.class}));
      methods[METHOD_getInsets48].setDisplayName ( "" );
      methods[METHOD_printAll49] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("printAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printAll49].setDisplayName ( "" );
      methods[METHOD_contains50] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("contains", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_contains50].setDisplayName ( "" );
      methods[METHOD_firePropertyChange51] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Boolean.TYPE, Boolean.TYPE}));
      methods[METHOD_firePropertyChange51].setDisplayName ( "" );
      methods[METHOD_scrollRectToVisible52] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_scrollRectToVisible52].setDisplayName ( "" );
      methods[METHOD_getComponentAt53] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_getComponentAt53].setDisplayName ( "" );
      methods[METHOD_add54] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.awt.Component.class}));
      methods[METHOD_add54].setDisplayName ( "" );
      methods[METHOD_preferredSize55] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("preferredSize", new Class[] {}));
      methods[METHOD_preferredSize55].setDisplayName ( "" );
      methods[METHOD_locate56] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("locate", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_locate56].setDisplayName ( "" );
      methods[METHOD_list57] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("list", new Class[] {java.io.PrintWriter.class, Integer.TYPE}));
      methods[METHOD_list57].setDisplayName ( "" );
      methods[METHOD_add58] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, Integer.TYPE}));
      methods[METHOD_add58].setDisplayName ( "" );
      methods[METHOD_add59] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.awt.Component.class, Integer.TYPE}));
      methods[METHOD_add59].setDisplayName ( "" );
      methods[METHOD_invalidate60] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("invalidate", new Class[] {}));
      methods[METHOD_invalidate60].setDisplayName ( "" );
      methods[METHOD_printComponents61] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printComponents61].setDisplayName ( "" );
      methods[METHOD_doLayout62] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("doLayout", new Class[] {}));
      methods[METHOD_doLayout62].setDisplayName ( "" );
      methods[METHOD_layout63] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("layout", new Class[] {}));
      methods[METHOD_layout63].setDisplayName ( "" );
      methods[METHOD_list64] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("list", new Class[] {java.io.PrintStream.class, Integer.TYPE}));
      methods[METHOD_list64].setDisplayName ( "" );
      methods[METHOD_add65] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class}));
      methods[METHOD_add65].setDisplayName ( "" );
      methods[METHOD_remove66] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("remove", new Class[] {Integer.TYPE}));
      methods[METHOD_remove66].setDisplayName ( "" );
      methods[METHOD_isAncestorOf67] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class}));
      methods[METHOD_isAncestorOf67].setDisplayName ( "" );
      methods[METHOD_findComponentAt68] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("findComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_findComponentAt68].setDisplayName ( "" );
      methods[METHOD_findComponentAt69] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_findComponentAt69].setDisplayName ( "" );
      methods[METHOD_insets70] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("insets", new Class[] {}));
      methods[METHOD_insets70].setDisplayName ( "" );
      methods[METHOD_getComponentAt71] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getComponentAt71].setDisplayName ( "" );
      methods[METHOD_paintComponents72] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintComponents72].setDisplayName ( "" );
      methods[METHOD_countComponents73] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("countComponents", new Class[] {}));
      methods[METHOD_countComponents73].setDisplayName ( "" );
      methods[METHOD_minimumSize74] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("minimumSize", new Class[] {}));
      methods[METHOD_minimumSize74].setDisplayName ( "" );
      methods[METHOD_deliverEvent75] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_deliverEvent75].setDisplayName ( "" );
      methods[METHOD_removeAll76] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("removeAll", new Class[] {}));
      methods[METHOD_removeAll76].setDisplayName ( "" );
      methods[METHOD_remove77] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("remove", new Class[] {java.awt.Component.class}));
      methods[METHOD_remove77].setDisplayName ( "" );
      methods[METHOD_add78] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class}));
      methods[METHOD_add78].setDisplayName ( "" );
      methods[METHOD_validate79] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("validate", new Class[] {}));
      methods[METHOD_validate79].setDisplayName ( "" );
      methods[METHOD_gotFocus80] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_gotFocus80].setDisplayName ( "" );
      methods[METHOD_toString81] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("toString", new Class[] {}));
      methods[METHOD_toString81].setDisplayName ( "" );
      methods[METHOD_list82] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("list", new Class[] {java.io.PrintStream.class}));
      methods[METHOD_list82].setDisplayName ( "" );
      methods[METHOD_enableInputMethods83] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("enableInputMethods", new Class[] {Boolean.TYPE}));
      methods[METHOD_enableInputMethods83].setDisplayName ( "" );
      methods[METHOD_mouseEnter84] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseEnter84].setDisplayName ( "" );
      methods[METHOD_getSize85] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getSize", new Class[] {}));
      methods[METHOD_getSize85].setDisplayName ( "" );
      methods[METHOD_add86] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("add", new Class[] {java.awt.PopupMenu.class}));
      methods[METHOD_add86].setDisplayName ( "" );
      methods[METHOD_contains87] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("contains", new Class[] {java.awt.Point.class}));
      methods[METHOD_contains87].setDisplayName ( "" );
      methods[METHOD_transferFocus88] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("transferFocus", new Class[] {}));
      methods[METHOD_transferFocus88].setDisplayName ( "" );
      methods[METHOD_action89] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_action89].setDisplayName ( "" );
      methods[METHOD_setSize90] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setSize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setSize90].setDisplayName ( "" );
      methods[METHOD_show91] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("show", new Class[] {}));
      methods[METHOD_show91].setDisplayName ( "" );
      methods[METHOD_mouseDown92] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDown92].setDisplayName ( "" );
      methods[METHOD_imageUpdate93] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_imageUpdate93].setDisplayName ( "" );
      methods[METHOD_repaint94] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("repaint", new Class[] {Long.TYPE}));
      methods[METHOD_repaint94].setDisplayName ( "" );
      methods[METHOD_getFontMetrics95] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class}));
      methods[METHOD_getFontMetrics95].setDisplayName ( "" );
      methods[METHOD_lostFocus96] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_lostFocus96].setDisplayName ( "" );
      methods[METHOD_postEvent97] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("postEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_postEvent97].setDisplayName ( "" );
      methods[METHOD_show98] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("show", new Class[] {Boolean.TYPE}));
      methods[METHOD_show98].setDisplayName ( "" );
      methods[METHOD_handleEvent99] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("handleEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_handleEvent99].setDisplayName ( "" );
      methods[METHOD_list100] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("list", new Class[] {java.io.PrintWriter.class}));
      methods[METHOD_list100].setDisplayName ( "" );
      methods[METHOD_setBounds101] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setBounds", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setBounds101].setDisplayName ( "" );
      methods[METHOD_mouseDrag102] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDrag102].setDisplayName ( "" );
      methods[METHOD_enable103] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("enable", new Class[] {Boolean.TYPE}));
      methods[METHOD_enable103].setDisplayName ( "" );
      methods[METHOD_createImage104] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class}));
      methods[METHOD_createImage104].setDisplayName ( "" );
      methods[METHOD_keyUp105] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("keyUp", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyUp105].setDisplayName ( "" );
      methods[METHOD_createImage106] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("createImage", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_createImage106].setDisplayName ( "" );
      methods[METHOD_setLocation107] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setLocation", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setLocation107].setDisplayName ( "" );
      methods[METHOD_repaint108] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("repaint", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint108].setDisplayName ( "" );
      methods[METHOD_repaint109] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("repaint", new Class[] {}));
      methods[METHOD_repaint109].setDisplayName ( "" );
      methods[METHOD_keyDown110] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("keyDown", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyDown110].setDisplayName ( "" );
      methods[METHOD_nextFocus111] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("nextFocus", new Class[] {}));
      methods[METHOD_nextFocus111].setDisplayName ( "" );
      methods[METHOD_bounds112] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("bounds", new Class[] {}));
      methods[METHOD_bounds112].setDisplayName ( "" );
      methods[METHOD_move113] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("move", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_move113].setDisplayName ( "" );
      methods[METHOD_prepareImage114] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage114].setDisplayName ( "" );
      methods[METHOD_prepareImage115] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage115].setDisplayName ( "" );
      methods[METHOD_resize116] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("resize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_resize116].setDisplayName ( "" );
      methods[METHOD_getLocation117] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("getLocation", new Class[] {}));
      methods[METHOD_getLocation117].setDisplayName ( "" );
      methods[METHOD_remove118] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class}));
      methods[METHOD_remove118].setDisplayName ( "" );
      methods[METHOD_setSize119] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_setSize119].setDisplayName ( "" );
      methods[METHOD_list120] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("list", new Class[] {}));
      methods[METHOD_list120].setDisplayName ( "" );
      methods[METHOD_location121] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("location", new Class[] {}));
      methods[METHOD_location121].setDisplayName ( "" );
      methods[METHOD_paintAll122] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintAll122].setDisplayName ( "" );
      methods[METHOD_dispatchEvent123] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class}));
      methods[METHOD_dispatchEvent123].setDisplayName ( "" );
      methods[METHOD_checkImage124] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage124].setDisplayName ( "" );
      methods[METHOD_checkImage125] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("checkImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage125].setDisplayName ( "" );
      methods[METHOD_mouseExit126] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseExit126].setDisplayName ( "" );
      methods[METHOD_mouseMove127] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseMove127].setDisplayName ( "" );
      methods[METHOD_setLocation128] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("setLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_setLocation128].setDisplayName ( "" );
      methods[METHOD_mouseUp129] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseUp129].setDisplayName ( "" );
      methods[METHOD_size130] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("size", new Class[] {}));
      methods[METHOD_size130].setDisplayName ( "" );
      methods[METHOD_inside131] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("inside", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_inside131].setDisplayName ( "" );
      methods[METHOD_resize132] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiPanel.class.getMethod("resize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_resize132].setDisplayName ( "" );
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

