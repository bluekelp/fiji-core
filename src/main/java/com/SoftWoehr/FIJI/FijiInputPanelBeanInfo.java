package com.SoftWoehr.FIJI;

import java.beans.*;

public class FijiInputPanelBeanInfo extends SimpleBeanInfo {


  // Bean descriptor //GEN-FIRST:BeanDescriptor
  private static BeanDescriptor beanDescriptor = new BeanDescriptor  ( FijiInputPanel.class , null );

  static {//GEN-HEADEREND:BeanDescriptor

    // Here you can add code for customizing the BeanDescriptor.

}//GEN-LAST:BeanDescriptor

  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY_components = 0;
  private static final int PROPERTY_focusTraversable = 1;
  private static final int PROPERTY_layout = 2;
  private static final int PROPERTY_optimizedDrawingEnabled = 3;
  private static final int PROPERTY_dropTarget = 4;
  private static final int PROPERTY_border = 5;
  private static final int PROPERTY_y = 6;
  private static final int PROPERTY_x = 7;
  private static final int PROPERTY_visible = 8;
  private static final int PROPERTY_requestFocusEnabled = 9;
  private static final int PROPERTY_colorModel = 10;
  private static final int PROPERTY_managingFocus = 11;
  private static final int PROPERTY_background = 12;
  private static final int PROPERTY_foreground = 13;
  private static final int PROPERTY_rootPane = 14;
  private static final int PROPERTY_debugGraphicsOptions = 15;
  private static final int PROPERTY_name = 16;
  private static final int PROPERTY_graphicsConfiguration = 17;
  private static final int PROPERTY_preferredSizeSet = 18;
  private static final int PROPERTY_toolkit = 19;
  private static final int PROPERTY_enabled = 20;
  private static final int PROPERTY_lightweight = 21;
  private static final int PROPERTY_inputMethodRequests = 22;
  private static final int PROPERTY_font = 23;
  private static final int PROPERTY_registeredKeyStrokes = 24;
  private static final int PROPERTY_bounds = 25;
  private static final int PROPERTY_treeLock = 26;
  private static final int PROPERTY_showing = 27;
  private static final int PROPERTY_doubleBuffered = 28;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 29;
  private static final int PROPERTY_visibleRect = 30;
  private static final int PROPERTY_inputContext = 31;
  private static final int PROPERTY_displayable = 32;
  private static final int PROPERTY_accessibleContext = 33;
  private static final int PROPERTY_nextFocusableComponent = 34;
  private static final int PROPERTY_componentOrientation = 35;
  private static final int PROPERTY_graphics = 36;
  private static final int PROPERTY_peer = 37;
  private static final int PROPERTY_componentCount = 38;
  private static final int PROPERTY_locationOnScreen = 39;
  private static final int PROPERTY_toolTipText = 40;
  private static final int PROPERTY_alignmentY = 41;
  private static final int PROPERTY_alignmentX = 42;
  private static final int PROPERTY_minimumSizeSet = 43;
  private static final int PROPERTY_cursor = 44;
  private static final int PROPERTY_parent = 45;
  private static final int PROPERTY_maximumSizeSet = 46;
  private static final int PROPERTY_maximumSize = 47;
  private static final int PROPERTY_inputVerifier = 48;
  private static final int PROPERTY_minimumSize = 49;
  private static final int PROPERTY_height = 50;
  private static final int PROPERTY_actionMap = 51;
  private static final int PROPERTY_paintingTile = 52;
  private static final int PROPERTY_autoscrolls = 53;
  private static final int PROPERTY_width = 54;
  private static final int PROPERTY_insets = 55;
  private static final int PROPERTY_valid = 56;
  private static final int PROPERTY_locale = 57;
  private static final int PROPERTY_preferredSize = 58;
  private static final int PROPERTY_opaque = 59;
  private static final int PROPERTY_validateRoot = 60;
  private static final int PROPERTY_UIClassID = 61;
  private static final int PROPERTY_topLevelAncestor = 62;
  private static final int PROPERTY_focusCycleRoot = 63;
  private static final int PROPERTY_component = 64;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[65];

  static {
    try {
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", FijiInputPanel.class, "getComponents", null );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", FijiInputPanel.class, "isFocusTraversable", null );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", FijiInputPanel.class, "getLayout", "setLayout" );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", FijiInputPanel.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", FijiInputPanel.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", FijiInputPanel.class, "getBorder", "setBorder" );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", FijiInputPanel.class, "getY", null );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", FijiInputPanel.class, "getX", null );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", FijiInputPanel.class, "isVisible", "setVisible" );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", FijiInputPanel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", FijiInputPanel.class, "getColorModel", null );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", FijiInputPanel.class, "isManagingFocus", null );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", FijiInputPanel.class, "getBackground", "setBackground" );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", FijiInputPanel.class, "getForeground", "setForeground" );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", FijiInputPanel.class, "getRootPane", null );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", FijiInputPanel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", FijiInputPanel.class, "getName", "setName" );
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", FijiInputPanel.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", FijiInputPanel.class, "isPreferredSizeSet", null );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", FijiInputPanel.class, "getToolkit", null );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", FijiInputPanel.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", FijiInputPanel.class, "isLightweight", null );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", FijiInputPanel.class, "getInputMethodRequests", null );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", FijiInputPanel.class, "getFont", "setFont" );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", FijiInputPanel.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", FijiInputPanel.class, "getBounds", "setBounds" );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", FijiInputPanel.class, "getTreeLock", null );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", FijiInputPanel.class, "isShowing", null );
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", FijiInputPanel.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", FijiInputPanel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", FijiInputPanel.class, "getVisibleRect", null );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", FijiInputPanel.class, "getInputContext", null );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", FijiInputPanel.class, "isDisplayable", null );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", FijiInputPanel.class, "getAccessibleContext", null );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", FijiInputPanel.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", FijiInputPanel.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", FijiInputPanel.class, "getGraphics", null );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", FijiInputPanel.class, "getPeer", null );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", FijiInputPanel.class, "getComponentCount", null );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", FijiInputPanel.class, "getLocationOnScreen", null );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", FijiInputPanel.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", FijiInputPanel.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", FijiInputPanel.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", FijiInputPanel.class, "isMinimumSizeSet", null );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", FijiInputPanel.class, "getCursor", "setCursor" );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", FijiInputPanel.class, "getParent", null );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", FijiInputPanel.class, "isMaximumSizeSet", null );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", FijiInputPanel.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", FijiInputPanel.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", FijiInputPanel.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", FijiInputPanel.class, "getHeight", null );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", FijiInputPanel.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", FijiInputPanel.class, "isPaintingTile", null );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", FijiInputPanel.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", FijiInputPanel.class, "getWidth", null );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", FijiInputPanel.class, "getInsets", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", FijiInputPanel.class, "isValid", null );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", FijiInputPanel.class, "getLocale", "setLocale" );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", FijiInputPanel.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", FijiInputPanel.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", FijiInputPanel.class, "isValidateRoot", null );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", FijiInputPanel.class, "getUIClassID", null );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", FijiInputPanel.class, "getTopLevelAncestor", null );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", FijiInputPanel.class, "isFocusCycleRoot", null );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", FijiInputPanel.class, null, null, "getComponent", null );
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
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentShown", "componentResized", "componentHidden", "componentMoved"}, "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorResized", "ancestorMoved"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseReleased", "mouseEntered", "mouseClicked", "mousePressed", "mouseExited"}, "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyReleased", "keyPressed", "keyTyped"}, "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentRemoved", "componentAdded"}, "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" );
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
      methods[METHOD_updateUI0] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("updateUI", new Class[] {}));
      methods[METHOD_updateUI0].setDisplayName ( "" );
      methods[METHOD_hasFocus1] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("hasFocus", new Class[] {}));
      methods[METHOD_hasFocus1].setDisplayName ( "" );
      methods[METHOD_unregisterKeyboardAction2] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_unregisterKeyboardAction2].setDisplayName ( "" );
      methods[METHOD_revalidate3] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("revalidate", new Class[] {}));
      methods[METHOD_revalidate3].setDisplayName ( "" );
      methods[METHOD_getListeners4] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getListeners", new Class[] {java.lang.Class.class}));
      methods[METHOD_getListeners4].setDisplayName ( "" );
      methods[METHOD_getInputMap5] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getInputMap", new Class[] {}));
      methods[METHOD_getInputMap5].setDisplayName ( "" );
      methods[METHOD_removeNotify6] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("removeNotify", new Class[] {}));
      methods[METHOD_removeNotify6].setDisplayName ( "" );
      methods[METHOD_getToolTipLocation7] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipLocation7].setDisplayName ( "" );
      methods[METHOD_getBounds8] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_getBounds8].setDisplayName ( "" );
      methods[METHOD_firePropertyChange9] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Double.TYPE, Double.TYPE}));
      methods[METHOD_firePropertyChange9].setDisplayName ( "" );
      methods[METHOD_getActionForKeyStroke10] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getActionForKeyStroke10].setDisplayName ( "" );
      methods[METHOD_firePropertyChange11] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Character.TYPE, Character.TYPE}));
      methods[METHOD_firePropertyChange11].setDisplayName ( "" );
      methods[METHOD_repaint12] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_repaint12].setDisplayName ( "" );
      methods[METHOD_getInputMap13] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getInputMap", new Class[] {Integer.TYPE}));
      methods[METHOD_getInputMap13].setDisplayName ( "" );
      methods[METHOD_firePropertyChange14] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Float.TYPE, Float.TYPE}));
      methods[METHOD_firePropertyChange14].setDisplayName ( "" );
      methods[METHOD_firePropertyChange15] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_firePropertyChange15].setDisplayName ( "" );
      methods[METHOD_repaint16] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("repaint", new Class[] {Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint16].setDisplayName ( "" );
      methods[METHOD_addPropertyChangeListener17] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_addPropertyChangeListener17].setDisplayName ( "" );
      methods[METHOD_computeVisibleRect18] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_computeVisibleRect18].setDisplayName ( "" );
      methods[METHOD_hide19] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("hide", new Class[] {}));
      methods[METHOD_hide19].setDisplayName ( "" );
      methods[METHOD_reshape20] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("reshape", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_reshape20].setDisplayName ( "" );
      methods[METHOD_putClientProperty21] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class}));
      methods[METHOD_putClientProperty21].setDisplayName ( "" );
      methods[METHOD_getLocation22] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_getLocation22].setDisplayName ( "" );
      methods[METHOD_setInputMap23] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setInputMap", new Class[] {Integer.TYPE, javax.swing.InputMap.class}));
      methods[METHOD_setInputMap23].setDisplayName ( "" );
      methods[METHOD_paintImmediately24] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_paintImmediately24].setDisplayName ( "" );
      methods[METHOD_disable25] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("disable", new Class[] {}));
      methods[METHOD_disable25].setDisplayName ( "" );
      methods[METHOD_resetKeyboardActions26] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("resetKeyboardActions", new Class[] {}));
      methods[METHOD_resetKeyboardActions26].setDisplayName ( "" );
      methods[METHOD_enable27] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("enable", new Class[] {}));
      methods[METHOD_enable27].setDisplayName ( "" );
      methods[METHOD_grabFocus28] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("grabFocus", new Class[] {}));
      methods[METHOD_grabFocus28].setDisplayName ( "" );
      methods[METHOD_getToolTipText29] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipText29].setDisplayName ( "" );
      methods[METHOD_getClientProperty30] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class}));
      methods[METHOD_getClientProperty30].setDisplayName ( "" );
      methods[METHOD_getSize31] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_getSize31].setDisplayName ( "" );
      methods[METHOD_firePropertyChange32] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Long.TYPE, Long.TYPE}));
      methods[METHOD_firePropertyChange32].setDisplayName ( "" );
      methods[METHOD_removePropertyChangeListener33] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_removePropertyChangeListener33].setDisplayName ( "" );
      methods[METHOD_requestDefaultFocus34] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("requestDefaultFocus", new Class[] {}));
      methods[METHOD_requestDefaultFocus34].setDisplayName ( "" );
      methods[METHOD_addNotify35] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("addNotify", new Class[] {}));
      methods[METHOD_addNotify35].setDisplayName ( "" );
      methods[METHOD_firePropertyChange36] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Byte.TYPE, Byte.TYPE}));
      methods[METHOD_firePropertyChange36].setDisplayName ( "" );
      methods[METHOD_requestFocus37] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("requestFocus", new Class[] {}));
      methods[METHOD_requestFocus37].setDisplayName ( "" );
      methods[METHOD_getConditionForKeyStroke38] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getConditionForKeyStroke38].setDisplayName ( "" );
      methods[METHOD_firePropertyChange39] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Short.TYPE, Short.TYPE}));
      methods[METHOD_firePropertyChange39].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction40] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction40].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction41] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction41].setDisplayName ( "" );
      methods[METHOD_isLightweightComponent42] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class}));
      methods[METHOD_isLightweightComponent42].setDisplayName ( "" );
      methods[METHOD_paint43] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("paint", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paint43].setDisplayName ( "" );
      methods[METHOD_createToolTip44] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("createToolTip", new Class[] {}));
      methods[METHOD_createToolTip44].setDisplayName ( "" );
      methods[METHOD_print45] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("print", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_print45].setDisplayName ( "" );
      methods[METHOD_update46] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("update", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_update46].setDisplayName ( "" );
      methods[METHOD_paintImmediately47] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("paintImmediately", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_paintImmediately47].setDisplayName ( "" );
      methods[METHOD_getInsets48] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getInsets", new Class[] {java.awt.Insets.class}));
      methods[METHOD_getInsets48].setDisplayName ( "" );
      methods[METHOD_printAll49] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("printAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printAll49].setDisplayName ( "" );
      methods[METHOD_contains50] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("contains", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_contains50].setDisplayName ( "" );
      methods[METHOD_firePropertyChange51] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Boolean.TYPE, Boolean.TYPE}));
      methods[METHOD_firePropertyChange51].setDisplayName ( "" );
      methods[METHOD_scrollRectToVisible52] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_scrollRectToVisible52].setDisplayName ( "" );
      methods[METHOD_getComponentAt53] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_getComponentAt53].setDisplayName ( "" );
      methods[METHOD_add54] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.awt.Component.class}));
      methods[METHOD_add54].setDisplayName ( "" );
      methods[METHOD_preferredSize55] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("preferredSize", new Class[] {}));
      methods[METHOD_preferredSize55].setDisplayName ( "" );
      methods[METHOD_locate56] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("locate", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_locate56].setDisplayName ( "" );
      methods[METHOD_list57] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("list", new Class[] {java.io.PrintWriter.class, Integer.TYPE}));
      methods[METHOD_list57].setDisplayName ( "" );
      methods[METHOD_add58] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, Integer.TYPE}));
      methods[METHOD_add58].setDisplayName ( "" );
      methods[METHOD_add59] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.awt.Component.class, Integer.TYPE}));
      methods[METHOD_add59].setDisplayName ( "" );
      methods[METHOD_invalidate60] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("invalidate", new Class[] {}));
      methods[METHOD_invalidate60].setDisplayName ( "" );
      methods[METHOD_printComponents61] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printComponents61].setDisplayName ( "" );
      methods[METHOD_doLayout62] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("doLayout", new Class[] {}));
      methods[METHOD_doLayout62].setDisplayName ( "" );
      methods[METHOD_layout63] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("layout", new Class[] {}));
      methods[METHOD_layout63].setDisplayName ( "" );
      methods[METHOD_list64] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("list", new Class[] {java.io.PrintStream.class, Integer.TYPE}));
      methods[METHOD_list64].setDisplayName ( "" );
      methods[METHOD_add65] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class}));
      methods[METHOD_add65].setDisplayName ( "" );
      methods[METHOD_remove66] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("remove", new Class[] {Integer.TYPE}));
      methods[METHOD_remove66].setDisplayName ( "" );
      methods[METHOD_isAncestorOf67] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class}));
      methods[METHOD_isAncestorOf67].setDisplayName ( "" );
      methods[METHOD_findComponentAt68] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("findComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_findComponentAt68].setDisplayName ( "" );
      methods[METHOD_findComponentAt69] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_findComponentAt69].setDisplayName ( "" );
      methods[METHOD_insets70] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("insets", new Class[] {}));
      methods[METHOD_insets70].setDisplayName ( "" );
      methods[METHOD_getComponentAt71] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getComponentAt71].setDisplayName ( "" );
      methods[METHOD_paintComponents72] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintComponents72].setDisplayName ( "" );
      methods[METHOD_countComponents73] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("countComponents", new Class[] {}));
      methods[METHOD_countComponents73].setDisplayName ( "" );
      methods[METHOD_minimumSize74] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("minimumSize", new Class[] {}));
      methods[METHOD_minimumSize74].setDisplayName ( "" );
      methods[METHOD_deliverEvent75] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_deliverEvent75].setDisplayName ( "" );
      methods[METHOD_removeAll76] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("removeAll", new Class[] {}));
      methods[METHOD_removeAll76].setDisplayName ( "" );
      methods[METHOD_remove77] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("remove", new Class[] {java.awt.Component.class}));
      methods[METHOD_remove77].setDisplayName ( "" );
      methods[METHOD_add78] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class}));
      methods[METHOD_add78].setDisplayName ( "" );
      methods[METHOD_validate79] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("validate", new Class[] {}));
      methods[METHOD_validate79].setDisplayName ( "" );
      methods[METHOD_gotFocus80] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_gotFocus80].setDisplayName ( "" );
      methods[METHOD_toString81] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("toString", new Class[] {}));
      methods[METHOD_toString81].setDisplayName ( "" );
      methods[METHOD_list82] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("list", new Class[] {java.io.PrintStream.class}));
      methods[METHOD_list82].setDisplayName ( "" );
      methods[METHOD_enableInputMethods83] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("enableInputMethods", new Class[] {Boolean.TYPE}));
      methods[METHOD_enableInputMethods83].setDisplayName ( "" );
      methods[METHOD_mouseEnter84] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseEnter84].setDisplayName ( "" );
      methods[METHOD_getSize85] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getSize", new Class[] {}));
      methods[METHOD_getSize85].setDisplayName ( "" );
      methods[METHOD_add86] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("add", new Class[] {java.awt.PopupMenu.class}));
      methods[METHOD_add86].setDisplayName ( "" );
      methods[METHOD_contains87] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("contains", new Class[] {java.awt.Point.class}));
      methods[METHOD_contains87].setDisplayName ( "" );
      methods[METHOD_transferFocus88] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("transferFocus", new Class[] {}));
      methods[METHOD_transferFocus88].setDisplayName ( "" );
      methods[METHOD_action89] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_action89].setDisplayName ( "" );
      methods[METHOD_setSize90] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setSize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setSize90].setDisplayName ( "" );
      methods[METHOD_show91] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("show", new Class[] {}));
      methods[METHOD_show91].setDisplayName ( "" );
      methods[METHOD_mouseDown92] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDown92].setDisplayName ( "" );
      methods[METHOD_imageUpdate93] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_imageUpdate93].setDisplayName ( "" );
      methods[METHOD_repaint94] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("repaint", new Class[] {Long.TYPE}));
      methods[METHOD_repaint94].setDisplayName ( "" );
      methods[METHOD_getFontMetrics95] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class}));
      methods[METHOD_getFontMetrics95].setDisplayName ( "" );
      methods[METHOD_lostFocus96] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_lostFocus96].setDisplayName ( "" );
      methods[METHOD_postEvent97] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("postEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_postEvent97].setDisplayName ( "" );
      methods[METHOD_show98] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("show", new Class[] {Boolean.TYPE}));
      methods[METHOD_show98].setDisplayName ( "" );
      methods[METHOD_handleEvent99] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("handleEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_handleEvent99].setDisplayName ( "" );
      methods[METHOD_list100] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("list", new Class[] {java.io.PrintWriter.class}));
      methods[METHOD_list100].setDisplayName ( "" );
      methods[METHOD_setBounds101] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setBounds", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setBounds101].setDisplayName ( "" );
      methods[METHOD_mouseDrag102] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDrag102].setDisplayName ( "" );
      methods[METHOD_enable103] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("enable", new Class[] {Boolean.TYPE}));
      methods[METHOD_enable103].setDisplayName ( "" );
      methods[METHOD_createImage104] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class}));
      methods[METHOD_createImage104].setDisplayName ( "" );
      methods[METHOD_keyUp105] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("keyUp", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyUp105].setDisplayName ( "" );
      methods[METHOD_createImage106] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("createImage", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_createImage106].setDisplayName ( "" );
      methods[METHOD_setLocation107] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setLocation", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setLocation107].setDisplayName ( "" );
      methods[METHOD_repaint108] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("repaint", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint108].setDisplayName ( "" );
      methods[METHOD_repaint109] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("repaint", new Class[] {}));
      methods[METHOD_repaint109].setDisplayName ( "" );
      methods[METHOD_keyDown110] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("keyDown", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyDown110].setDisplayName ( "" );
      methods[METHOD_nextFocus111] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("nextFocus", new Class[] {}));
      methods[METHOD_nextFocus111].setDisplayName ( "" );
      methods[METHOD_bounds112] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("bounds", new Class[] {}));
      methods[METHOD_bounds112].setDisplayName ( "" );
      methods[METHOD_move113] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("move", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_move113].setDisplayName ( "" );
      methods[METHOD_prepareImage114] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage114].setDisplayName ( "" );
      methods[METHOD_prepareImage115] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage115].setDisplayName ( "" );
      methods[METHOD_resize116] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("resize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_resize116].setDisplayName ( "" );
      methods[METHOD_getLocation117] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("getLocation", new Class[] {}));
      methods[METHOD_getLocation117].setDisplayName ( "" );
      methods[METHOD_remove118] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class}));
      methods[METHOD_remove118].setDisplayName ( "" );
      methods[METHOD_setSize119] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_setSize119].setDisplayName ( "" );
      methods[METHOD_list120] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("list", new Class[] {}));
      methods[METHOD_list120].setDisplayName ( "" );
      methods[METHOD_location121] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("location", new Class[] {}));
      methods[METHOD_location121].setDisplayName ( "" );
      methods[METHOD_paintAll122] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintAll122].setDisplayName ( "" );
      methods[METHOD_dispatchEvent123] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class}));
      methods[METHOD_dispatchEvent123].setDisplayName ( "" );
      methods[METHOD_checkImage124] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage124].setDisplayName ( "" );
      methods[METHOD_checkImage125] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("checkImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage125].setDisplayName ( "" );
      methods[METHOD_mouseExit126] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseExit126].setDisplayName ( "" );
      methods[METHOD_mouseMove127] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseMove127].setDisplayName ( "" );
      methods[METHOD_setLocation128] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("setLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_setLocation128].setDisplayName ( "" );
      methods[METHOD_mouseUp129] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseUp129].setDisplayName ( "" );
      methods[METHOD_size130] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("size", new Class[] {}));
      methods[METHOD_size130].setDisplayName ( "" );
      methods[METHOD_inside131] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("inside", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_inside131].setDisplayName ( "" );
      methods[METHOD_resize132] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiInputPanel.class.getMethod("resize", new Class[] {java.awt.Dimension.class}));
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

