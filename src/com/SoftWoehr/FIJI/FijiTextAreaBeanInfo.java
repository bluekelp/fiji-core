package com.SoftWoehr.FIJI;

import java.beans.*;

public class FijiTextAreaBeanInfo extends SimpleBeanInfo {


  // Bean descriptor //GEN-FIRST:BeanDescriptor
  private static BeanDescriptor beanDescriptor = new BeanDescriptor  ( FijiTextArea.class , null );

  static {//GEN-HEADEREND:BeanDescriptor

    // Here you can add code for customizing the BeanDescriptor.

}//GEN-LAST:BeanDescriptor

  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY__key_processor = 0;
  private static final int PROPERTY_height = 1;
  private static final int PROPERTY_selectionStart = 2;
  private static final int PROPERTY_requestFocusEnabled = 3;
  private static final int PROPERTY_scrollableTracksViewportHeight = 4;
  private static final int PROPERTY_visible = 5;
  private static final int PROPERTY_nextFocusableComponent = 6;
  private static final int PROPERTY_background = 7;
  private static final int PROPERTY_debugGraphicsOptions = 8;
  private static final int PROPERTY_selectionEnd = 9;
  private static final int PROPERTY_parent = 10;
  private static final int PROPERTY_peer = 11;
  private static final int PROPERTY_doubleBuffered = 12;
  private static final int PROPERTY_lineCount = 13;
  private static final int PROPERTY_accessibleContext = 14;
  private static final int PROPERTY_lineWrap = 15;
  private static final int PROPERTY_name = 16;
  private static final int PROPERTY_minimumSizeSet = 17;
  private static final int PROPERTY_font = 18;
  private static final int PROPERTY_topLevelAncestor = 19;
  private static final int PROPERTY_opaque = 20;
  private static final int PROPERTY_focusCycleRoot = 21;
  private static final int PROPERTY_minimumSize = 22;
  private static final int PROPERTY_autoscrolls = 23;
  private static final int PROPERTY_highlighter = 24;
  private static final int PROPERTY_actions = 25;
  private static final int PROPERTY_dropTarget = 26;
  private static final int PROPERTY_inputMethodRequests = 27;
  private static final int PROPERTY_layout = 28;
  private static final int PROPERTY_y = 29;
  private static final int PROPERTY_locationOnScreen = 30;
  private static final int PROPERTY_border = 31;
  private static final int PROPERTY_x = 32;
  private static final int PROPERTY_selectedText = 33;
  private static final int PROPERTY_graphicsConfiguration = 34;
  private static final int PROPERTY_colorModel = 35;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 36;
  private static final int PROPERTY_showing = 37;
  private static final int PROPERTY_displayable = 38;
  private static final int PROPERTY_selectedTextColor = 39;
  private static final int PROPERTY_optimizedDrawingEnabled = 40;
  private static final int PROPERTY_focusTraversable = 41;
  private static final int PROPERTY_valid = 42;
  private static final int PROPERTY_validateRoot = 43;
  private static final int PROPERTY_selectionColor = 44;
  private static final int PROPERTY_locale = 45;
  private static final int PROPERTY_registeredKeyStrokes = 46;
  private static final int PROPERTY_managingFocus = 47;
  private static final int PROPERTY_enabled = 48;
  private static final int PROPERTY_wrapStyleWord = 49;
  private static final int PROPERTY__changed = 50;
  private static final int PROPERTY_width = 51;
  private static final int PROPERTY_rootPane = 52;
  private static final int PROPERTY_preferredSizeSet = 53;
  private static final int PROPERTY_componentOrientation = 54;
  private static final int PROPERTY_componentCount = 55;
  private static final int PROPERTY_toolTipText = 56;
  private static final int PROPERTY_UIClassID = 57;
  private static final int PROPERTY_bounds = 58;
  private static final int PROPERTY_paintingTile = 59;
  private static final int PROPERTY_keymap = 60;
  private static final int PROPERTY_rows = 61;
  private static final int PROPERTY_editable = 62;
  private static final int PROPERTY_lightweight = 63;
  private static final int PROPERTY_cursor = 64;
  private static final int PROPERTY_inputContext = 65;
  private static final int PROPERTY_insets = 66;
  private static final int PROPERTY_inputVerifier = 67;
  private static final int PROPERTY_foreground = 68;
  private static final int PROPERTY_caret = 69;
  private static final int PROPERTY_alignmentY = 70;
  private static final int PROPERTY_alignmentX = 71;
  private static final int PROPERTY_preferredScrollableViewportSize = 72;
  private static final int PROPERTY__output_stream = 73;
  private static final int PROPERTY_components = 74;
  private static final int PROPERTY_actionMap = 75;
  private static final int PROPERTY_maximumSizeSet = 76;
  private static final int PROPERTY_text = 77;
  private static final int PROPERTY_caretColor = 78;
  private static final int PROPERTY_margin = 79;
  private static final int PROPERTY_tabSize = 80;
  private static final int PROPERTY__key_processing = 81;
  private static final int PROPERTY_caretPosition = 82;
  private static final int PROPERTY_maximumSize = 83;
  private static final int PROPERTY_scrollableTracksViewportWidth = 84;
  private static final int PROPERTY_toolkit = 85;
  private static final int PROPERTY_preferredSize = 86;
  private static final int PROPERTY_focusAccelerator = 87;
  private static final int PROPERTY_document = 88;
  private static final int PROPERTY_graphics = 89;
  private static final int PROPERTY_treeLock = 90;
  private static final int PROPERTY_columns = 91;
  private static final int PROPERTY__controller = 92;
  private static final int PROPERTY_UI = 93;
  private static final int PROPERTY_disabledTextColor = 94;
  private static final int PROPERTY_visibleRect = 95;
  private static final int PROPERTY_lineOfOffset = 96;
  private static final int PROPERTY_component = 97;
  private static final int PROPERTY_lineEndOffset = 98;
  private static final int PROPERTY_lineStartOffset = 99;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[100];

  static {
    try {
      properties[PROPERTY__key_processor] = new PropertyDescriptor ( "_key_processor", FijiTextArea.class, "get_key_processor", "set_key_processor" );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", FijiTextArea.class, "getHeight", null );
      properties[PROPERTY_selectionStart] = new PropertyDescriptor ( "selectionStart", FijiTextArea.class, "getSelectionStart", "setSelectionStart" );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", FijiTextArea.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY_scrollableTracksViewportHeight] = new PropertyDescriptor ( "scrollableTracksViewportHeight", FijiTextArea.class, "getScrollableTracksViewportHeight", null );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", FijiTextArea.class, "isVisible", "setVisible" );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", FijiTextArea.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", FijiTextArea.class, "getBackground", "setBackground" );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", FijiTextArea.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_selectionEnd] = new PropertyDescriptor ( "selectionEnd", FijiTextArea.class, "getSelectionEnd", "setSelectionEnd" );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", FijiTextArea.class, "getParent", null );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", FijiTextArea.class, "getPeer", null );
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", FijiTextArea.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_lineCount] = new PropertyDescriptor ( "lineCount", FijiTextArea.class, "getLineCount", null );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", FijiTextArea.class, "getAccessibleContext", null );
      properties[PROPERTY_lineWrap] = new PropertyDescriptor ( "lineWrap", FijiTextArea.class, "getLineWrap", "setLineWrap" );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", FijiTextArea.class, "getName", "setName" );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", FijiTextArea.class, "isMinimumSizeSet", null );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", FijiTextArea.class, "getFont", "setFont" );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", FijiTextArea.class, "getTopLevelAncestor", null );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", FijiTextArea.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", FijiTextArea.class, "isFocusCycleRoot", null );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", FijiTextArea.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", FijiTextArea.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_highlighter] = new PropertyDescriptor ( "highlighter", FijiTextArea.class, "getHighlighter", "setHighlighter" );
      properties[PROPERTY_actions] = new PropertyDescriptor ( "actions", FijiTextArea.class, "getActions", null );
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", FijiTextArea.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", FijiTextArea.class, "getInputMethodRequests", null );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", FijiTextArea.class, "getLayout", "setLayout" );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", FijiTextArea.class, "getY", null );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", FijiTextArea.class, "getLocationOnScreen", null );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", FijiTextArea.class, "getBorder", "setBorder" );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", FijiTextArea.class, "getX", null );
      properties[PROPERTY_selectedText] = new PropertyDescriptor ( "selectedText", FijiTextArea.class, "getSelectedText", null );
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", FijiTextArea.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", FijiTextArea.class, "getColorModel", null );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", FijiTextArea.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", FijiTextArea.class, "isShowing", null );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", FijiTextArea.class, "isDisplayable", null );
      properties[PROPERTY_selectedTextColor] = new PropertyDescriptor ( "selectedTextColor", FijiTextArea.class, "getSelectedTextColor", "setSelectedTextColor" );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", FijiTextArea.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", FijiTextArea.class, "isFocusTraversable", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", FijiTextArea.class, "isValid", null );
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", FijiTextArea.class, "isValidateRoot", null );
      properties[PROPERTY_selectionColor] = new PropertyDescriptor ( "selectionColor", FijiTextArea.class, "getSelectionColor", "setSelectionColor" );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", FijiTextArea.class, "getLocale", "setLocale" );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", FijiTextArea.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", FijiTextArea.class, "isManagingFocus", null );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", FijiTextArea.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_wrapStyleWord] = new PropertyDescriptor ( "wrapStyleWord", FijiTextArea.class, "getWrapStyleWord", "setWrapStyleWord" );
      properties[PROPERTY__changed] = new PropertyDescriptor ( "_changed", FijiTextArea.class, "get_changed", "set_changed" );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", FijiTextArea.class, "getWidth", null );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", FijiTextArea.class, "getRootPane", null );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", FijiTextArea.class, "isPreferredSizeSet", null );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", FijiTextArea.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", FijiTextArea.class, "getComponentCount", null );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", FijiTextArea.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", FijiTextArea.class, "getUIClassID", null );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", FijiTextArea.class, "getBounds", "setBounds" );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", FijiTextArea.class, "isPaintingTile", null );
      properties[PROPERTY_keymap] = new PropertyDescriptor ( "keymap", FijiTextArea.class, "getKeymap", "setKeymap" );
      properties[PROPERTY_rows] = new PropertyDescriptor ( "rows", FijiTextArea.class, "getRows", "setRows" );
      properties[PROPERTY_editable] = new PropertyDescriptor ( "editable", FijiTextArea.class, "isEditable", "setEditable" );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", FijiTextArea.class, "isLightweight", null );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", FijiTextArea.class, "getCursor", "setCursor" );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", FijiTextArea.class, "getInputContext", null );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", FijiTextArea.class, "getInsets", null );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", FijiTextArea.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", FijiTextArea.class, "getForeground", "setForeground" );
      properties[PROPERTY_caret] = new PropertyDescriptor ( "caret", FijiTextArea.class, "getCaret", "setCaret" );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", FijiTextArea.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", FijiTextArea.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_preferredScrollableViewportSize] = new PropertyDescriptor ( "preferredScrollableViewportSize", FijiTextArea.class, "getPreferredScrollableViewportSize", null );
      properties[PROPERTY__output_stream] = new PropertyDescriptor ( "_output_stream", FijiTextArea.class, "get_output_stream", null );
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", FijiTextArea.class, "getComponents", null );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", FijiTextArea.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", FijiTextArea.class, "isMaximumSizeSet", null );
      properties[PROPERTY_text] = new PropertyDescriptor ( "text", FijiTextArea.class, "getText", "setText" );
      properties[PROPERTY_caretColor] = new PropertyDescriptor ( "caretColor", FijiTextArea.class, "getCaretColor", "setCaretColor" );
      properties[PROPERTY_margin] = new PropertyDescriptor ( "margin", FijiTextArea.class, "getMargin", "setMargin" );
      properties[PROPERTY_tabSize] = new PropertyDescriptor ( "tabSize", FijiTextArea.class, "getTabSize", "setTabSize" );
      properties[PROPERTY__key_processing] = new PropertyDescriptor ( "_key_processing", FijiTextArea.class, "get_key_processing", "set_key_processing" );
      properties[PROPERTY_caretPosition] = new PropertyDescriptor ( "caretPosition", FijiTextArea.class, "getCaretPosition", "setCaretPosition" );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", FijiTextArea.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_scrollableTracksViewportWidth] = new PropertyDescriptor ( "scrollableTracksViewportWidth", FijiTextArea.class, "getScrollableTracksViewportWidth", null );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", FijiTextArea.class, "getToolkit", null );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", FijiTextArea.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_focusAccelerator] = new PropertyDescriptor ( "focusAccelerator", FijiTextArea.class, "getFocusAccelerator", "setFocusAccelerator" );
      properties[PROPERTY_document] = new PropertyDescriptor ( "document", FijiTextArea.class, "getDocument", "setDocument" );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", FijiTextArea.class, "getGraphics", null );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", FijiTextArea.class, "getTreeLock", null );
      properties[PROPERTY_columns] = new PropertyDescriptor ( "columns", FijiTextArea.class, "getColumns", "setColumns" );
      properties[PROPERTY__controller] = new PropertyDescriptor ( "_controller", FijiTextArea.class, "get_controller", "set_controller" );
      properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", FijiTextArea.class, "getUI", "setUI" );
      properties[PROPERTY_disabledTextColor] = new PropertyDescriptor ( "disabledTextColor", FijiTextArea.class, "getDisabledTextColor", "setDisabledTextColor" );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", FijiTextArea.class, "getVisibleRect", null );
      properties[PROPERTY_lineOfOffset] = new IndexedPropertyDescriptor ( "lineOfOffset", FijiTextArea.class, null, null, "getLineOfOffset", null );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", FijiTextArea.class, null, null, "getComponent", null );
      properties[PROPERTY_lineEndOffset] = new IndexedPropertyDescriptor ( "lineEndOffset", FijiTextArea.class, null, null, "getLineEndOffset", null );
      properties[PROPERTY_lineStartOffset] = new IndexedPropertyDescriptor ( "lineStartOffset", FijiTextArea.class, null, null, "getLineStartOffset", null );
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
  private static final int EVENT_propertyChangeListener = 7;
  private static final int EVENT_keyListener = 8;
  private static final int EVENT_hierarchyListener = 9;
  private static final int EVENT_containerListener = 10;
  private static final int EVENT_vetoableChangeListener = 11;
  private static final int EVENT_caretListener = 12;

  // EventSet array
  private static EventSetDescriptor[] eventSets = new EventSetDescriptor[13];

  static {
    try {
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentShown", "componentResized", "componentHidden", "componentMoved"}, "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorResized", "ancestorMoved"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseReleased", "mouseEntered", "mouseClicked", "mousePressed", "mouseExited"}, "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyReleased", "keyPressed", "keyTyped"}, "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentRemoved", "componentAdded"}, "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" );
      eventSets[EVENT_caretListener] = new EventSetDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class, "caretListener", javax.swing.event.CaretListener.class, new String[] {"caretUpdate"}, "addCaretListener", "removeCaretListener" );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Events

    // Here you can add code for customizing the event sets array.

}//GEN-LAST:Events

  // Method identifiers //GEN-FIRST:Methods
  private static final int METHOD_getScrollableUnitIncrement0 = 0;
  private static final int METHOD_getScrollableBlockIncrement1 = 1;
  private static final int METHOD_find_forward_and_select2 = 2;
  private static final int METHOD_find_backward_and_select3 = 3;
  private static final int METHOD_replace_selected4 = 4;
  private static final int METHOD_replace_globally5 = 5;
  private static final int METHOD_toggle_key_processing6 = 6;
  private static final int METHOD_put_text7 = 7;
  private static final int METHOD_append8 = 8;
  private static final int METHOD_replaceRange9 = 9;
  private static final int METHOD_insert10 = 10;
  private static final int METHOD_getKeymap11 = 11;
  private static final int METHOD_selectAll12 = 12;
  private static final int METHOD_addKeymap13 = 13;
  private static final int METHOD_paste14 = 14;
  private static final int METHOD_getText15 = 15;
  private static final int METHOD_cut16 = 16;
  private static final int METHOD_replaceSelection17 = 17;
  private static final int METHOD_updateUI18 = 18;
  private static final int METHOD_loadKeymap19 = 19;
  private static final int METHOD_copy20 = 20;
  private static final int METHOD_select21 = 21;
  private static final int METHOD_write22 = 22;
  private static final int METHOD_removeKeymap23 = 23;
  private static final int METHOD_read24 = 24;
  private static final int METHOD_removeNotify25 = 25;
  private static final int METHOD_moveCaretPosition26 = 26;
  private static final int METHOD_modelToView27 = 27;
  private static final int METHOD_viewToModel28 = 28;
  private static final int METHOD_hasFocus29 = 29;
  private static final int METHOD_unregisterKeyboardAction30 = 30;
  private static final int METHOD_revalidate31 = 31;
  private static final int METHOD_getListeners32 = 32;
  private static final int METHOD_getInputMap33 = 33;
  private static final int METHOD_getToolTipLocation34 = 34;
  private static final int METHOD_getBounds35 = 35;
  private static final int METHOD_firePropertyChange36 = 36;
  private static final int METHOD_getActionForKeyStroke37 = 37;
  private static final int METHOD_firePropertyChange38 = 38;
  private static final int METHOD_repaint39 = 39;
  private static final int METHOD_getInputMap40 = 40;
  private static final int METHOD_firePropertyChange41 = 41;
  private static final int METHOD_firePropertyChange42 = 42;
  private static final int METHOD_repaint43 = 43;
  private static final int METHOD_addPropertyChangeListener44 = 44;
  private static final int METHOD_computeVisibleRect45 = 45;
  private static final int METHOD_hide46 = 46;
  private static final int METHOD_reshape47 = 47;
  private static final int METHOD_putClientProperty48 = 48;
  private static final int METHOD_getLocation49 = 49;
  private static final int METHOD_setInputMap50 = 50;
  private static final int METHOD_paintImmediately51 = 51;
  private static final int METHOD_disable52 = 52;
  private static final int METHOD_resetKeyboardActions53 = 53;
  private static final int METHOD_enable54 = 54;
  private static final int METHOD_grabFocus55 = 55;
  private static final int METHOD_getToolTipText56 = 56;
  private static final int METHOD_getClientProperty57 = 57;
  private static final int METHOD_getSize58 = 58;
  private static final int METHOD_firePropertyChange59 = 59;
  private static final int METHOD_removePropertyChangeListener60 = 60;
  private static final int METHOD_requestDefaultFocus61 = 61;
  private static final int METHOD_addNotify62 = 62;
  private static final int METHOD_firePropertyChange63 = 63;
  private static final int METHOD_requestFocus64 = 64;
  private static final int METHOD_getConditionForKeyStroke65 = 65;
  private static final int METHOD_firePropertyChange66 = 66;
  private static final int METHOD_registerKeyboardAction67 = 67;
  private static final int METHOD_registerKeyboardAction68 = 68;
  private static final int METHOD_isLightweightComponent69 = 69;
  private static final int METHOD_paint70 = 70;
  private static final int METHOD_createToolTip71 = 71;
  private static final int METHOD_print72 = 72;
  private static final int METHOD_update73 = 73;
  private static final int METHOD_paintImmediately74 = 74;
  private static final int METHOD_getInsets75 = 75;
  private static final int METHOD_printAll76 = 76;
  private static final int METHOD_contains77 = 77;
  private static final int METHOD_firePropertyChange78 = 78;
  private static final int METHOD_scrollRectToVisible79 = 79;
  private static final int METHOD_getComponentAt80 = 80;
  private static final int METHOD_add81 = 81;
  private static final int METHOD_preferredSize82 = 82;
  private static final int METHOD_locate83 = 83;
  private static final int METHOD_list84 = 84;
  private static final int METHOD_add85 = 85;
  private static final int METHOD_add86 = 86;
  private static final int METHOD_invalidate87 = 87;
  private static final int METHOD_printComponents88 = 88;
  private static final int METHOD_doLayout89 = 89;
  private static final int METHOD_layout90 = 90;
  private static final int METHOD_list91 = 91;
  private static final int METHOD_add92 = 92;
  private static final int METHOD_remove93 = 93;
  private static final int METHOD_isAncestorOf94 = 94;
  private static final int METHOD_findComponentAt95 = 95;
  private static final int METHOD_findComponentAt96 = 96;
  private static final int METHOD_insets97 = 97;
  private static final int METHOD_getComponentAt98 = 98;
  private static final int METHOD_paintComponents99 = 99;
  private static final int METHOD_countComponents100 = 100;
  private static final int METHOD_minimumSize101 = 101;
  private static final int METHOD_deliverEvent102 = 102;
  private static final int METHOD_removeAll103 = 103;
  private static final int METHOD_remove104 = 104;
  private static final int METHOD_add105 = 105;
  private static final int METHOD_validate106 = 106;
  private static final int METHOD_gotFocus107 = 107;
  private static final int METHOD_toString108 = 108;
  private static final int METHOD_list109 = 109;
  private static final int METHOD_enableInputMethods110 = 110;
  private static final int METHOD_mouseEnter111 = 111;
  private static final int METHOD_getSize112 = 112;
  private static final int METHOD_add113 = 113;
  private static final int METHOD_contains114 = 114;
  private static final int METHOD_transferFocus115 = 115;
  private static final int METHOD_action116 = 116;
  private static final int METHOD_setSize117 = 117;
  private static final int METHOD_show118 = 118;
  private static final int METHOD_mouseDown119 = 119;
  private static final int METHOD_imageUpdate120 = 120;
  private static final int METHOD_repaint121 = 121;
  private static final int METHOD_getFontMetrics122 = 122;
  private static final int METHOD_lostFocus123 = 123;
  private static final int METHOD_postEvent124 = 124;
  private static final int METHOD_show125 = 125;
  private static final int METHOD_handleEvent126 = 126;
  private static final int METHOD_list127 = 127;
  private static final int METHOD_setBounds128 = 128;
  private static final int METHOD_mouseDrag129 = 129;
  private static final int METHOD_enable130 = 130;
  private static final int METHOD_createImage131 = 131;
  private static final int METHOD_keyUp132 = 132;
  private static final int METHOD_createImage133 = 133;
  private static final int METHOD_setLocation134 = 134;
  private static final int METHOD_repaint135 = 135;
  private static final int METHOD_repaint136 = 136;
  private static final int METHOD_keyDown137 = 137;
  private static final int METHOD_nextFocus138 = 138;
  private static final int METHOD_bounds139 = 139;
  private static final int METHOD_move140 = 140;
  private static final int METHOD_prepareImage141 = 141;
  private static final int METHOD_prepareImage142 = 142;
  private static final int METHOD_resize143 = 143;
  private static final int METHOD_getLocation144 = 144;
  private static final int METHOD_remove145 = 145;
  private static final int METHOD_setSize146 = 146;
  private static final int METHOD_list147 = 147;
  private static final int METHOD_location148 = 148;
  private static final int METHOD_paintAll149 = 149;
  private static final int METHOD_dispatchEvent150 = 150;
  private static final int METHOD_checkImage151 = 151;
  private static final int METHOD_checkImage152 = 152;
  private static final int METHOD_mouseExit153 = 153;
  private static final int METHOD_mouseMove154 = 154;
  private static final int METHOD_setLocation155 = 155;
  private static final int METHOD_mouseUp156 = 156;
  private static final int METHOD_size157 = 157;
  private static final int METHOD_inside158 = 158;
  private static final int METHOD_resize159 = 159;

  // Method array 
  private static MethodDescriptor[] methods = new MethodDescriptor[160];

  static {
    try {
      methods[METHOD_getScrollableUnitIncrement0] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getScrollableUnitIncrement", new Class[] {java.awt.Rectangle.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getScrollableUnitIncrement0].setDisplayName ( "" );
      methods[METHOD_getScrollableBlockIncrement1] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getScrollableBlockIncrement", new Class[] {java.awt.Rectangle.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getScrollableBlockIncrement1].setDisplayName ( "" );
      methods[METHOD_find_forward_and_select2] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("find_forward_and_select", new Class[] {java.lang.String.class}));
      methods[METHOD_find_forward_and_select2].setDisplayName ( "" );
      methods[METHOD_find_backward_and_select3] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("find_backward_and_select", new Class[] {java.lang.String.class}));
      methods[METHOD_find_backward_and_select3].setDisplayName ( "" );
      methods[METHOD_replace_selected4] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("replace_selected", new Class[] {java.lang.String.class}));
      methods[METHOD_replace_selected4].setDisplayName ( "" );
      methods[METHOD_replace_globally5] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("replace_globally", new Class[] {java.lang.String.class, java.lang.String.class}));
      methods[METHOD_replace_globally5].setDisplayName ( "" );
      methods[METHOD_toggle_key_processing6] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("toggle_key_processing", new Class[] {}));
      methods[METHOD_toggle_key_processing6].setDisplayName ( "" );
      methods[METHOD_put_text7] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("put_text", new Class[] {java.lang.String.class}));
      methods[METHOD_put_text7].setDisplayName ( "" );
      methods[METHOD_append8] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("append", new Class[] {java.lang.String.class}));
      methods[METHOD_append8].setDisplayName ( "" );
      methods[METHOD_replaceRange9] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("replaceRange", new Class[] {java.lang.String.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_replaceRange9].setDisplayName ( "" );
      methods[METHOD_insert10] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("insert", new Class[] {java.lang.String.class, Integer.TYPE}));
      methods[METHOD_insert10].setDisplayName ( "" );
      methods[METHOD_getKeymap11] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getKeymap", new Class[] {java.lang.String.class}));
      methods[METHOD_getKeymap11].setDisplayName ( "" );
      methods[METHOD_selectAll12] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("selectAll", new Class[] {}));
      methods[METHOD_selectAll12].setDisplayName ( "" );
      methods[METHOD_addKeymap13] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("addKeymap", new Class[] {java.lang.String.class, javax.swing.text.Keymap.class}));
      methods[METHOD_addKeymap13].setDisplayName ( "" );
      methods[METHOD_paste14] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paste", new Class[] {}));
      methods[METHOD_paste14].setDisplayName ( "" );
      methods[METHOD_getText15] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getText", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getText15].setDisplayName ( "" );
      methods[METHOD_cut16] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("cut", new Class[] {}));
      methods[METHOD_cut16].setDisplayName ( "" );
      methods[METHOD_replaceSelection17] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("replaceSelection", new Class[] {java.lang.String.class}));
      methods[METHOD_replaceSelection17].setDisplayName ( "" );
      methods[METHOD_updateUI18] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("updateUI", new Class[] {}));
      methods[METHOD_updateUI18].setDisplayName ( "" );
      methods[METHOD_loadKeymap19] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("loadKeymap", new Class[] {javax.swing.text.Keymap.class, Class.forName("[Ljavax.swing.text.JTextComponent.KeyBinding;"), Class.forName("[Ljavax.swing.Action;")}));
      methods[METHOD_loadKeymap19].setDisplayName ( "" );
      methods[METHOD_copy20] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("copy", new Class[] {}));
      methods[METHOD_copy20].setDisplayName ( "" );
      methods[METHOD_select21] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("select", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_select21].setDisplayName ( "" );
      methods[METHOD_write22] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("write", new Class[] {java.io.Writer.class}));
      methods[METHOD_write22].setDisplayName ( "" );
      methods[METHOD_removeKeymap23] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("removeKeymap", new Class[] {java.lang.String.class}));
      methods[METHOD_removeKeymap23].setDisplayName ( "" );
      methods[METHOD_read24] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("read", new Class[] {java.io.Reader.class, java.lang.Object.class}));
      methods[METHOD_read24].setDisplayName ( "" );
      methods[METHOD_removeNotify25] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("removeNotify", new Class[] {}));
      methods[METHOD_removeNotify25].setDisplayName ( "" );
      methods[METHOD_moveCaretPosition26] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("moveCaretPosition", new Class[] {Integer.TYPE}));
      methods[METHOD_moveCaretPosition26].setDisplayName ( "" );
      methods[METHOD_modelToView27] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("modelToView", new Class[] {Integer.TYPE}));
      methods[METHOD_modelToView27].setDisplayName ( "" );
      methods[METHOD_viewToModel28] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("viewToModel", new Class[] {java.awt.Point.class}));
      methods[METHOD_viewToModel28].setDisplayName ( "" );
      methods[METHOD_hasFocus29] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("hasFocus", new Class[] {}));
      methods[METHOD_hasFocus29].setDisplayName ( "" );
      methods[METHOD_unregisterKeyboardAction30] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_unregisterKeyboardAction30].setDisplayName ( "" );
      methods[METHOD_revalidate31] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("revalidate", new Class[] {}));
      methods[METHOD_revalidate31].setDisplayName ( "" );
      methods[METHOD_getListeners32] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getListeners", new Class[] {java.lang.Class.class}));
      methods[METHOD_getListeners32].setDisplayName ( "" );
      methods[METHOD_getInputMap33] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getInputMap", new Class[] {}));
      methods[METHOD_getInputMap33].setDisplayName ( "" );
      methods[METHOD_getToolTipLocation34] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipLocation34].setDisplayName ( "" );
      methods[METHOD_getBounds35] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_getBounds35].setDisplayName ( "" );
      methods[METHOD_firePropertyChange36] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Double.TYPE, Double.TYPE}));
      methods[METHOD_firePropertyChange36].setDisplayName ( "" );
      methods[METHOD_getActionForKeyStroke37] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getActionForKeyStroke37].setDisplayName ( "" );
      methods[METHOD_firePropertyChange38] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Character.TYPE, Character.TYPE}));
      methods[METHOD_firePropertyChange38].setDisplayName ( "" );
      methods[METHOD_repaint39] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_repaint39].setDisplayName ( "" );
      methods[METHOD_getInputMap40] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getInputMap", new Class[] {Integer.TYPE}));
      methods[METHOD_getInputMap40].setDisplayName ( "" );
      methods[METHOD_firePropertyChange41] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Float.TYPE, Float.TYPE}));
      methods[METHOD_firePropertyChange41].setDisplayName ( "" );
      methods[METHOD_firePropertyChange42] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_firePropertyChange42].setDisplayName ( "" );
      methods[METHOD_repaint43] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("repaint", new Class[] {Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint43].setDisplayName ( "" );
      methods[METHOD_addPropertyChangeListener44] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_addPropertyChangeListener44].setDisplayName ( "" );
      methods[METHOD_computeVisibleRect45] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_computeVisibleRect45].setDisplayName ( "" );
      methods[METHOD_hide46] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("hide", new Class[] {}));
      methods[METHOD_hide46].setDisplayName ( "" );
      methods[METHOD_reshape47] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("reshape", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_reshape47].setDisplayName ( "" );
      methods[METHOD_putClientProperty48] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class}));
      methods[METHOD_putClientProperty48].setDisplayName ( "" );
      methods[METHOD_getLocation49] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_getLocation49].setDisplayName ( "" );
      methods[METHOD_setInputMap50] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setInputMap", new Class[] {Integer.TYPE, javax.swing.InputMap.class}));
      methods[METHOD_setInputMap50].setDisplayName ( "" );
      methods[METHOD_paintImmediately51] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_paintImmediately51].setDisplayName ( "" );
      methods[METHOD_disable52] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("disable", new Class[] {}));
      methods[METHOD_disable52].setDisplayName ( "" );
      methods[METHOD_resetKeyboardActions53] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("resetKeyboardActions", new Class[] {}));
      methods[METHOD_resetKeyboardActions53].setDisplayName ( "" );
      methods[METHOD_enable54] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("enable", new Class[] {}));
      methods[METHOD_enable54].setDisplayName ( "" );
      methods[METHOD_grabFocus55] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("grabFocus", new Class[] {}));
      methods[METHOD_grabFocus55].setDisplayName ( "" );
      methods[METHOD_getToolTipText56] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class}));
      methods[METHOD_getToolTipText56].setDisplayName ( "" );
      methods[METHOD_getClientProperty57] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class}));
      methods[METHOD_getClientProperty57].setDisplayName ( "" );
      methods[METHOD_getSize58] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_getSize58].setDisplayName ( "" );
      methods[METHOD_firePropertyChange59] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Long.TYPE, Long.TYPE}));
      methods[METHOD_firePropertyChange59].setDisplayName ( "" );
      methods[METHOD_removePropertyChangeListener60] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
      methods[METHOD_removePropertyChangeListener60].setDisplayName ( "" );
      methods[METHOD_requestDefaultFocus61] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("requestDefaultFocus", new Class[] {}));
      methods[METHOD_requestDefaultFocus61].setDisplayName ( "" );
      methods[METHOD_addNotify62] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("addNotify", new Class[] {}));
      methods[METHOD_addNotify62].setDisplayName ( "" );
      methods[METHOD_firePropertyChange63] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Byte.TYPE, Byte.TYPE}));
      methods[METHOD_firePropertyChange63].setDisplayName ( "" );
      methods[METHOD_requestFocus64] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("requestFocus", new Class[] {}));
      methods[METHOD_requestFocus64].setDisplayName ( "" );
      methods[METHOD_getConditionForKeyStroke65] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
      methods[METHOD_getConditionForKeyStroke65].setDisplayName ( "" );
      methods[METHOD_firePropertyChange66] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Short.TYPE, Short.TYPE}));
      methods[METHOD_firePropertyChange66].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction67] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction67].setDisplayName ( "" );
      methods[METHOD_registerKeyboardAction68] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, Integer.TYPE}));
      methods[METHOD_registerKeyboardAction68].setDisplayName ( "" );
      methods[METHOD_isLightweightComponent69] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class}));
      methods[METHOD_isLightweightComponent69].setDisplayName ( "" );
      methods[METHOD_paint70] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paint", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paint70].setDisplayName ( "" );
      methods[METHOD_createToolTip71] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("createToolTip", new Class[] {}));
      methods[METHOD_createToolTip71].setDisplayName ( "" );
      methods[METHOD_print72] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("print", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_print72].setDisplayName ( "" );
      methods[METHOD_update73] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("update", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_update73].setDisplayName ( "" );
      methods[METHOD_paintImmediately74] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paintImmediately", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_paintImmediately74].setDisplayName ( "" );
      methods[METHOD_getInsets75] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getInsets", new Class[] {java.awt.Insets.class}));
      methods[METHOD_getInsets75].setDisplayName ( "" );
      methods[METHOD_printAll76] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("printAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printAll76].setDisplayName ( "" );
      methods[METHOD_contains77] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("contains", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_contains77].setDisplayName ( "" );
      methods[METHOD_firePropertyChange78] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Boolean.TYPE, Boolean.TYPE}));
      methods[METHOD_firePropertyChange78].setDisplayName ( "" );
      methods[METHOD_scrollRectToVisible79] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class}));
      methods[METHOD_scrollRectToVisible79].setDisplayName ( "" );
      methods[METHOD_getComponentAt80] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_getComponentAt80].setDisplayName ( "" );
      methods[METHOD_add81] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.awt.Component.class}));
      methods[METHOD_add81].setDisplayName ( "" );
      methods[METHOD_preferredSize82] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("preferredSize", new Class[] {}));
      methods[METHOD_preferredSize82].setDisplayName ( "" );
      methods[METHOD_locate83] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("locate", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_locate83].setDisplayName ( "" );
      methods[METHOD_list84] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("list", new Class[] {java.io.PrintWriter.class, Integer.TYPE}));
      methods[METHOD_list84].setDisplayName ( "" );
      methods[METHOD_add85] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, Integer.TYPE}));
      methods[METHOD_add85].setDisplayName ( "" );
      methods[METHOD_add86] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.awt.Component.class, Integer.TYPE}));
      methods[METHOD_add86].setDisplayName ( "" );
      methods[METHOD_invalidate87] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("invalidate", new Class[] {}));
      methods[METHOD_invalidate87].setDisplayName ( "" );
      methods[METHOD_printComponents88] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_printComponents88].setDisplayName ( "" );
      methods[METHOD_doLayout89] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("doLayout", new Class[] {}));
      methods[METHOD_doLayout89].setDisplayName ( "" );
      methods[METHOD_layout90] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("layout", new Class[] {}));
      methods[METHOD_layout90].setDisplayName ( "" );
      methods[METHOD_list91] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("list", new Class[] {java.io.PrintStream.class, Integer.TYPE}));
      methods[METHOD_list91].setDisplayName ( "" );
      methods[METHOD_add92] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class}));
      methods[METHOD_add92].setDisplayName ( "" );
      methods[METHOD_remove93] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("remove", new Class[] {Integer.TYPE}));
      methods[METHOD_remove93].setDisplayName ( "" );
      methods[METHOD_isAncestorOf94] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class}));
      methods[METHOD_isAncestorOf94].setDisplayName ( "" );
      methods[METHOD_findComponentAt95] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("findComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_findComponentAt95].setDisplayName ( "" );
      methods[METHOD_findComponentAt96] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class}));
      methods[METHOD_findComponentAt96].setDisplayName ( "" );
      methods[METHOD_insets97] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("insets", new Class[] {}));
      methods[METHOD_insets97].setDisplayName ( "" );
      methods[METHOD_getComponentAt98] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_getComponentAt98].setDisplayName ( "" );
      methods[METHOD_paintComponents99] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintComponents99].setDisplayName ( "" );
      methods[METHOD_countComponents100] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("countComponents", new Class[] {}));
      methods[METHOD_countComponents100].setDisplayName ( "" );
      methods[METHOD_minimumSize101] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("minimumSize", new Class[] {}));
      methods[METHOD_minimumSize101].setDisplayName ( "" );
      methods[METHOD_deliverEvent102] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_deliverEvent102].setDisplayName ( "" );
      methods[METHOD_removeAll103] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("removeAll", new Class[] {}));
      methods[METHOD_removeAll103].setDisplayName ( "" );
      methods[METHOD_remove104] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("remove", new Class[] {java.awt.Component.class}));
      methods[METHOD_remove104].setDisplayName ( "" );
      methods[METHOD_add105] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class}));
      methods[METHOD_add105].setDisplayName ( "" );
      methods[METHOD_validate106] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("validate", new Class[] {}));
      methods[METHOD_validate106].setDisplayName ( "" );
      methods[METHOD_gotFocus107] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_gotFocus107].setDisplayName ( "" );
      methods[METHOD_toString108] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("toString", new Class[] {}));
      methods[METHOD_toString108].setDisplayName ( "" );
      methods[METHOD_list109] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("list", new Class[] {java.io.PrintStream.class}));
      methods[METHOD_list109].setDisplayName ( "" );
      methods[METHOD_enableInputMethods110] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("enableInputMethods", new Class[] {Boolean.TYPE}));
      methods[METHOD_enableInputMethods110].setDisplayName ( "" );
      methods[METHOD_mouseEnter111] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseEnter111].setDisplayName ( "" );
      methods[METHOD_getSize112] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getSize", new Class[] {}));
      methods[METHOD_getSize112].setDisplayName ( "" );
      methods[METHOD_add113] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("add", new Class[] {java.awt.PopupMenu.class}));
      methods[METHOD_add113].setDisplayName ( "" );
      methods[METHOD_contains114] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("contains", new Class[] {java.awt.Point.class}));
      methods[METHOD_contains114].setDisplayName ( "" );
      methods[METHOD_transferFocus115] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("transferFocus", new Class[] {}));
      methods[METHOD_transferFocus115].setDisplayName ( "" );
      methods[METHOD_action116] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_action116].setDisplayName ( "" );
      methods[METHOD_setSize117] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setSize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setSize117].setDisplayName ( "" );
      methods[METHOD_show118] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("show", new Class[] {}));
      methods[METHOD_show118].setDisplayName ( "" );
      methods[METHOD_mouseDown119] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDown119].setDisplayName ( "" );
      methods[METHOD_imageUpdate120] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_imageUpdate120].setDisplayName ( "" );
      methods[METHOD_repaint121] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("repaint", new Class[] {Long.TYPE}));
      methods[METHOD_repaint121].setDisplayName ( "" );
      methods[METHOD_getFontMetrics122] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class}));
      methods[METHOD_getFontMetrics122].setDisplayName ( "" );
      methods[METHOD_lostFocus123] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
      methods[METHOD_lostFocus123].setDisplayName ( "" );
      methods[METHOD_postEvent124] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("postEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_postEvent124].setDisplayName ( "" );
      methods[METHOD_show125] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("show", new Class[] {Boolean.TYPE}));
      methods[METHOD_show125].setDisplayName ( "" );
      methods[METHOD_handleEvent126] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("handleEvent", new Class[] {java.awt.Event.class}));
      methods[METHOD_handleEvent126].setDisplayName ( "" );
      methods[METHOD_list127] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("list", new Class[] {java.io.PrintWriter.class}));
      methods[METHOD_list127].setDisplayName ( "" );
      methods[METHOD_setBounds128] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setBounds", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setBounds128].setDisplayName ( "" );
      methods[METHOD_mouseDrag129] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseDrag129].setDisplayName ( "" );
      methods[METHOD_enable130] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("enable", new Class[] {Boolean.TYPE}));
      methods[METHOD_enable130].setDisplayName ( "" );
      methods[METHOD_createImage131] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class}));
      methods[METHOD_createImage131].setDisplayName ( "" );
      methods[METHOD_keyUp132] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("keyUp", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyUp132].setDisplayName ( "" );
      methods[METHOD_createImage133] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("createImage", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_createImage133].setDisplayName ( "" );
      methods[METHOD_setLocation134] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setLocation", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_setLocation134].setDisplayName ( "" );
      methods[METHOD_repaint135] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("repaint", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_repaint135].setDisplayName ( "" );
      methods[METHOD_repaint136] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("repaint", new Class[] {}));
      methods[METHOD_repaint136].setDisplayName ( "" );
      methods[METHOD_keyDown137] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("keyDown", new Class[] {java.awt.Event.class, Integer.TYPE}));
      methods[METHOD_keyDown137].setDisplayName ( "" );
      methods[METHOD_nextFocus138] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("nextFocus", new Class[] {}));
      methods[METHOD_nextFocus138].setDisplayName ( "" );
      methods[METHOD_bounds139] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("bounds", new Class[] {}));
      methods[METHOD_bounds139].setDisplayName ( "" );
      methods[METHOD_move140] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("move", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_move140].setDisplayName ( "" );
      methods[METHOD_prepareImage141] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage141].setDisplayName ( "" );
      methods[METHOD_prepareImage142] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_prepareImage142].setDisplayName ( "" );
      methods[METHOD_resize143] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("resize", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_resize143].setDisplayName ( "" );
      methods[METHOD_getLocation144] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("getLocation", new Class[] {}));
      methods[METHOD_getLocation144].setDisplayName ( "" );
      methods[METHOD_remove145] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class}));
      methods[METHOD_remove145].setDisplayName ( "" );
      methods[METHOD_setSize146] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setSize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_setSize146].setDisplayName ( "" );
      methods[METHOD_list147] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("list", new Class[] {}));
      methods[METHOD_list147].setDisplayName ( "" );
      methods[METHOD_location148] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("location", new Class[] {}));
      methods[METHOD_location148].setDisplayName ( "" );
      methods[METHOD_paintAll149] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class}));
      methods[METHOD_paintAll149].setDisplayName ( "" );
      methods[METHOD_dispatchEvent150] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class}));
      methods[METHOD_dispatchEvent150].setDisplayName ( "" );
      methods[METHOD_checkImage151] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage151].setDisplayName ( "" );
      methods[METHOD_checkImage152] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("checkImage", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, java.awt.image.ImageObserver.class}));
      methods[METHOD_checkImage152].setDisplayName ( "" );
      methods[METHOD_mouseExit153] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseExit153].setDisplayName ( "" );
      methods[METHOD_mouseMove154] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseMove154].setDisplayName ( "" );
      methods[METHOD_setLocation155] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("setLocation", new Class[] {java.awt.Point.class}));
      methods[METHOD_setLocation155].setDisplayName ( "" );
      methods[METHOD_mouseUp156] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
      methods[METHOD_mouseUp156].setDisplayName ( "" );
      methods[METHOD_size157] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("size", new Class[] {}));
      methods[METHOD_size157].setDisplayName ( "" );
      methods[METHOD_inside158] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("inside", new Class[] {Integer.TYPE, Integer.TYPE}));
      methods[METHOD_inside158].setDisplayName ( "" );
      methods[METHOD_resize159] = new MethodDescriptor ( com.SoftWoehr.FIJI.FijiTextArea.class.getMethod("resize", new Class[] {java.awt.Dimension.class}));
      methods[METHOD_resize159].setDisplayName ( "" );
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

