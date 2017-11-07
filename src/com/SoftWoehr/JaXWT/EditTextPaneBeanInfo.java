package com.SoftWoehr.JaXWT;

import java.beans.*;

public class EditTextPaneBeanInfo extends SimpleBeanInfo {
            
  // Property identifiers //GEN-FIRST:Properties
  private static final int PROPERTY_dropTarget = 0;
  private static final int PROPERTY_maximumSize = 1;
  private static final int PROPERTY_graphicsConfiguration = 2;
  private static final int PROPERTY_preferredScrollableViewportSize = 3;
  private static final int PROPERTY_scrollableTracksViewportHeight = 4;
  private static final int PROPERTY_registeredKeyStrokes = 5;
  private static final int PROPERTY_components = 6;
  private static final int PROPERTY_focusTraversable = 7;
  private static final int PROPERTY_visible = 8;
  private static final int PROPERTY_contentType = 9;
  private static final int PROPERTY_maximumSizeSet = 10;
  private static final int PROPERTY_nextFocusableComponent = 11;
  private static final int PROPERTY_background = 12;
  private static final int PROPERTY_debugGraphicsOptions = 13;
  private static final int PROPERTY_validateRoot = 14;
  private static final int PROPERTY_cursor = 15;
  private static final int PROPERTY_topLevelAncestor = 16;
  private static final int PROPERTY_showing = 17;
  private static final int PROPERTY_treeLock = 18;
  private static final int PROPERTY_width = 19;
  private static final int PROPERTY_locationOnScreen = 20;
  private static final int PROPERTY_doubleBuffered = 21;
  private static final int PROPERTY_border = 22;
  private static final int PROPERTY_actions = 23;
  private static final int PROPERTY_editable = 24;
  private static final int PROPERTY_font = 25;
  private static final int PROPERTY_selectionStart = 26;
  private static final int PROPERTY_enabled = 27;
  private static final int PROPERTY_actionMap = 28;
  private static final int PROPERTY_selectionColor = 29;
  private static final int PROPERTY_rootPane = 30;
  private static final int PROPERTY_selectionEnd = 31;
  private static final int PROPERTY_inputVerifier = 32;
  private static final int PROPERTY_componentOrientation = 33;
  private static final int PROPERTY_peer = 34;
  private static final int PROPERTY_layout = 35;
  private static final int PROPERTY_y = 36;
  private static final int PROPERTY_x = 37;
  private static final int PROPERTY_foreground = 38;
  private static final int PROPERTY_document = 39;
  private static final int PROPERTY_inputContext = 40;
  private static final int PROPERTY_keymap = 41;
  private static final int PROPERTY_focusCycleRoot = 42;
  private static final int PROPERTY_caretColor = 43;
  private static final int PROPERTY_toolkit = 44;
  private static final int PROPERTY_preferredSize = 45;
  private static final int PROPERTY_margin = 46;
  private static final int PROPERTY_autoscrolls = 47;
  private static final int PROPERTY_requestFocusEnabled = 48;
  private static final int PROPERTY_focusAccelerator = 49;
  private static final int PROPERTY_accessibleContext = 50;
  private static final int PROPERTY_page = 51;
  private static final int PROPERTY_minimumSize = 52;
  private static final int PROPERTY_insets = 53;
  private static final int PROPERTY_paintingTile = 54;
  private static final int PROPERTY_scrollableTracksViewportWidth = 55;
  private static final int PROPERTY_componentCount = 56;
  private static final int PROPERTY_caret = 57;
  private static final int PROPERTY_editorKit = 58;
  private static final int PROPERTY_inputMethodRequests = 59;
  private static final int PROPERTY_selectedTextColor = 60;
  private static final int PROPERTY_highlighter = 61;
  private static final int PROPERTY_managingFocus = 62;
  private static final int PROPERTY_verifyInputWhenFocusTarget = 63;
  private static final int PROPERTY_bounds = 64;
  private static final int PROPERTY_inputAttributes = 65;
  private static final int PROPERTY_lightweight = 66;
  private static final int PROPERTY_UI = 67;
  private static final int PROPERTY_height = 68;
  private static final int PROPERTY_name = 69;
  private static final int PROPERTY_characterAttributes = 70;
  private static final int PROPERTY_visibleRect = 71;
  private static final int PROPERTY_valid = 72;
  private static final int PROPERTY_alignmentY = 73;
  private static final int PROPERTY_text = 74;
  private static final int PROPERTY_alignmentX = 75;
  private static final int PROPERTY_parent = 76;
  private static final int PROPERTY_preferredSizeSet = 77;
  private static final int PROPERTY_disabledTextColor = 78;
  private static final int PROPERTY_class = 79;
  private static final int PROPERTY_UIClassID = 80;
  private static final int PROPERTY_logicalStyle = 81;
  private static final int PROPERTY_minimumSizeSet = 82;
  private static final int PROPERTY_locale = 83;
  private static final int PROPERTY_toolTipText = 84;
  private static final int PROPERTY_caretPosition = 85;
  private static final int PROPERTY_displayable = 86;
  private static final int PROPERTY_paragraphAttributes = 87;
  private static final int PROPERTY_optimizedDrawingEnabled = 88;
  private static final int PROPERTY_opaque = 89;
  private static final int PROPERTY_styledDocument = 90;
  private static final int PROPERTY_graphics = 91;
  private static final int PROPERTY_selectedText = 92;
  private static final int PROPERTY_colorModel = 93;
  private static final int PROPERTY_component = 94;

  // Property array 
  private static PropertyDescriptor[] properties = new PropertyDescriptor[95];

  static {
    try {
      properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", EditTextPane.class, "getDropTarget", "setDropTarget" );
      properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", EditTextPane.class, "getMaximumSize", "setMaximumSize" );
      properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", EditTextPane.class, "getGraphicsConfiguration", null );
      properties[PROPERTY_preferredScrollableViewportSize] = new PropertyDescriptor ( "preferredScrollableViewportSize", EditTextPane.class, "getPreferredScrollableViewportSize", null );
      properties[PROPERTY_scrollableTracksViewportHeight] = new PropertyDescriptor ( "scrollableTracksViewportHeight", EditTextPane.class, "getScrollableTracksViewportHeight", null );
      properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", EditTextPane.class, "getRegisteredKeyStrokes", null );
      properties[PROPERTY_components] = new PropertyDescriptor ( "components", EditTextPane.class, "getComponents", null );
      properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", EditTextPane.class, "isFocusTraversable", null );
      properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", EditTextPane.class, "isVisible", "setVisible" );
      properties[PROPERTY_contentType] = new PropertyDescriptor ( "contentType", EditTextPane.class, "getContentType", "setContentType" );
      properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", EditTextPane.class, "isMaximumSizeSet", null );
      properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", EditTextPane.class, "getNextFocusableComponent", "setNextFocusableComponent" );
      properties[PROPERTY_background] = new PropertyDescriptor ( "background", EditTextPane.class, "getBackground", "setBackground" );
      properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", EditTextPane.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
      properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", EditTextPane.class, "isValidateRoot", null );
      properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", EditTextPane.class, "getCursor", "setCursor" );
      properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", EditTextPane.class, "getTopLevelAncestor", null );
      properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", EditTextPane.class, "isShowing", null );
      properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", EditTextPane.class, "getTreeLock", null );
      properties[PROPERTY_width] = new PropertyDescriptor ( "width", EditTextPane.class, "getWidth", null );
      properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", EditTextPane.class, "getLocationOnScreen", null );
      properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", EditTextPane.class, "isDoubleBuffered", "setDoubleBuffered" );
      properties[PROPERTY_border] = new PropertyDescriptor ( "border", EditTextPane.class, "getBorder", "setBorder" );
      properties[PROPERTY_actions] = new PropertyDescriptor ( "actions", EditTextPane.class, "getActions", null );
      properties[PROPERTY_editable] = new PropertyDescriptor ( "editable", EditTextPane.class, "isEditable", "setEditable" );
      properties[PROPERTY_font] = new PropertyDescriptor ( "font", EditTextPane.class, "getFont", "setFont" );
      properties[PROPERTY_selectionStart] = new PropertyDescriptor ( "selectionStart", EditTextPane.class, "getSelectionStart", "setSelectionStart" );
      properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", EditTextPane.class, "isEnabled", "setEnabled" );
      properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", EditTextPane.class, "getActionMap", "setActionMap" );
      properties[PROPERTY_selectionColor] = new PropertyDescriptor ( "selectionColor", EditTextPane.class, "getSelectionColor", "setSelectionColor" );
      properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", EditTextPane.class, "getRootPane", null );
      properties[PROPERTY_selectionEnd] = new PropertyDescriptor ( "selectionEnd", EditTextPane.class, "getSelectionEnd", "setSelectionEnd" );
      properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", EditTextPane.class, "getInputVerifier", "setInputVerifier" );
      properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", EditTextPane.class, "getComponentOrientation", "setComponentOrientation" );
      properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", EditTextPane.class, "getPeer", null );
      properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", EditTextPane.class, "getLayout", "setLayout" );
      properties[PROPERTY_y] = new PropertyDescriptor ( "y", EditTextPane.class, "getY", null );
      properties[PROPERTY_x] = new PropertyDescriptor ( "x", EditTextPane.class, "getX", null );
      properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", EditTextPane.class, "getForeground", "setForeground" );
      properties[PROPERTY_document] = new PropertyDescriptor ( "document", EditTextPane.class, "getDocument", "setDocument" );
      properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", EditTextPane.class, "getInputContext", null );
      properties[PROPERTY_keymap] = new PropertyDescriptor ( "keymap", EditTextPane.class, "getKeymap", "setKeymap" );
      properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", EditTextPane.class, "isFocusCycleRoot", null );
      properties[PROPERTY_caretColor] = new PropertyDescriptor ( "caretColor", EditTextPane.class, "getCaretColor", "setCaretColor" );
      properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", EditTextPane.class, "getToolkit", null );
      properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", EditTextPane.class, "getPreferredSize", "setPreferredSize" );
      properties[PROPERTY_margin] = new PropertyDescriptor ( "margin", EditTextPane.class, "getMargin", "setMargin" );
      properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", EditTextPane.class, "getAutoscrolls", "setAutoscrolls" );
      properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", EditTextPane.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
      properties[PROPERTY_focusAccelerator] = new PropertyDescriptor ( "focusAccelerator", EditTextPane.class, "getFocusAccelerator", "setFocusAccelerator" );
      properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", EditTextPane.class, "getAccessibleContext", null );
      properties[PROPERTY_page] = new PropertyDescriptor ( "page", EditTextPane.class, "getPage", "setPage" );
      properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", EditTextPane.class, "getMinimumSize", "setMinimumSize" );
      properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", EditTextPane.class, "getInsets", null );
      properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", EditTextPane.class, "isPaintingTile", null );
      properties[PROPERTY_scrollableTracksViewportWidth] = new PropertyDescriptor ( "scrollableTracksViewportWidth", EditTextPane.class, "getScrollableTracksViewportWidth", null );
      properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", EditTextPane.class, "getComponentCount", null );
      properties[PROPERTY_caret] = new PropertyDescriptor ( "caret", EditTextPane.class, "getCaret", "setCaret" );
      properties[PROPERTY_editorKit] = new PropertyDescriptor ( "editorKit", EditTextPane.class, "getEditorKit", "setEditorKit" );
      properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", EditTextPane.class, "getInputMethodRequests", null );
      properties[PROPERTY_selectedTextColor] = new PropertyDescriptor ( "selectedTextColor", EditTextPane.class, "getSelectedTextColor", "setSelectedTextColor" );
      properties[PROPERTY_highlighter] = new PropertyDescriptor ( "highlighter", EditTextPane.class, "getHighlighter", "setHighlighter" );
      properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", EditTextPane.class, "isManagingFocus", null );
      properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", EditTextPane.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
      properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", EditTextPane.class, "getBounds", "setBounds" );
      properties[PROPERTY_inputAttributes] = new PropertyDescriptor ( "inputAttributes", EditTextPane.class, "getInputAttributes", null );
      properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", EditTextPane.class, "isLightweight", null );
      properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", EditTextPane.class, "getUI", "setUI" );
      properties[PROPERTY_height] = new PropertyDescriptor ( "height", EditTextPane.class, "getHeight", null );
      properties[PROPERTY_name] = new PropertyDescriptor ( "name", EditTextPane.class, "getName", "setName" );
      properties[PROPERTY_characterAttributes] = new PropertyDescriptor ( "characterAttributes", EditTextPane.class, "getCharacterAttributes", null );
      properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", EditTextPane.class, "getVisibleRect", null );
      properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", EditTextPane.class, "isValid", null );
      properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", EditTextPane.class, "getAlignmentY", "setAlignmentY" );
      properties[PROPERTY_text] = new PropertyDescriptor ( "text", EditTextPane.class, "getText", null );
      properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", EditTextPane.class, "getAlignmentX", "setAlignmentX" );
      properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", EditTextPane.class, "getParent", null );
      properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", EditTextPane.class, "isPreferredSizeSet", null );
      properties[PROPERTY_disabledTextColor] = new PropertyDescriptor ( "disabledTextColor", EditTextPane.class, "getDisabledTextColor", "setDisabledTextColor" );
      properties[PROPERTY_class] = new PropertyDescriptor ( "class", EditTextPane.class, "getClass", null );
      properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", EditTextPane.class, "getUIClassID", null );
      properties[PROPERTY_logicalStyle] = new PropertyDescriptor ( "logicalStyle", EditTextPane.class, "getLogicalStyle", "setLogicalStyle" );
      properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", EditTextPane.class, "isMinimumSizeSet", null );
      properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", EditTextPane.class, "getLocale", "setLocale" );
      properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", EditTextPane.class, "getToolTipText", "setToolTipText" );
      properties[PROPERTY_caretPosition] = new PropertyDescriptor ( "caretPosition", EditTextPane.class, "getCaretPosition", "setCaretPosition" );
      properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", EditTextPane.class, "isDisplayable", null );
      properties[PROPERTY_paragraphAttributes] = new PropertyDescriptor ( "paragraphAttributes", EditTextPane.class, "getParagraphAttributes", null );
      properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", EditTextPane.class, "isOptimizedDrawingEnabled", null );
      properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", EditTextPane.class, "isOpaque", "setOpaque" );
      properties[PROPERTY_styledDocument] = new PropertyDescriptor ( "styledDocument", EditTextPane.class, "getStyledDocument", "setStyledDocument" );
      properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", EditTextPane.class, "getGraphics", null );
      properties[PROPERTY_selectedText] = new PropertyDescriptor ( "selectedText", EditTextPane.class, "getSelectedText", null );
      properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", EditTextPane.class, "getColorModel", null );
      properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", EditTextPane.class, null, null, "getComponent", null );
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
  private static final int EVENT_hyperlinkListener = 7;
  private static final int EVENT_propertyChangeListener = 8;
  private static final int EVENT_keyListener = 9;
  private static final int EVENT_hierarchyListener = 10;
  private static final int EVENT_containerListener = 11;
  private static final int EVENT_vetoableChangeListener = 12;
  private static final int EVENT_caretListener = 13;

  // EventSet array
  private static EventSetDescriptor[] eventSets = new EventSetDescriptor[14];

  static {
    try {
      eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( EditTextPane.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[0], "addMouseMotionListener", "removeMouseMotionListener" );
      eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( EditTextPane.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[0], "addInputMethodListener", "removeInputMethodListener" );
      eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( EditTextPane.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[0], "addAncestorListener", "removeAncestorListener" );
      eventSets[EVENT_componentListener] = new EventSetDescriptor ( EditTextPane.class, "componentListener", java.awt.event.ComponentListener.class, new String[0], "addComponentListener", "removeComponentListener" );
      eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( EditTextPane.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[0], "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
      eventSets[EVENT_mouseListener] = new EventSetDescriptor ( EditTextPane.class, "mouseListener", java.awt.event.MouseListener.class, new String[0], "addMouseListener", "removeMouseListener" );
      eventSets[EVENT_focusListener] = new EventSetDescriptor ( EditTextPane.class, "focusListener", java.awt.event.FocusListener.class, new String[0], "addFocusListener", "removeFocusListener" );
      eventSets[EVENT_hyperlinkListener] = new EventSetDescriptor ( EditTextPane.class, "hyperlinkListener", javax.swing.event.HyperlinkListener.class, new String[0], "addHyperlinkListener", "removeHyperlinkListener" );
      eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( EditTextPane.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[0], "addPropertyChangeListener", "removePropertyChangeListener" );
      eventSets[EVENT_keyListener] = new EventSetDescriptor ( EditTextPane.class, "keyListener", java.awt.event.KeyListener.class, new String[0], "addKeyListener", "removeKeyListener" );
      eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( EditTextPane.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[0], "addHierarchyListener", "removeHierarchyListener" );
      eventSets[EVENT_containerListener] = new EventSetDescriptor ( EditTextPane.class, "containerListener", java.awt.event.ContainerListener.class, new String[0], "addContainerListener", "removeContainerListener" );
      eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( EditTextPane.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[0], "addVetoableChangeListener", "removeVetoableChangeListener" );
      eventSets[EVENT_caretListener] = new EventSetDescriptor ( EditTextPane.class, "caretListener", javax.swing.event.CaretListener.class, new String[0], "addCaretListener", "removeCaretListener" );
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
