package org.dozer.loader.xml;

import junit.framework.TestCase;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Dmitry Buzdin
 */
public class SimpleElementReaderTest extends TestCase {
  
  private SimpleElementReader reader;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    reader = new SimpleElementReader();
  }

  @Test
  public void testGetAttribute() {
    Element element = mock(Element.class);
    when(element.getAttribute("A")).thenReturn(" B ");

    String result = reader.getAttribute(element, "A");

    assertEquals("B", result);
  }

  @Test
  public void testGetNodeValue() {
    Element element = mock(Element.class);
    Node node = mock(Node.class);
    when(node.getNodeValue()).thenReturn(" B ");
    when(element.getFirstChild()).thenReturn(node);

    String result = reader.getNodeValue(element);

    assertEquals("B", result);
  }

  @Test
  public void testNodeValueIsNull() {
    Element element = mock(Element.class);
    Node node = mock(Node.class);
    when(node.getNodeValue()).thenReturn(null);
    when(element.getFirstChild()).thenReturn(node);

    assertEquals("", reader.getNodeValue(element));
  }

}
