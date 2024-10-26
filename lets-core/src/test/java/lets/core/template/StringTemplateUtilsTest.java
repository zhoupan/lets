/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lets.core.template;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.stringtemplate.v4.STGroupString;

public class StringTemplateUtilsTest {

  @Test
  public void testRenderStringMapOfStringObject() {
    Properties props = new Properties();
    props.setProperty("name", "java");
    String result = StringTemplateUtils.render("Hello <name>", props);
    assertEquals("Hello java", result);
  }

  @Test
  public void testRenderStringMapOfStringObjectCharChar() {
    Properties props = new Properties();
    props.setProperty("name", "java");
    String result = StringTemplateUtils.render("Hello {name}", props, '{', '}');
    assertEquals("Hello java", result);
  }

  @Test
  public void testStringTemplateSingleLine() {
    String group = "t1(v)::=\"hello t1<v>\"";
    group += "t2(v)::=\"hello t2<v>\"";
    group += "t3(v)::=\"hello t3<v>\"";
    STGroupString sg = new STGroupString(group);
    assertTrue(sg.isDefined("t1"));
    assertTrue(sg.isDefined("t2"));
    StringTemplate st = new StringTemplate();
    st.with("v", "java");
    TemplateResult result = st.render("hello <v>");
    assertTrue(result.isSuccess());
    assertEquals("hello java", result.getText());
    result = st.render(sg, "t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    result = st.render(sg, "/t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "/t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    st.setName("t3");
    result = st.render(sg);
    assertTrue(result.isSuccess());
    assertEquals("hello t3java", result.getText());
  }

  @Test
  public void testStringTemplateMultipleLine() {
    String group = "t1(v)::= <<\nhello t1<v>\n>>\n";
    group += "t2(v)::=<<\nhello t2<v>\n>>\n";
    group += "t3(v)::=<<\nhello t3<v>\n>>";
    STGroupString sg = new STGroupString(group);
    assertTrue(sg.isDefined("t1"));
    assertTrue(sg.isDefined("t2"));
    StringTemplate st = new StringTemplate();
    st.with("v", "java");
    TemplateResult result = st.render("hello <v>");
    assertTrue(result.isSuccess());
    assertEquals("hello java", result.getText());
    result = st.render(sg, "t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    result = st.render(sg, "/t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "/t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    st.setName("t3");
    result = st.render(sg);
    assertTrue(result.isSuccess());
    assertEquals("hello t3java", result.getText());
  }

  @Test
  public void testStringTemplateMultipleLineIgnoresIndentationAndNewlines() {
    String group = "t1(v)::= <%\nhello t1<v>\n%>";
    group += "\nt2(v)::=<%\n\nhello t2<v>\n%>";
    group += "\nt3(v)::=<%\n\nhello t3<v>\n%>";
    STGroupString sg = new STGroupString(group);
    assertTrue(sg.isDefined("t1"));
    assertTrue(sg.isDefined("t2"));
    StringTemplate st = new StringTemplate();
    st.with("v", "java");
    TemplateResult result = st.render("hello <v>");
    assertTrue(result.isSuccess());
    assertEquals("hello java", result.getText());
    result = st.render(sg, "t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    result = st.render(sg, "/t1");
    assertTrue(result.isSuccess());
    assertEquals("hello t1java", result.getText());
    result = st.render(sg, "/t2");
    assertTrue(result.isSuccess());
    assertEquals("hello t2java", result.getText());
    st.setName("t3");
    result = st.render(sg);
    assertTrue(result.isSuccess());
    assertEquals("hello t3java", result.getText());
  }
}
