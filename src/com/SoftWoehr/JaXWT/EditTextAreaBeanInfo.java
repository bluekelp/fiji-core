package com.SoftWoehr.JaXWT;

import java.beans.*;

public class EditTextAreaBeanInfo extends SimpleBeanInfo {
            
  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY_graphicsConfiguration = 0;
  private static final int PROPERTY_bounds = 1;
  private static final int PROPERTY_font = 2;
  private static final int PROPERTY_componentCount = 3;
  private static final int PROPERTY_caret = 4;
  private static final int PROPERTY_locationOnScreen = 5;
  private static final int PROPERTY_paintingTile = 6;
  private static final int PROPERTY_caretPosition = 7;
  private static final int PROPERTY_dropTarget = 8;
  private static final int PROPERTY_focusCycleRoot = 9;
  private static final int PROPERTY_showing = 10;
  private static final int PROPERTY_inputVerifier = 11;
  private static final int PROPERTY_selectionEnd = 12;
  private static final int PROPERTY_layout = 13;
  private static final int PROPERTY_toolTipText = 14;
  private static final int PROPERTY_doubleBuffered = 15;
  private static final int PROPERTY_peer = 16;
  private static final int PROPERTY_accessibleContext = 17;
  private static final int PROPERTY_components = 18;
  private static final int PROPERTY_editable = 19;
  private static final int PROPERTY_registeredKeyStrokes = 20;
  private static final int PROPERTY_UI = 21;
  private static final int PROPERTY_inputContext = 22;
  private static final int PROPERTY_class = 23;
  private static final int PROPERTY_keymap = 24;
  private static final int PROPERTY_autoscrolls = 25;
  private static final int PROPERTY_rootPane = 26;
  private static final int PROPERTY_valid = 27;
  private static final int PROPERTY_selectionStart = 28;
  private static final int PROPERTY_minimumSizeSet = 29;
  private static final int PROPERTY_margin = 30;
  private static final int PROPERTY_background = 31;
  private static final int PROPERTY_preferredScrollableViewportSize = 32;
  private static final int PROPERTY_y = 33;
  private static final int PROPERTY_x = 34;
  private static final int PROPERTY_minimumSize = 35;
  private static final int PROPERTY_toolkit = 36;
  private static final int PROPERTY_inputMethodRequests = 37;
  private static final int PROPERTY_alignmentY = 38;
  private static final int PROPERTY_alignmentX = 39;
  private static final int PROPERTY_topLevelAncestor = 40;
  private static final int PROPERTY_debugGraphicsOptions = 41;
  private static final int PROPERTY_name = 42;
  private static final int PROPERTY_maximumSizeSet = 43;
  private static final int PROPERTY_cursor = 44;
  private static final int PROPERTY_treeLock = 45;
  private static final int PROPERTY_optimizedDrawingEnabled = 46;
  private static final int PROPERTY_width = 47;
  private static final int PROPERTY_requestFocusEnabled = 48;
  private static final int PROPERTY_columns = 49;
  private static final int PROPERTY_tabSize = 50;
  private static final int PROPERTY_preferredSize = 51;
  private static final int PROPERTY_foreground = 52;
  private static final int PROPERTY_height = 53;
  private static final int PROPERTY_parent = 54;
  private static final int PROPERTY_enabled = 55;
  private static final int PROPERTY_visible = 56;
  private static final int PROPERTY_insets = 57;
  private static final int PROPERTY_displayable = 58;
  private static final int PROPERTY__key_processor = 59;
  private static final int PROPERTY_selectedTextColor = 60;
  private static final int PROPERTY_highlighter = 61;
  private static final int PROPERTY_selectionColor = 62;
  private static final int PROPERTY_lightweight = 63;
  private static final int PROPERTY_caretColor = 64;
  private static final int PROPERTY_focusAccelerator = 65;
  private static final int PROPERTY_disabledTextColor = 66;
  private static final int PROPERTY_focusTraversable = 67;
  private static final int PROPERTY_scrollableTracksViewportHeight = 68;
  private static final int PROPERTY_nextFocusableComponent = 69;
  private static final int PROPERTY_border = 70;
  private static final int PROPERTY_text = 71;
  private static final int PROPERTY_UIClassID = 72;
  private static final int PROPERTY_wrapStyleWord = 73;
  private static final int PROPERTY_managingFocus = 74;
  private static final int PROPERTY_graphics = 75;
  private static final int PROPERTY_locale = 76;
  private static final int PROPERTY_lineCount = 77;
  private static final int PROPERTY_actions = 78;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 79;
  private static final int PROPERTY_document = 80;
  private static final int PROPERTY_selectedText = 81;
  private static final int PROPERTY_visibleRect = 82;
  private static final int PROPERTY_colorModel = 83;
  private static final int PROPERTY_scrollableTracksViewportWidth = 84;
  private static final int PROPERTY_actionMap = 85;
  private static final int PROPERTY_maximumSize = 86;
  private static final int PROPERTY_opaque = 87;
  private static final int PROPERTY_preferredSizeSet = 88;
  private static final int PROPERTY_validateRoot = 89;
  private static final int PROPERTY_rows = 90;
  private static final int PROPERTY_componentOrientation = 91;
  private static final int PROPERTY_lineWrap = 92;
  private static final int PROPERTY_lineOfOffset = 93;
  private static final int PROPERTY_component = 94;
  private static final int PROPERTY_lineEndOffset = 95;
  private static final int PROPERTY_lineStartOffset = 96;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[97];

  static {
    try {
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", EditTextArea.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", EditTextArea.class, "getBounds", "setBounds" );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", EditTextArea.class, "getFont", "setFont" );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", EditTextArea.class, "getComponentCount", null );
      properties[PROPERTY_caret] = new PropertyDescriptor ( "caret", EditTextArea.class, "getCaret", "setCaret" );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", EditTextArea.class, "getLocationOnScreen", null );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", EditTextArea.class, "isPaintingTile", null );
      properties[PROPERTY_caretPosition] = new PropertyDescriptor ( "caretPosition", EditTextArea.class, "getCaretPosition", "setCaretPosition" );
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", EditTextArea.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", EditTextArea.class, "isFocusCycleRoot", null );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", EditTextArea.class, "isShowing", null );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", EditTextArea.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_selectionEnd] = new PropertyDescriptor ( "selectionEnd", EditTextArea.class, "getSelectionEnd", "setSelectionEnd" );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", EditTextArea.class, "getLayout", "setLayout" );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", EditTextArea.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", EditTextArea.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", EditTextArea.class, "getPeer", null );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", EditTextArea.class, "getAccessibleContext", null );
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", EditTextArea.class, "getComponents", null );
      properties[PROPERTY_editable] = new PropertyDescriptor ( "editable", EditTextArea.class, "isEditable", "setEditable" );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", EditTextArea.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", EditTextArea.class, "getUI", "setUI" );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", EditTextArea.class, "getInputContext", null );
      properties[PROPERTY_class] = new PropertyDescriptor ( "class", EditTextArea.class, "getClass", null );
      properties[PROPERTY_keymap] = new PropertyDescriptor ( "keymap", EditTextArea.class, "getKeymap", "setKeymap" );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", EditTextArea.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", EditTextArea.class, "getRootPane", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", EditTextArea.class, "isValid", null );
      properties[PROPERTY_selectionStart] = new PropertyDescriptor ( "selectionStart", EditTextArea.class, "getSelectionStart", "setSelectionStart" );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", EditTextArea.class, "isMinimumSizeSet", null );
      properties[PROPERTY_margin] = new PropertyDescriptor ( "margin", EditTextArea.class, "getMargin", "setMargin" );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", EditTextArea.class, "getBackground", "setBackground" );
      properties[PROPERTY_preferredScrollableViewportSize] = new PropertyDescriptor ( "preferredScrollableViewportSize", EditTextArea.class, "getPreferredScrollableViewportSize", null );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", EditTextArea.class, "getY", null );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", EditTextArea.class, "getX", null );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", EditTextArea.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", EditTextArea.class, "getToolkit", null );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", EditTextArea.class, "getInputMethodRequests", null );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", EditTextArea.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", EditTextArea.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", EditTextArea.class, "getTopLevelAncestor", null );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", EditTextArea.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", EditTextArea.class, "getName", "setName" );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", EditTextArea.class, "isMaximumSizeSet", null );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", EditTextArea.class, "getCursor", "setCursor" );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", EditTextArea.class, "getTreeLock", null );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", EditTextArea.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", EditTextArea.class, "getWidth", null );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", EditTextArea.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY_columns] = new PropertyDescriptor ( "columns", EditTextArea.class, "getColumns", "setColumns" );
      properties[PROPERTY_tabSize] = new PropertyDescriptor ( "tabSize", EditTextArea.class, "getTabSize", "setTabSize" );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", EditTextArea.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", EditTextArea.class, "getForeground", "setForeground" );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", EditTextArea.class, "getHeight", null );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", EditTextArea.class, "getParent", null );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", EditTextArea.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", EditTextArea.class, "isVisible", "setVisible" );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", EditTextArea.class, "getInsets", null );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", EditTextArea.class, "isDisplayable", null );
      properties[PROPERTY__key_processor] = new PropertyDescriptor ( "_key_processor", EditTextArea.class, "get_key_processor", "set_key_processor" );
      properties[PROPERTY_selectedTextColor] = new PropertyDescriptor ( "selectedTextColor", EditTextArea.class, "getSelectedTextColor", "setSelectedTextColor" );
      properties[PROPERTY_highlighter] = new PropertyDescriptor ( "highlighter", EditTextArea.class, "getHighlighter", "setHighlighter" );
      properties[PROPERTY_selectionColor] = new PropertyDescriptor ( "selectionColor", EditTextArea.class, "getSelectionColor", "setSelectionColor" );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", EditTextArea.class, "isLightweight", null );
      properties[PROPERTY_caretColor] = new PropertyDescriptor ( "caretColor", EditTextArea.class, "getCaretColor", "setCaretColor" );
      properties[PROPERTY_focusAccelerator] = new PropertyDescriptor ( "focusAccelerator", EditTextArea.class, "getFocusAccelerator", "setFocusAccelerator" );
      properties[PROPERTY_disabledTextColor] = new PropertyDescriptor ( "disabledTextColor", EditTextArea.class, "getDisabledTextColor", "setDisabledTextColor" );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", EditTextArea.class, "isFocusTraversable", null );
      properties[PROPERTY_scrollableTracksViewportHeight] = new PropertyDescriptor ( "scrollableTracksViewportHeight", EditTextArea.class, "getScrollableTracksViewportHeight", null );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", EditTextArea.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", EditTextArea.class, "getBorder", "setBorder" );
      properties[PROPERTY_text] = new PropertyDescriptor ( "text", EditTextArea.class, "getText", null );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", EditTextArea.class, "getUIClassID", null );
      properties[PROPERTY_wrapStyleWord] = new PropertyDescriptor ( "wrapStyleWord", EditTextArea.class, "getWrapStyleWord", "setWrapStyleWord" );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", EditTextArea.class, "isManagingFocus", null );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", EditTextArea.class, "getGraphics", null );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", EditTextArea.class, "getLocale", "setLocale" );
      properties[PROPERTY_lineCount] = new PropertyDescriptor ( "lineCount", EditTextArea.class, "getLineCount", null );
      properties[PROPERTY_actions] = new PropertyDescriptor ( "actions", EditTextArea.class, "getActions", null );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", EditTextArea.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY_document] = new PropertyDescriptor ( "document", EditTextArea.class, "getDocument", "setDocument" );
      properties[PROPERTY_selectedText] = new PropertyDescriptor ( "selectedText", EditTextArea.class, "getSelectedText", null );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", EditTextArea.class, "getVisibleRect", null );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", EditTextArea.class, "getColorModel", null );
      properties[PROPERTY_scrollableTracksViewportWidth] = new PropertyDescriptor ( "scrollableTracksViewportWidth", EditTextArea.class, "getScrollableTracksViewportWidth", null );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", EditTextArea.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", EditTextArea.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", EditTextArea.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", EditTextArea.class, "isPreferredSizeSet", null );
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", EditTextArea.class, "isValidateRoot", null );
      properties[PROPERTY_rows] = new PropertyDescriptor ( "rows", EditTextArea.class, "getRows", "setRows" );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", EditTextArea.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_lineWrap] = new PropertyDescriptor ( "lineWrap", EditTextArea.class, "getLineWrap", "setLineWrap" );
      properties[PROPERTY_lineOfOffset] = new IndexedPropertyDescriptor ( "lineOfOffset", EditTextArea.class, null, null, "getLineOfOffset", null );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", EditTextArea.class, null, null, "getComponent", null );
      properties[PROPERTY_lineEndOffset] = new IndexedPropertyDescriptor ( "lineEndOffset", EditTextArea.class, null, null, "getLineEndOffset", null );
      properties[PROPERTY_lineStartOffset] = new IndexedPropertyDescriptor ( "lineStartOffset", EditTextArea.class, null, null, "getLineStartOffset", null );
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
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( EditTextArea.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[0], "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( EditTextArea.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[0], "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( EditTextArea.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[0], "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( EditTextArea.class, "componentListener", java.awt.event.ComponentListener.class, new String[0], "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( EditTextArea.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[0], "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( EditTextArea.class, "mouseListener", java.awt.event.MouseListener.class, new String[0], "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( EditTextArea.class, "focusListener", java.awt.event.FocusListener.class, new String[0], "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( EditTextArea.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[0], "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( EditTextArea.class, "keyListener", java.awt.event.KeyListener.class, new String[0], "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( EditTextArea.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[0], "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( EditTextArea.class, "containerListener", java.awt.event.ContainerListener.class, new String[0], "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( EditTextArea.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[0], "addVetoableChangeListener", "removeVetoableChangeListener" );
      eventSets[EVENT_caretListener] = new EventSetDescriptor ( EditTextArea.class, "caretListener", javax.swing.event.CaretListener.class, new String[0], "addCaretListener", "removeCaretListener" );
    }
    catch( IntrospectionException e) {}//GEN-HEADEREND:Events

  // Here you can add code for customizing the event sets array.  

}//GEN-LAST:Events

  private static java.awt.Image iconColor16 = null; //GEN-BEGIN:IconsDef
  private static java.awt.Image iconColor32 = null;
  private static java.awt.Image iconMono16 = null;
  private static java.awt.Image iconMono32 = null; //GEN-END:IconsDef
  private static String iconNameC16 = null;//GEN-BEGIN:Icons
  private static String iconNameC32 = null;
  private static String iconNameM16 = null;
  private static String iconNameM32 = null;//GEN-END:Icons
                                                 
  private static int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
  private static int defaultEventIndex = -1;//GEN-END:Idx


  /**
   * Gets the beans <code>PropertyDescriptor</code>s.
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
   * Gets the beans <code>EventSetDescriptor</code>s.
   * 
   * @return  An array of EventSetDescriptors describing the kinds of 
   * events fired by this bean.  May return null if the information
   * should be obtained by automatic analysis.
   */
  public EventSetDescriptor[] getEventSetDescriptors() {
    return eventSets;
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
    return defaultPropertyIndex;
  }

  /**
   * This method returns an image object that can be used to
   * represent the bean in toolboxes, toolbars, etc.   Icon images
   * will typically be GIFs, but may in future include other formats.
   * <p>
   * Beans aren't required to provide icons and may return null from
   * this method.
   * <p>
   * There are four possible flavors of icons (16x16 color,
   * 32x32 color, 16x16 mono, 32x32 mono).  If a bean choses to only
   * support a single icon we recommend supporting 16x16 color.
   * <p>
   * We recommend that icons have a "transparent" background
   * so they can be rendered onto an existing background.
   *
   * @param  iconKind  The kind of icon requested.  This should be
   *    one of the constant values ICON_COLOR_16x16, ICON_COLOR_32x32, 
   *    ICON_MONO_16x16, or ICON_MONO_32x32.
   * @return  An image object representing the requested icon.  May
   *    return null if no suitable icon is available.
   */
  public java.awt.Image getIcon(int iconKind) {
    switch ( iconKind ) {
      case ICON_COLOR_16x16:
        if ( iconNameC16 == null )
          return null;
        else {
          if( iconColor16 == null )
            iconColor16 = loadImage( iconNameC16 );
          return iconColor16;
          }
      case ICON_COLOR_32x32:
        if ( iconNameC32 == null )
          return null;
        else {
          if( iconColor32 == null )
            iconColor32 = loadImage( iconNameC32 );
          return iconColor32;
          }
      case ICON_MONO_16x16:
        if ( iconNameM16 == null )
          return null;
        else {
          if( iconMono16 == null )
            iconMono16 = loadImage( iconNameM16 );
          return iconMono16;
          }
      case ICON_MONO_32x32:
        if ( iconNameM32 == null )
          return null;
        else {
          if( iconNameM32 == null )
            iconMono32 = loadImage( iconNameM32 );
          return iconMono32;
          }
    }
    return null;
  }

}
