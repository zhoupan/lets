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
package lets.lang;

import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GraphQLParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      T__6 = 7,
      T__7 = 8,
      T__8 = 9,
      T__9 = 10,
      T__10 = 11,
      T__11 = 12,
      T__12 = 13,
      T__13 = 14,
      T__14 = 15,
      T__15 = 16,
      T__16 = 17,
      T__17 = 18,
      T__18 = 19,
      T__19 = 20,
      T__20 = 21,
      T__21 = 22,
      T__22 = 23,
      T__23 = 24,
      T__24 = 25,
      T__25 = 26,
      T__26 = 27,
      T__27 = 28,
      T__28 = 29,
      T__29 = 30,
      T__30 = 31,
      T__31 = 32,
      T__32 = 33,
      T__33 = 34,
      T__34 = 35,
      T__35 = 36,
      T__36 = 37,
      T__37 = 38,
      T__38 = 39,
      T__39 = 40,
      T__40 = 41,
      T__41 = 42,
      T__42 = 43,
      T__43 = 44,
      T__44 = 45,
      T__45 = 46,
      T__46 = 47,
      T__47 = 48,
      T__48 = 49,
      T__49 = 50,
      T__50 = 51,
      T__51 = 52,
      NAME = 53,
      STRING = 54,
      BLOCK_STRING = 55,
      ID = 56,
      FLOAT = 57,
      INT = 58,
      PUNCTUATOR = 59,
      WS = 60,
      COMMA = 61,
      LineComment = 62,
      UNICODE_BOM = 63,
      UTF8_BOM = 64,
      UTF16_BOM = 65,
      UTF32_BOM = 66;
  public static final int RULE_document = 0,
      RULE_definition = 1,
      RULE_executableDocument = 2,
      RULE_executableDefinition = 3,
      RULE_operationDefinition = 4,
      RULE_operationType = 5,
      RULE_selectionSet = 6,
      RULE_selection = 7,
      RULE_field = 8,
      RULE_arguments = 9,
      RULE_argument = 10,
      RULE_alias = 11,
      RULE_fragmentSpread = 12,
      RULE_fragmentDefinition = 13,
      RULE_fragmentName = 14,
      RULE_typeCondition = 15,
      RULE_inlineFragment = 16,
      RULE_value = 17,
      RULE_intValue = 18,
      RULE_floatValue = 19,
      RULE_booleanValue = 20,
      RULE_stringValue = 21,
      RULE_nullValue = 22,
      RULE_enumValue = 23,
      RULE_listValue = 24,
      RULE_objectValue = 25,
      RULE_objectField = 26,
      RULE_variable = 27,
      RULE_variableDefinitions = 28,
      RULE_variableDefinition = 29,
      RULE_defaultValue = 30,
      RULE_type_ = 31,
      RULE_namedType = 32,
      RULE_listType = 33,
      RULE_directives = 34,
      RULE_directive = 35,
      RULE_typeSystemDocument = 36,
      RULE_typeSystemDefinition = 37,
      RULE_typeSystemExtensionDocument = 38,
      RULE_typeSystemExtension = 39,
      RULE_schemaDefinition = 40,
      RULE_rootOperationTypeDefinition = 41,
      RULE_schemaExtension = 42,
      RULE_description = 43,
      RULE_typeDefinition = 44,
      RULE_typeExtension = 45,
      RULE_scalarTypeDefinition = 46,
      RULE_scalarTypeExtension = 47,
      RULE_objectTypeDefinition = 48,
      RULE_implementsInterfaces = 49,
      RULE_fieldsDefinition = 50,
      RULE_fieldDefinition = 51,
      RULE_argumentsDefinition = 52,
      RULE_inputValueDefinition = 53,
      RULE_objectTypeExtension = 54,
      RULE_interfaceTypeDefinition = 55,
      RULE_interfaceTypeExtension = 56,
      RULE_unionTypeDefinition = 57,
      RULE_unionMemberTypes = 58,
      RULE_unionTypeExtension = 59,
      RULE_enumTypeDefinition = 60,
      RULE_enumValuesDefinition = 61,
      RULE_enumValueDefinition = 62,
      RULE_enumTypeExtension = 63,
      RULE_inputObjectTypeDefinition = 64,
      RULE_inputFieldsDefinition = 65,
      RULE_inputObjectTypeExtension = 66,
      RULE_directiveDefinition = 67,
      RULE_directiveLocations = 68,
      RULE_directiveLocation = 69,
      RULE_executableDirectiveLocation = 70,
      RULE_typeSystemDirectiveLocation = 71,
      RULE_name = 72;

  private static String[] makeRuleNames() {
    return new String[] {
      "document",
      "definition",
      "executableDocument",
      "executableDefinition",
      "operationDefinition",
      "operationType",
      "selectionSet",
      "selection",
      "field",
      "arguments",
      "argument",
      "alias",
      "fragmentSpread",
      "fragmentDefinition",
      "fragmentName",
      "typeCondition",
      "inlineFragment",
      "value",
      "intValue",
      "floatValue",
      "booleanValue",
      "stringValue",
      "nullValue",
      "enumValue",
      "listValue",
      "objectValue",
      "objectField",
      "variable",
      "variableDefinitions",
      "variableDefinition",
      "defaultValue",
      "type_",
      "namedType",
      "listType",
      "directives",
      "directive",
      "typeSystemDocument",
      "typeSystemDefinition",
      "typeSystemExtensionDocument",
      "typeSystemExtension",
      "schemaDefinition",
      "rootOperationTypeDefinition",
      "schemaExtension",
      "description",
      "typeDefinition",
      "typeExtension",
      "scalarTypeDefinition",
      "scalarTypeExtension",
      "objectTypeDefinition",
      "implementsInterfaces",
      "fieldsDefinition",
      "fieldDefinition",
      "argumentsDefinition",
      "inputValueDefinition",
      "objectTypeExtension",
      "interfaceTypeDefinition",
      "interfaceTypeExtension",
      "unionTypeDefinition",
      "unionMemberTypes",
      "unionTypeExtension",
      "enumTypeDefinition",
      "enumValuesDefinition",
      "enumValueDefinition",
      "enumTypeExtension",
      "inputObjectTypeDefinition",
      "inputFieldsDefinition",
      "inputObjectTypeExtension",
      "directiveDefinition",
      "directiveLocations",
      "directiveLocation",
      "executableDirectiveLocation",
      "typeSystemDirectiveLocation",
      "name"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'query'",
      "'mutation'",
      "'subscription'",
      "'{'",
      "'}'",
      "'('",
      "')'",
      "':'",
      "'...'",
      "'fragment'",
      "'on'",
      "'true'",
      "'false'",
      "'null'",
      "'['",
      "']'",
      "'$'",
      "'='",
      "'!'",
      "'@'",
      "'schema'",
      "'extend'",
      "'scalar'",
      "'type'",
      "'implements'",
      "'&'",
      "'interface'",
      "'union'",
      "'|'",
      "'enum'",
      "'input'",
      "'directive'",
      "'repeatable'",
      "'QUERY'",
      "'MUTATION'",
      "'SUBSCRIPTION'",
      "'FIELD'",
      "'FRAGMENT_DEFINITION'",
      "'FRAGMENT_SPREAD'",
      "'INLINE_FRAGMENT'",
      "'VARIABLE_DEFINITION'",
      "'SCHEMA'",
      "'SCALAR'",
      "'OBJECT'",
      "'FIELD_DEFINITION'",
      "'ARGUMENT_DEFINITION'",
      "'INTERFACE'",
      "'UNION'",
      "'ENUM'",
      "'ENUM_VALUE'",
      "'INPUT_OBJECT'",
      "'INPUT_FIELD_DEFINITION'",
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "','",
      null,
      null,
      "'\\uEFBBBF'",
      "'\\uFEFF'",
      "'\\u0000FEFF'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "NAME",
      "STRING",
      "BLOCK_STRING",
      "ID",
      "FLOAT",
      "INT",
      "PUNCTUATOR",
      "WS",
      "COMMA",
      "LineComment",
      "UNICODE_BOM",
      "UTF8_BOM",
      "UTF16_BOM",
      "UTF32_BOM"
    };
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated public static final String[] tokenNames;

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "GraphQL.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public GraphQLParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DocumentContext extends ParserRuleContext {
    public TerminalNode EOF() {
      return getToken(GraphQLParser.EOF, 0);
    }

    public List<DefinitionContext> definition() {
      return getRuleContexts(DefinitionContext.class);
    }

    public DefinitionContext definition(int i) {
      return getRuleContext(DefinitionContext.class, i);
    }

    public DocumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_document;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDocument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDocument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDocument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DocumentContext document() throws RecognitionException {
    DocumentContext _localctx = new DocumentContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_document);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(147);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(146);
              definition();
            }
          }
          setState(149);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043203478750238L) != 0));
        setState(151);
        match(EOF);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DefinitionContext extends ParserRuleContext {
    public ExecutableDocumentContext executableDocument() {
      return getRuleContext(ExecutableDocumentContext.class, 0);
    }

    public TypeSystemDocumentContext typeSystemDocument() {
      return getRuleContext(TypeSystemDocumentContext.class, 0);
    }

    public TypeSystemExtensionDocumentContext typeSystemExtensionDocument() {
      return getRuleContext(TypeSystemExtensionDocumentContext.class, 0);
    }

    public DefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_definition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefinitionContext definition() throws RecognitionException {
    DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_definition);
    try {
      setState(156);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__9:
          enterOuterAlt(_localctx, 1);
          {
            setState(153);
            executableDocument();
          }
          break;
        case T__20:
        case T__22:
        case T__23:
        case T__26:
        case T__27:
        case T__29:
        case T__30:
        case T__31:
        case STRING:
        case BLOCK_STRING:
          enterOuterAlt(_localctx, 2);
          {
            setState(154);
            typeSystemDocument();
          }
          break;
        case T__21:
          enterOuterAlt(_localctx, 3);
          {
            setState(155);
            typeSystemExtensionDocument();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExecutableDocumentContext extends ParserRuleContext {
    public List<ExecutableDefinitionContext> executableDefinition() {
      return getRuleContexts(ExecutableDefinitionContext.class);
    }

    public ExecutableDefinitionContext executableDefinition(int i) {
      return getRuleContext(ExecutableDefinitionContext.class, i);
    }

    public ExecutableDocumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_executableDocument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterExecutableDocument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitExecutableDocument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitExecutableDocument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExecutableDocumentContext executableDocument() throws RecognitionException {
    ExecutableDocumentContext _localctx = new ExecutableDocumentContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_executableDocument);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(159);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(158);
                  executableDefinition();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(161);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExecutableDefinitionContext extends ParserRuleContext {
    public OperationDefinitionContext operationDefinition() {
      return getRuleContext(OperationDefinitionContext.class, 0);
    }

    public FragmentDefinitionContext fragmentDefinition() {
      return getRuleContext(FragmentDefinitionContext.class, 0);
    }

    public ExecutableDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_executableDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterExecutableDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitExecutableDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitExecutableDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExecutableDefinitionContext executableDefinition() throws RecognitionException {
    ExecutableDefinitionContext _localctx = new ExecutableDefinitionContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_executableDefinition);
    try {
      setState(165);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
        case T__3:
          enterOuterAlt(_localctx, 1);
          {
            setState(163);
            operationDefinition();
          }
          break;
        case T__9:
          enterOuterAlt(_localctx, 2);
          {
            setState(164);
            fragmentDefinition();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OperationDefinitionContext extends ParserRuleContext {
    public OperationTypeContext operationType() {
      return getRuleContext(OperationTypeContext.class, 0);
    }

    public SelectionSetContext selectionSet() {
      return getRuleContext(SelectionSetContext.class, 0);
    }

    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public VariableDefinitionsContext variableDefinitions() {
      return getRuleContext(VariableDefinitionsContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public OperationDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterOperationDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitOperationDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitOperationDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationDefinitionContext operationDefinition() throws RecognitionException {
    OperationDefinitionContext _localctx = new OperationDefinitionContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_operationDefinition);
    int _la;
    try {
      setState(180);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
          enterOuterAlt(_localctx, 1);
          {
            setState(167);
            operationType();
            setState(169);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == NAME) {
              {
                setState(168);
                name();
              }
            }

            setState(172);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__5) {
              {
                setState(171);
                variableDefinitions();
              }
            }

            setState(175);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(174);
                directives();
              }
            }

            setState(177);
            selectionSet();
          }
          break;
        case T__3:
          enterOuterAlt(_localctx, 2);
          {
            setState(179);
            selectionSet();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OperationTypeContext extends ParserRuleContext {
    public OperationTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterOperationType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitOperationType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitOperationType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationTypeContext operationType() throws RecognitionException {
    OperationTypeContext _localctx = new OperationTypeContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_operationType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(182);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SelectionSetContext extends ParserRuleContext {
    public List<SelectionContext> selection() {
      return getRuleContexts(SelectionContext.class);
    }

    public SelectionContext selection(int i) {
      return getRuleContext(SelectionContext.class, i);
    }

    public SelectionSetContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_selectionSet;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSelectionSet(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSelectionSet(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitSelectionSet(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SelectionSetContext selectionSet() throws RecognitionException {
    SelectionSetContext _localctx = new SelectionSetContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_selectionSet);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(184);
        match(T__3);
        setState(186);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(185);
              selection();
            }
          }
          setState(188);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == T__8 || _la == NAME);
        setState(190);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SelectionContext extends ParserRuleContext {
    public FieldContext field() {
      return getRuleContext(FieldContext.class, 0);
    }

    public FragmentSpreadContext fragmentSpread() {
      return getRuleContext(FragmentSpreadContext.class, 0);
    }

    public InlineFragmentContext inlineFragment() {
      return getRuleContext(InlineFragmentContext.class, 0);
    }

    public SelectionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_selection;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSelection(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSelection(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitSelection(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SelectionContext selection() throws RecognitionException {
    SelectionContext _localctx = new SelectionContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_selection);
    try {
      setState(195);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(192);
            field();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(193);
            fragmentSpread();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(194);
            inlineFragment();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FieldContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public AliasContext alias() {
      return getRuleContext(AliasContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public SelectionSetContext selectionSet() {
      return getRuleContext(SelectionSetContext.class, 0);
    }

    public FieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_field;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterField(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitField(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitField(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FieldContext field() throws RecognitionException {
    FieldContext _localctx = new FieldContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(198);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
          case 1:
            {
              setState(197);
              alias();
            }
            break;
        }
        setState(200);
        name();
        setState(202);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__5) {
          {
            setState(201);
            arguments();
          }
        }

        setState(205);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(204);
            directives();
          }
        }

        setState(208);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__3) {
          {
            setState(207);
            selectionSet();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsContext extends ParserRuleContext {
    public List<ArgumentContext> argument() {
      return getRuleContexts(ArgumentContext.class);
    }

    public ArgumentContext argument(int i) {
      return getRuleContext(ArgumentContext.class, i);
    }

    public ArgumentsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arguments;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitArguments(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitArguments(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentsContext arguments() throws RecognitionException {
    ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_arguments);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(210);
        match(T__5);
        setState(212);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(211);
              argument();
            }
          }
          setState(214);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == NAME);
        setState(216);
        match(T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public ValueContext value() {
      return getRuleContext(ValueContext.class, 0);
    }

    public ArgumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterArgument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitArgument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitArgument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentContext argument() throws RecognitionException {
    ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_argument);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(218);
        name();
        setState(219);
        match(T__7);
        setState(220);
        value();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AliasContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public AliasContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_alias;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterAlias(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitAlias(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitAlias(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AliasContext alias() throws RecognitionException {
    AliasContext _localctx = new AliasContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_alias);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(222);
        name();
        setState(223);
        match(T__7);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FragmentSpreadContext extends ParserRuleContext {
    public FragmentNameContext fragmentName() {
      return getRuleContext(FragmentNameContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public FragmentSpreadContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fragmentSpread;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterFragmentSpread(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitFragmentSpread(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFragmentSpread(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FragmentSpreadContext fragmentSpread() throws RecognitionException {
    FragmentSpreadContext _localctx = new FragmentSpreadContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_fragmentSpread);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(225);
        match(T__8);
        setState(226);
        fragmentName();
        setState(228);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(227);
            directives();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FragmentDefinitionContext extends ParserRuleContext {
    public FragmentNameContext fragmentName() {
      return getRuleContext(FragmentNameContext.class, 0);
    }

    public TypeConditionContext typeCondition() {
      return getRuleContext(TypeConditionContext.class, 0);
    }

    public SelectionSetContext selectionSet() {
      return getRuleContext(SelectionSetContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public FragmentDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fragmentDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterFragmentDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitFragmentDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFragmentDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FragmentDefinitionContext fragmentDefinition() throws RecognitionException {
    FragmentDefinitionContext _localctx = new FragmentDefinitionContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_fragmentDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(230);
        match(T__9);
        setState(231);
        fragmentName();
        setState(232);
        typeCondition();
        setState(234);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(233);
            directives();
          }
        }

        setState(236);
        selectionSet();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FragmentNameContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public FragmentNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fragmentName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFragmentName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFragmentName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFragmentName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FragmentNameContext fragmentName() throws RecognitionException {
    FragmentNameContext _localctx = new FragmentNameContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_fragmentName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(238);
        name();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeConditionContext extends ParserRuleContext {
    public NamedTypeContext namedType() {
      return getRuleContext(NamedTypeContext.class, 0);
    }

    public TypeConditionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeCondition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeCondition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeCondition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeCondition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeConditionContext typeCondition() throws RecognitionException {
    TypeConditionContext _localctx = new TypeConditionContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_typeCondition);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(240);
        match(T__10);
        setState(241);
        namedType();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InlineFragmentContext extends ParserRuleContext {
    public SelectionSetContext selectionSet() {
      return getRuleContext(SelectionSetContext.class, 0);
    }

    public TypeConditionContext typeCondition() {
      return getRuleContext(TypeConditionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public InlineFragmentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inlineFragment;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInlineFragment(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInlineFragment(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInlineFragment(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InlineFragmentContext inlineFragment() throws RecognitionException {
    InlineFragmentContext _localctx = new InlineFragmentContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_inlineFragment);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(243);
        match(T__8);
        setState(245);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__10) {
          {
            setState(244);
            typeCondition();
          }
        }

        setState(248);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(247);
            directives();
          }
        }

        setState(250);
        selectionSet();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ValueContext extends ParserRuleContext {
    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public IntValueContext intValue() {
      return getRuleContext(IntValueContext.class, 0);
    }

    public FloatValueContext floatValue() {
      return getRuleContext(FloatValueContext.class, 0);
    }

    public StringValueContext stringValue() {
      return getRuleContext(StringValueContext.class, 0);
    }

    public BooleanValueContext booleanValue() {
      return getRuleContext(BooleanValueContext.class, 0);
    }

    public NullValueContext nullValue() {
      return getRuleContext(NullValueContext.class, 0);
    }

    public EnumValueContext enumValue() {
      return getRuleContext(EnumValueContext.class, 0);
    }

    public ListValueContext listValue() {
      return getRuleContext(ListValueContext.class, 0);
    }

    public ObjectValueContext objectValue() {
      return getRuleContext(ObjectValueContext.class, 0);
    }

    public ValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ValueContext value() throws RecognitionException {
    ValueContext _localctx = new ValueContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_value);
    try {
      setState(261);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__16:
          enterOuterAlt(_localctx, 1);
          {
            setState(252);
            variable();
          }
          break;
        case INT:
          enterOuterAlt(_localctx, 2);
          {
            setState(253);
            intValue();
          }
          break;
        case FLOAT:
          enterOuterAlt(_localctx, 3);
          {
            setState(254);
            floatValue();
          }
          break;
        case STRING:
        case BLOCK_STRING:
          enterOuterAlt(_localctx, 4);
          {
            setState(255);
            stringValue();
          }
          break;
        case T__11:
        case T__12:
          enterOuterAlt(_localctx, 5);
          {
            setState(256);
            booleanValue();
          }
          break;
        case T__13:
          enterOuterAlt(_localctx, 6);
          {
            setState(257);
            nullValue();
          }
          break;
        case NAME:
          enterOuterAlt(_localctx, 7);
          {
            setState(258);
            enumValue();
          }
          break;
        case T__14:
          enterOuterAlt(_localctx, 8);
          {
            setState(259);
            listValue();
          }
          break;
        case T__3:
          enterOuterAlt(_localctx, 9);
          {
            setState(260);
            objectValue();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IntValueContext extends ParserRuleContext {
    public TerminalNode INT() {
      return getToken(GraphQLParser.INT, 0);
    }

    public IntValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_intValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterIntValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitIntValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitIntValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IntValueContext intValue() throws RecognitionException {
    IntValueContext _localctx = new IntValueContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_intValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(263);
        match(INT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FloatValueContext extends ParserRuleContext {
    public TerminalNode FLOAT() {
      return getToken(GraphQLParser.FLOAT, 0);
    }

    public FloatValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_floatValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFloatValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFloatValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFloatValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FloatValueContext floatValue() throws RecognitionException {
    FloatValueContext _localctx = new FloatValueContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_floatValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(265);
        match(FLOAT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BooleanValueContext extends ParserRuleContext {
    public BooleanValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_booleanValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterBooleanValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitBooleanValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitBooleanValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BooleanValueContext booleanValue() throws RecognitionException {
    BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_booleanValue);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(267);
        _la = _input.LA(1);
        if (!(_la == T__11 || _la == T__12)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StringValueContext extends ParserRuleContext {
    public TerminalNode STRING() {
      return getToken(GraphQLParser.STRING, 0);
    }

    public TerminalNode BLOCK_STRING() {
      return getToken(GraphQLParser.BLOCK_STRING, 0);
    }

    public StringValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterStringValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitStringValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitStringValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringValueContext stringValue() throws RecognitionException {
    StringValueContext _localctx = new StringValueContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_stringValue);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(269);
        _la = _input.LA(1);
        if (!(_la == STRING || _la == BLOCK_STRING)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NullValueContext extends ParserRuleContext {
    public NullValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_nullValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterNullValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitNullValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitNullValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NullValueContext nullValue() throws RecognitionException {
    NullValueContext _localctx = new NullValueContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_nullValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(271);
        match(T__13);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumValueContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public EnumValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitEnumValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValueContext enumValue() throws RecognitionException {
    EnumValueContext _localctx = new EnumValueContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_enumValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(273);
        name();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ListValueContext extends ParserRuleContext {
    public List<ValueContext> value() {
      return getRuleContexts(ValueContext.class);
    }

    public ValueContext value(int i) {
      return getRuleContext(ValueContext.class, i);
    }

    public ListValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_listValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterListValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitListValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitListValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ListValueContext listValue() throws RecognitionException {
    ListValueContext _localctx = new ListValueContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_listValue);
    int _la;
    try {
      setState(285);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(275);
            match(T__14);
            setState(276);
            match(T__15);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(277);
            match(T__14);
            setState(279);
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
              {
                {
                  setState(278);
                  value();
                }
              }
              setState(281);
              _errHandler.sync(this);
              _la = _input.LA(1);
            } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 495395959010947088L) != 0));
            setState(283);
            match(T__15);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ObjectValueContext extends ParserRuleContext {
    public List<ObjectFieldContext> objectField() {
      return getRuleContexts(ObjectFieldContext.class);
    }

    public ObjectFieldContext objectField(int i) {
      return getRuleContext(ObjectFieldContext.class, i);
    }

    public ObjectValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitObjectValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectValueContext objectValue() throws RecognitionException {
    ObjectValueContext _localctx = new ObjectValueContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_objectValue);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(287);
        match(T__3);
        setState(291);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == NAME) {
          {
            {
              setState(288);
              objectField();
            }
          }
          setState(293);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(294);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ObjectFieldContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public ValueContext value() {
      return getRuleContext(ValueContext.class, 0);
    }

    public ObjectFieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectField;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectField(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectField(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitObjectField(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectFieldContext objectField() throws RecognitionException {
    ObjectFieldContext _localctx = new ObjectFieldContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_objectField);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(296);
        name();
        setState(297);
        match(T__7);
        setState(298);
        value();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public VariableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variable;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterVariable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitVariable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitVariable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableContext variable() throws RecognitionException {
    VariableContext _localctx = new VariableContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_variable);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(300);
        match(T__16);
        setState(301);
        name();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDefinitionsContext extends ParserRuleContext {
    public List<VariableDefinitionContext> variableDefinition() {
      return getRuleContexts(VariableDefinitionContext.class);
    }

    public VariableDefinitionContext variableDefinition(int i) {
      return getRuleContext(VariableDefinitionContext.class, i);
    }

    public VariableDefinitionsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDefinitions;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterVariableDefinitions(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitVariableDefinitions(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitVariableDefinitions(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableDefinitionsContext variableDefinitions() throws RecognitionException {
    VariableDefinitionsContext _localctx = new VariableDefinitionsContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_variableDefinitions);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(303);
        match(T__5);
        setState(305);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(304);
              variableDefinition();
            }
          }
          setState(307);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == T__16);
        setState(309);
        match(T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDefinitionContext extends ParserRuleContext {
    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public DefaultValueContext defaultValue() {
      return getRuleContext(DefaultValueContext.class, 0);
    }

    public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterVariableDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitVariableDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitVariableDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableDefinitionContext variableDefinition() throws RecognitionException {
    VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_variableDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(311);
        variable();
        setState(312);
        match(T__7);
        setState(313);
        type_();
        setState(315);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__17) {
          {
            setState(314);
            defaultValue();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DefaultValueContext extends ParserRuleContext {
    public ValueContext value() {
      return getRuleContext(ValueContext.class, 0);
    }

    public DefaultValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_defaultValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDefaultValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDefaultValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDefaultValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefaultValueContext defaultValue() throws RecognitionException {
    DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_defaultValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(317);
        match(T__17);
        setState(318);
        value();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Type_Context extends ParserRuleContext {
    public NamedTypeContext namedType() {
      return getRuleContext(NamedTypeContext.class, 0);
    }

    public ListTypeContext listType() {
      return getRuleContext(ListTypeContext.class, 0);
    }

    public Type_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_type_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterType_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitType_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitType_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Type_Context type_() throws RecognitionException {
    Type_Context _localctx = new Type_Context(_ctx, getState());
    enterRule(_localctx, 62, RULE_type_);
    int _la;
    try {
      setState(328);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case NAME:
          enterOuterAlt(_localctx, 1);
          {
            setState(320);
            namedType();
            setState(322);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__18) {
              {
                setState(321);
                match(T__18);
              }
            }
          }
          break;
        case T__14:
          enterOuterAlt(_localctx, 2);
          {
            setState(324);
            listType();
            setState(326);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__18) {
              {
                setState(325);
                match(T__18);
              }
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NamedTypeContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public NamedTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_namedType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterNamedType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitNamedType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitNamedType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NamedTypeContext namedType() throws RecognitionException {
    NamedTypeContext _localctx = new NamedTypeContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_namedType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(330);
        name();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ListTypeContext extends ParserRuleContext {
    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public ListTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_listType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterListType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitListType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitListType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ListTypeContext listType() throws RecognitionException {
    ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_listType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(332);
        match(T__14);
        setState(333);
        type_();
        setState(334);
        match(T__15);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DirectivesContext extends ParserRuleContext {
    public List<DirectiveContext> directive() {
      return getRuleContexts(DirectiveContext.class);
    }

    public DirectiveContext directive(int i) {
      return getRuleContext(DirectiveContext.class, i);
    }

    public DirectivesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directives;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirectives(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirectives(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDirectives(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectivesContext directives() throws RecognitionException {
    DirectivesContext _localctx = new DirectivesContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_directives);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(337);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(336);
              directive();
            }
          }
          setState(339);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == T__19);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DirectiveContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public DirectiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirective(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirective(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDirective(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectiveContext directive() throws RecognitionException {
    DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_directive);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(341);
        match(T__19);
        setState(342);
        name();
        setState(344);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__5) {
          {
            setState(343);
            arguments();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSystemDocumentContext extends ParserRuleContext {
    public List<TypeSystemDefinitionContext> typeSystemDefinition() {
      return getRuleContexts(TypeSystemDefinitionContext.class);
    }

    public TypeSystemDefinitionContext typeSystemDefinition(int i) {
      return getRuleContext(TypeSystemDefinitionContext.class, i);
    }

    public TypeSystemDocumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSystemDocument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeSystemDocument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeSystemDocument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeSystemDocument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSystemDocumentContext typeSystemDocument() throws RecognitionException {
    TypeSystemDocumentContext _localctx = new TypeSystemDocumentContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_typeSystemDocument);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(347);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(346);
                  typeSystemDefinition();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(349);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 30, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSystemDefinitionContext extends ParserRuleContext {
    public SchemaDefinitionContext schemaDefinition() {
      return getRuleContext(SchemaDefinitionContext.class, 0);
    }

    public TypeDefinitionContext typeDefinition() {
      return getRuleContext(TypeDefinitionContext.class, 0);
    }

    public DirectiveDefinitionContext directiveDefinition() {
      return getRuleContext(DirectiveDefinitionContext.class, 0);
    }

    public TypeSystemDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSystemDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeSystemDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeSystemDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeSystemDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSystemDefinitionContext typeSystemDefinition() throws RecognitionException {
    TypeSystemDefinitionContext _localctx = new TypeSystemDefinitionContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_typeSystemDefinition);
    try {
      setState(354);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 31, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(351);
            schemaDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(352);
            typeDefinition();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(353);
            directiveDefinition();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSystemExtensionDocumentContext extends ParserRuleContext {
    public List<TypeSystemExtensionContext> typeSystemExtension() {
      return getRuleContexts(TypeSystemExtensionContext.class);
    }

    public TypeSystemExtensionContext typeSystemExtension(int i) {
      return getRuleContext(TypeSystemExtensionContext.class, i);
    }

    public TypeSystemExtensionDocumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSystemExtensionDocument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeSystemExtensionDocument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeSystemExtensionDocument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeSystemExtensionDocument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSystemExtensionDocumentContext typeSystemExtensionDocument()
      throws RecognitionException {
    TypeSystemExtensionDocumentContext _localctx =
        new TypeSystemExtensionDocumentContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_typeSystemExtensionDocument);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(357);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(356);
                  typeSystemExtension();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(359);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 32, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSystemExtensionContext extends ParserRuleContext {
    public SchemaExtensionContext schemaExtension() {
      return getRuleContext(SchemaExtensionContext.class, 0);
    }

    public TypeExtensionContext typeExtension() {
      return getRuleContext(TypeExtensionContext.class, 0);
    }

    public TypeSystemExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSystemExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeSystemExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeSystemExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeSystemExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSystemExtensionContext typeSystemExtension() throws RecognitionException {
    TypeSystemExtensionContext _localctx = new TypeSystemExtensionContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_typeSystemExtension);
    try {
      setState(363);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 33, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(361);
            schemaExtension();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(362);
            typeExtension();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SchemaDefinitionContext extends ParserRuleContext {
    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public List<RootOperationTypeDefinitionContext> rootOperationTypeDefinition() {
      return getRuleContexts(RootOperationTypeDefinitionContext.class);
    }

    public RootOperationTypeDefinitionContext rootOperationTypeDefinition(int i) {
      return getRuleContext(RootOperationTypeDefinitionContext.class, i);
    }

    public SchemaDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_schemaDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterSchemaDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitSchemaDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitSchemaDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SchemaDefinitionContext schemaDefinition() throws RecognitionException {
    SchemaDefinitionContext _localctx = new SchemaDefinitionContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_schemaDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(365);
        match(T__20);
        setState(367);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(366);
            directives();
          }
        }

        setState(369);
        match(T__3);
        setState(371);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(370);
              rootOperationTypeDefinition();
            }
          }
          setState(373);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0));
        setState(375);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RootOperationTypeDefinitionContext extends ParserRuleContext {
    public OperationTypeContext operationType() {
      return getRuleContext(OperationTypeContext.class, 0);
    }

    public NamedTypeContext namedType() {
      return getRuleContext(NamedTypeContext.class, 0);
    }

    public RootOperationTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rootOperationTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterRootOperationTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitRootOperationTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitRootOperationTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RootOperationTypeDefinitionContext rootOperationTypeDefinition()
      throws RecognitionException {
    RootOperationTypeDefinitionContext _localctx =
        new RootOperationTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_rootOperationTypeDefinition);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(377);
        operationType();
        setState(378);
        match(T__7);
        setState(379);
        namedType();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SchemaExtensionContext extends ParserRuleContext {
    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public List<RootOperationTypeDefinitionContext> rootOperationTypeDefinition() {
      return getRuleContexts(RootOperationTypeDefinitionContext.class);
    }

    public RootOperationTypeDefinitionContext rootOperationTypeDefinition(int i) {
      return getRuleContext(RootOperationTypeDefinitionContext.class, i);
    }

    public SchemaExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_schemaExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterSchemaExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitSchemaExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitSchemaExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SchemaExtensionContext schemaExtension() throws RecognitionException {
    SchemaExtensionContext _localctx = new SchemaExtensionContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_schemaExtension);
    int _la;
    try {
      setState(397);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 38, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(381);
            match(T__21);
            setState(382);
            match(T__20);
            setState(384);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(383);
                directives();
              }
            }

            setState(386);
            match(T__3);
            setState(388);
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
              {
                {
                  setState(387);
                  rootOperationTypeDefinition();
                }
              }
              setState(390);
              _errHandler.sync(this);
              _la = _input.LA(1);
            } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0));
            setState(392);
            match(T__4);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(394);
            match(T__21);
            setState(395);
            match(T__20);
            setState(396);
            directives();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DescriptionContext extends ParserRuleContext {
    public StringValueContext stringValue() {
      return getRuleContext(StringValueContext.class, 0);
    }

    public DescriptionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_description;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDescription(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDescription(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDescription(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DescriptionContext description() throws RecognitionException {
    DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_description);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(399);
        stringValue();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeDefinitionContext extends ParserRuleContext {
    public ScalarTypeDefinitionContext scalarTypeDefinition() {
      return getRuleContext(ScalarTypeDefinitionContext.class, 0);
    }

    public ObjectTypeDefinitionContext objectTypeDefinition() {
      return getRuleContext(ObjectTypeDefinitionContext.class, 0);
    }

    public InterfaceTypeDefinitionContext interfaceTypeDefinition() {
      return getRuleContext(InterfaceTypeDefinitionContext.class, 0);
    }

    public UnionTypeDefinitionContext unionTypeDefinition() {
      return getRuleContext(UnionTypeDefinitionContext.class, 0);
    }

    public EnumTypeDefinitionContext enumTypeDefinition() {
      return getRuleContext(EnumTypeDefinitionContext.class, 0);
    }

    public InputObjectTypeDefinitionContext inputObjectTypeDefinition() {
      return getRuleContext(InputObjectTypeDefinitionContext.class, 0);
    }

    public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeDefinitionContext typeDefinition() throws RecognitionException {
    TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_typeDefinition);
    try {
      setState(407);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(401);
            scalarTypeDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(402);
            objectTypeDefinition();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(403);
            interfaceTypeDefinition();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(404);
            unionTypeDefinition();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(405);
            enumTypeDefinition();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(406);
            inputObjectTypeDefinition();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeExtensionContext extends ParserRuleContext {
    public ScalarTypeExtensionContext scalarTypeExtension() {
      return getRuleContext(ScalarTypeExtensionContext.class, 0);
    }

    public ObjectTypeExtensionContext objectTypeExtension() {
      return getRuleContext(ObjectTypeExtensionContext.class, 0);
    }

    public InterfaceTypeExtensionContext interfaceTypeExtension() {
      return getRuleContext(InterfaceTypeExtensionContext.class, 0);
    }

    public UnionTypeExtensionContext unionTypeExtension() {
      return getRuleContext(UnionTypeExtensionContext.class, 0);
    }

    public EnumTypeExtensionContext enumTypeExtension() {
      return getRuleContext(EnumTypeExtensionContext.class, 0);
    }

    public InputObjectTypeExtensionContext inputObjectTypeExtension() {
      return getRuleContext(InputObjectTypeExtensionContext.class, 0);
    }

    public TypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeExtensionContext typeExtension() throws RecognitionException {
    TypeExtensionContext _localctx = new TypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_typeExtension);
    try {
      setState(415);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(409);
            scalarTypeExtension();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(410);
            objectTypeExtension();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(411);
            interfaceTypeExtension();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(412);
            unionTypeExtension();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(413);
            enumTypeExtension();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(414);
            inputObjectTypeExtension();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ScalarTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public ScalarTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_scalarTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterScalarTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitScalarTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitScalarTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ScalarTypeDefinitionContext scalarTypeDefinition() throws RecognitionException {
    ScalarTypeDefinitionContext _localctx = new ScalarTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_scalarTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(418);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(417);
            description();
          }
        }

        setState(420);
        match(T__22);
        setState(421);
        name();
        setState(423);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(422);
            directives();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ScalarTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public ScalarTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_scalarTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterScalarTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitScalarTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitScalarTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ScalarTypeExtensionContext scalarTypeExtension() throws RecognitionException {
    ScalarTypeExtensionContext _localctx = new ScalarTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_scalarTypeExtension);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(425);
        match(T__21);
        setState(426);
        match(T__22);
        setState(427);
        name();
        setState(428);
        directives();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ObjectTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public ImplementsInterfacesContext implementsInterfaces() {
      return getRuleContext(ImplementsInterfacesContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public FieldsDefinitionContext fieldsDefinition() {
      return getRuleContext(FieldsDefinitionContext.class, 0);
    }

    public ObjectTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterObjectTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitObjectTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitObjectTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectTypeDefinitionContext objectTypeDefinition() throws RecognitionException {
    ObjectTypeDefinitionContext _localctx = new ObjectTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_objectTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(431);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(430);
            description();
          }
        }

        setState(433);
        match(T__23);
        setState(434);
        name();
        setState(436);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__24) {
          {
            setState(435);
            implementsInterfaces(0);
          }
        }

        setState(439);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(438);
            directives();
          }
        }

        setState(442);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 46, _ctx)) {
          case 1:
            {
              setState(441);
              fieldsDefinition();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImplementsInterfacesContext extends ParserRuleContext {
    public NamedTypeContext namedType() {
      return getRuleContext(NamedTypeContext.class, 0);
    }

    public ImplementsInterfacesContext implementsInterfaces() {
      return getRuleContext(ImplementsInterfacesContext.class, 0);
    }

    public ImplementsInterfacesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_implementsInterfaces;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterImplementsInterfaces(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitImplementsInterfaces(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitImplementsInterfaces(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImplementsInterfacesContext implementsInterfaces() throws RecognitionException {
    return implementsInterfaces(0);
  }

  private ImplementsInterfacesContext implementsInterfaces(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ImplementsInterfacesContext _localctx = new ImplementsInterfacesContext(_ctx, _parentState);
    ImplementsInterfacesContext _prevctx = _localctx;
    int _startState = 98;
    enterRecursionRule(_localctx, 98, RULE_implementsInterfaces, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(445);
          match(T__24);
          setState(447);
          _errHandler.sync(this);
          _la = _input.LA(1);
          if (_la == T__25) {
            {
              setState(446);
              match(T__25);
            }
          }

          setState(449);
          namedType();
        }
        _ctx.stop = _input.LT(-1);
        setState(456);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 48, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx = new ImplementsInterfacesContext(_parentctx, _parentState);
                pushNewRecursionContext(_localctx, _startState, RULE_implementsInterfaces);
                setState(451);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(452);
                match(T__25);
                setState(453);
                namedType();
              }
            }
          }
          setState(458);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 48, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FieldsDefinitionContext extends ParserRuleContext {
    public List<FieldDefinitionContext> fieldDefinition() {
      return getRuleContexts(FieldDefinitionContext.class);
    }

    public FieldDefinitionContext fieldDefinition(int i) {
      return getRuleContext(FieldDefinitionContext.class, i);
    }

    public FieldsDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fieldsDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterFieldsDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitFieldsDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFieldsDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FieldsDefinitionContext fieldsDefinition() throws RecognitionException {
    FieldsDefinitionContext _localctx = new FieldsDefinitionContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_fieldsDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(459);
        match(T__3);
        setState(461);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(460);
              fieldDefinition();
            }
          }
          setState(463);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0));
        setState(465);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FieldDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public ArgumentsDefinitionContext argumentsDefinition() {
      return getRuleContext(ArgumentsDefinitionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fieldDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterFieldDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitFieldDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitFieldDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
    FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_fieldDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(468);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(467);
            description();
          }
        }

        setState(470);
        name();
        setState(472);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__5) {
          {
            setState(471);
            argumentsDefinition();
          }
        }

        setState(474);
        match(T__7);
        setState(475);
        type_();
        setState(477);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(476);
            directives();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsDefinitionContext extends ParserRuleContext {
    public List<InputValueDefinitionContext> inputValueDefinition() {
      return getRuleContexts(InputValueDefinitionContext.class);
    }

    public InputValueDefinitionContext inputValueDefinition(int i) {
      return getRuleContext(InputValueDefinitionContext.class, i);
    }

    public ArgumentsDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentsDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterArgumentsDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitArgumentsDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitArgumentsDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentsDefinitionContext argumentsDefinition() throws RecognitionException {
    ArgumentsDefinitionContext _localctx = new ArgumentsDefinitionContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_argumentsDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(479);
        match(T__5);
        setState(481);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(480);
              inputValueDefinition();
            }
          }
          setState(483);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0));
        setState(485);
        match(T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InputValueDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DefaultValueContext defaultValue() {
      return getRuleContext(DefaultValueContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public InputValueDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inputValueDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInputValueDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInputValueDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInputValueDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InputValueDefinitionContext inputValueDefinition() throws RecognitionException {
    InputValueDefinitionContext _localctx = new InputValueDefinitionContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_inputValueDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(488);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(487);
            description();
          }
        }

        setState(490);
        name();
        setState(491);
        match(T__7);
        setState(492);
        type_();
        setState(494);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__17) {
          {
            setState(493);
            defaultValue();
          }
        }

        setState(497);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(496);
            directives();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ObjectTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public FieldsDefinitionContext fieldsDefinition() {
      return getRuleContext(FieldsDefinitionContext.class, 0);
    }

    public ImplementsInterfacesContext implementsInterfaces() {
      return getRuleContext(ImplementsInterfacesContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public ObjectTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterObjectTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitObjectTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitObjectTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectTypeExtensionContext objectTypeExtension() throws RecognitionException {
    ObjectTypeExtensionContext _localctx = new ObjectTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_objectTypeExtension);
    int _la;
    try {
      setState(523);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 60, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(499);
            match(T__21);
            setState(500);
            match(T__23);
            setState(501);
            name();
            setState(503);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__24) {
              {
                setState(502);
                implementsInterfaces(0);
              }
            }

            setState(506);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(505);
                directives();
              }
            }

            setState(508);
            fieldsDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(510);
            match(T__21);
            setState(511);
            match(T__23);
            setState(512);
            name();
            setState(514);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__24) {
              {
                setState(513);
                implementsInterfaces(0);
              }
            }

            setState(516);
            directives();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(518);
            match(T__21);
            setState(519);
            match(T__23);
            setState(520);
            name();
            setState(521);
            implementsInterfaces(0);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InterfaceTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public ImplementsInterfacesContext implementsInterfaces() {
      return getRuleContext(ImplementsInterfacesContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public FieldsDefinitionContext fieldsDefinition() {
      return getRuleContext(FieldsDefinitionContext.class, 0);
    }

    public InterfaceTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInterfaceTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInterfaceTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInterfaceTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceTypeDefinitionContext interfaceTypeDefinition()
      throws RecognitionException {
    InterfaceTypeDefinitionContext _localctx = new InterfaceTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_interfaceTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(526);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(525);
            description();
          }
        }

        setState(528);
        match(T__26);
        setState(529);
        name();
        setState(531);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__24) {
          {
            setState(530);
            implementsInterfaces(0);
          }
        }

        setState(534);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(533);
            directives();
          }
        }

        setState(537);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 64, _ctx)) {
          case 1:
            {
              setState(536);
              fieldsDefinition();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InterfaceTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public FieldsDefinitionContext fieldsDefinition() {
      return getRuleContext(FieldsDefinitionContext.class, 0);
    }

    public ImplementsInterfacesContext implementsInterfaces() {
      return getRuleContext(ImplementsInterfacesContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public InterfaceTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInterfaceTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInterfaceTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInterfaceTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceTypeExtensionContext interfaceTypeExtension() throws RecognitionException {
    InterfaceTypeExtensionContext _localctx = new InterfaceTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_interfaceTypeExtension);
    int _la;
    try {
      setState(558);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 68, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(539);
            match(T__21);
            setState(540);
            match(T__26);
            setState(541);
            name();
            setState(543);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__24) {
              {
                setState(542);
                implementsInterfaces(0);
              }
            }

            setState(546);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(545);
                directives();
              }
            }

            setState(548);
            fieldsDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(550);
            match(T__21);
            setState(551);
            match(T__26);
            setState(552);
            name();
            setState(554);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__24) {
              {
                setState(553);
                implementsInterfaces(0);
              }
            }

            setState(556);
            directives();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnionTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public UnionMemberTypesContext unionMemberTypes() {
      return getRuleContext(UnionMemberTypesContext.class, 0);
    }

    public UnionTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterUnionTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitUnionTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitUnionTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionTypeDefinitionContext unionTypeDefinition() throws RecognitionException {
    UnionTypeDefinitionContext _localctx = new UnionTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 114, RULE_unionTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(561);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(560);
            description();
          }
        }

        setState(563);
        match(T__27);
        setState(564);
        name();
        setState(566);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(565);
            directives();
          }
        }

        setState(569);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__17) {
          {
            setState(568);
            unionMemberTypes();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnionMemberTypesContext extends ParserRuleContext {
    public List<NamedTypeContext> namedType() {
      return getRuleContexts(NamedTypeContext.class);
    }

    public NamedTypeContext namedType(int i) {
      return getRuleContext(NamedTypeContext.class, i);
    }

    public UnionMemberTypesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionMemberTypes;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterUnionMemberTypes(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitUnionMemberTypes(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitUnionMemberTypes(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionMemberTypesContext unionMemberTypes() throws RecognitionException {
    UnionMemberTypesContext _localctx = new UnionMemberTypesContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_unionMemberTypes);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(571);
        match(T__17);
        setState(573);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__28) {
          {
            setState(572);
            match(T__28);
          }
        }

        setState(575);
        namedType();
        setState(580);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__28) {
          {
            {
              setState(576);
              match(T__28);
              setState(577);
              namedType();
            }
          }
          setState(582);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnionTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public UnionMemberTypesContext unionMemberTypes() {
      return getRuleContext(UnionMemberTypesContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public UnionTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterUnionTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitUnionTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitUnionTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionTypeExtensionContext unionTypeExtension() throws RecognitionException {
    UnionTypeExtensionContext _localctx = new UnionTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_unionTypeExtension);
    int _la;
    try {
      setState(596);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 75, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(583);
            match(T__21);
            setState(584);
            match(T__27);
            setState(585);
            name();
            setState(587);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(586);
                directives();
              }
            }

            setState(589);
            unionMemberTypes();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(591);
            match(T__21);
            setState(592);
            match(T__27);
            setState(593);
            name();
            setState(594);
            directives();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public EnumValuesDefinitionContext enumValuesDefinition() {
      return getRuleContext(EnumValuesDefinitionContext.class, 0);
    }

    public EnumTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterEnumTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitEnumTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitEnumTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumTypeDefinitionContext enumTypeDefinition() throws RecognitionException {
    EnumTypeDefinitionContext _localctx = new EnumTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_enumTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(599);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(598);
            description();
          }
        }

        setState(601);
        match(T__29);
        setState(602);
        name();
        setState(604);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(603);
            directives();
          }
        }

        setState(607);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 78, _ctx)) {
          case 1:
            {
              setState(606);
              enumValuesDefinition();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumValuesDefinitionContext extends ParserRuleContext {
    public List<EnumValueDefinitionContext> enumValueDefinition() {
      return getRuleContexts(EnumValueDefinitionContext.class);
    }

    public EnumValueDefinitionContext enumValueDefinition(int i) {
      return getRuleContext(EnumValueDefinitionContext.class, i);
    }

    public EnumValuesDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValuesDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterEnumValuesDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitEnumValuesDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitEnumValuesDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValuesDefinitionContext enumValuesDefinition() throws RecognitionException {
    EnumValuesDefinitionContext _localctx = new EnumValuesDefinitionContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_enumValuesDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(609);
        match(T__3);
        setState(611);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(610);
              enumValueDefinition();
            }
          }
          setState(613);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0));
        setState(615);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumValueDefinitionContext extends ParserRuleContext {
    public EnumValueContext enumValue() {
      return getRuleContext(EnumValueContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public EnumValueDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValueDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterEnumValueDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitEnumValueDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitEnumValueDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValueDefinitionContext enumValueDefinition() throws RecognitionException {
    EnumValueDefinitionContext _localctx = new EnumValueDefinitionContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_enumValueDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(618);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(617);
            description();
          }
        }

        setState(620);
        enumValue();
        setState(622);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(621);
            directives();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public EnumValuesDefinitionContext enumValuesDefinition() {
      return getRuleContext(EnumValuesDefinitionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public EnumTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterEnumTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitEnumTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitEnumTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumTypeExtensionContext enumTypeExtension() throws RecognitionException {
    EnumTypeExtensionContext _localctx = new EnumTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_enumTypeExtension);
    int _la;
    try {
      setState(637);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 83, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(624);
            match(T__21);
            setState(625);
            match(T__29);
            setState(626);
            name();
            setState(628);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(627);
                directives();
              }
            }

            setState(630);
            enumValuesDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(632);
            match(T__21);
            setState(633);
            match(T__29);
            setState(634);
            name();
            setState(635);
            directives();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InputObjectTypeDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public InputFieldsDefinitionContext inputFieldsDefinition() {
      return getRuleContext(InputFieldsDefinitionContext.class, 0);
    }

    public InputObjectTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inputObjectTypeDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInputObjectTypeDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInputObjectTypeDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInputObjectTypeDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InputObjectTypeDefinitionContext inputObjectTypeDefinition()
      throws RecognitionException {
    InputObjectTypeDefinitionContext _localctx =
        new InputObjectTypeDefinitionContext(_ctx, getState());
    enterRule(_localctx, 128, RULE_inputObjectTypeDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(640);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(639);
            description();
          }
        }

        setState(642);
        match(T__30);
        setState(643);
        name();
        setState(645);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__19) {
          {
            setState(644);
            directives();
          }
        }

        setState(648);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 86, _ctx)) {
          case 1:
            {
              setState(647);
              inputFieldsDefinition();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InputFieldsDefinitionContext extends ParserRuleContext {
    public List<InputValueDefinitionContext> inputValueDefinition() {
      return getRuleContexts(InputValueDefinitionContext.class);
    }

    public InputValueDefinitionContext inputValueDefinition(int i) {
      return getRuleContext(InputValueDefinitionContext.class, i);
    }

    public InputFieldsDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inputFieldsDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInputFieldsDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInputFieldsDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInputFieldsDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InputFieldsDefinitionContext inputFieldsDefinition() throws RecognitionException {
    InputFieldsDefinitionContext _localctx = new InputFieldsDefinitionContext(_ctx, getState());
    enterRule(_localctx, 130, RULE_inputFieldsDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(650);
        match(T__3);
        setState(652);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(651);
              inputValueDefinition();
            }
          }
          setState(654);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0));
        setState(656);
        match(T__4);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InputObjectTypeExtensionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public InputFieldsDefinitionContext inputFieldsDefinition() {
      return getRuleContext(InputFieldsDefinitionContext.class, 0);
    }

    public DirectivesContext directives() {
      return getRuleContext(DirectivesContext.class, 0);
    }

    public InputObjectTypeExtensionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inputObjectTypeExtension;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterInputObjectTypeExtension(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitInputObjectTypeExtension(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitInputObjectTypeExtension(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InputObjectTypeExtensionContext inputObjectTypeExtension()
      throws RecognitionException {
    InputObjectTypeExtensionContext _localctx =
        new InputObjectTypeExtensionContext(_ctx, getState());
    enterRule(_localctx, 132, RULE_inputObjectTypeExtension);
    int _la;
    try {
      setState(671);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 89, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(658);
            match(T__21);
            setState(659);
            match(T__30);
            setState(660);
            name();
            setState(662);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__19) {
              {
                setState(661);
                directives();
              }
            }

            setState(664);
            inputFieldsDefinition();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(666);
            match(T__21);
            setState(667);
            match(T__30);
            setState(668);
            name();
            setState(669);
            directives();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DirectiveDefinitionContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public DirectiveLocationsContext directiveLocations() {
      return getRuleContext(DirectiveLocationsContext.class, 0);
    }

    public DescriptionContext description() {
      return getRuleContext(DescriptionContext.class, 0);
    }

    public ArgumentsDefinitionContext argumentsDefinition() {
      return getRuleContext(ArgumentsDefinitionContext.class, 0);
    }

    public DirectiveDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directiveDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterDirectiveDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitDirectiveDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDirectiveDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectiveDefinitionContext directiveDefinition() throws RecognitionException {
    DirectiveDefinitionContext _localctx = new DirectiveDefinitionContext(_ctx, getState());
    enterRule(_localctx, 134, RULE_directiveDefinition);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(674);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING || _la == BLOCK_STRING) {
          {
            setState(673);
            description();
          }
        }

        setState(676);
        match(T__31);
        setState(677);
        match(T__19);
        setState(678);
        name();
        setState(680);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__5) {
          {
            setState(679);
            argumentsDefinition();
          }
        }

        setState(683);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__32) {
          {
            setState(682);
            match(T__32);
          }
        }

        setState(685);
        match(T__10);
        setState(686);
        directiveLocations();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DirectiveLocationsContext extends ParserRuleContext {
    public List<DirectiveLocationContext> directiveLocation() {
      return getRuleContexts(DirectiveLocationContext.class);
    }

    public DirectiveLocationContext directiveLocation(int i) {
      return getRuleContext(DirectiveLocationContext.class, i);
    }

    public DirectiveLocationsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directiveLocations;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterDirectiveLocations(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitDirectiveLocations(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDirectiveLocations(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectiveLocationsContext directiveLocations() throws RecognitionException {
    DirectiveLocationsContext _localctx = new DirectiveLocationsContext(_ctx, getState());
    enterRule(_localctx, 136, RULE_directiveLocations);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(688);
        directiveLocation();
        setState(693);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__28) {
          {
            {
              setState(689);
              match(T__28);
              setState(690);
              directiveLocation();
            }
          }
          setState(695);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DirectiveLocationContext extends ParserRuleContext {
    public ExecutableDirectiveLocationContext executableDirectiveLocation() {
      return getRuleContext(ExecutableDirectiveLocationContext.class, 0);
    }

    public TypeSystemDirectiveLocationContext typeSystemDirectiveLocation() {
      return getRuleContext(TypeSystemDirectiveLocationContext.class, 0);
    }

    public DirectiveLocationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directiveLocation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterDirectiveLocation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitDirectiveLocation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitDirectiveLocation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectiveLocationContext directiveLocation() throws RecognitionException {
    DirectiveLocationContext _localctx = new DirectiveLocationContext(_ctx, getState());
    enterRule(_localctx, 138, RULE_directiveLocation);
    try {
      setState(698);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__33:
        case T__34:
        case T__35:
        case T__36:
        case T__37:
        case T__38:
        case T__39:
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(696);
            executableDirectiveLocation();
          }
          break;
        case T__41:
        case T__42:
        case T__43:
        case T__44:
        case T__45:
        case T__46:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
          enterOuterAlt(_localctx, 2);
          {
            setState(697);
            typeSystemDirectiveLocation();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExecutableDirectiveLocationContext extends ParserRuleContext {
    public ExecutableDirectiveLocationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_executableDirectiveLocation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterExecutableDirectiveLocation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitExecutableDirectiveLocation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitExecutableDirectiveLocation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExecutableDirectiveLocationContext executableDirectiveLocation()
      throws RecognitionException {
    ExecutableDirectiveLocationContext _localctx =
        new ExecutableDirectiveLocationContext(_ctx, getState());
    enterRule(_localctx, 140, RULE_executableDirectiveLocation);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(700);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 4380866641920L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSystemDirectiveLocationContext extends ParserRuleContext {
    public TypeSystemDirectiveLocationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSystemDirectiveLocation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).enterTypeSystemDirectiveLocation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener)
        ((GraphQLListener) listener).exitTypeSystemDirectiveLocation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitTypeSystemDirectiveLocation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSystemDirectiveLocationContext typeSystemDirectiveLocation()
      throws RecognitionException {
    TypeSystemDirectiveLocationContext _localctx =
        new TypeSystemDirectiveLocationContext(_ctx, getState());
    enterRule(_localctx, 142, RULE_typeSystemDirectiveLocation);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(702);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 9002801208229888L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NameContext extends ParserRuleContext {
    public TerminalNode NAME() {
      return getToken(GraphQLParser.NAME, 0);
    }

    public NameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_name;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof GraphQLVisitor)
        return ((GraphQLVisitor<? extends T>) visitor).visitName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NameContext name() throws RecognitionException {
    NameContext _localctx = new NameContext(_ctx, getState());
    enterRule(_localctx, 144, RULE_name);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(704);
        match(NAME);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 49:
        return implementsInterfaces_sempred((ImplementsInterfacesContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean implementsInterfaces_sempred(
      ImplementsInterfacesContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 1);
    }
    return true;
  }

  public static final String _serializedATN =
      "\u0004\u0001B\u02c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"
          + "#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"
          + "(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"
          + "-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"
          + "2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"
          + "7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"
          + "<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"
          + "A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"
          + "F\u0007F\u0002G\u0007G\u0002H\u0007H\u0001\u0000\u0004\u0000\u0094\b\u0000"
          + "\u000b\u0000\f\u0000\u0095\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0003\u0001\u009d\b\u0001\u0001\u0002\u0004\u0002\u00a0\b"
          + "\u0002\u000b\u0002\f\u0002\u00a1\u0001\u0003\u0001\u0003\u0003\u0003\u00a6"
          + "\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00aa\b\u0004\u0001\u0004"
          + "\u0003\u0004\u00ad\b\u0004\u0001\u0004\u0003\u0004\u00b0\b\u0004\u0001"
          + "\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b5\b\u0004\u0001\u0005\u0001"
          + "\u0005\u0001\u0006\u0001\u0006\u0004\u0006\u00bb\b\u0006\u000b\u0006\f"
          + "\u0006\u00bc\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0003\u0007\u00c4\b\u0007\u0001\b\u0003\b\u00c7\b\b\u0001\b\u0001\b\u0003"
          + "\b\u00cb\b\b\u0001\b\u0003\b\u00ce\b\b\u0001\b\u0003\b\u00d1\b\b\u0001"
          + "\t\u0001\t\u0004\t\u00d5\b\t\u000b\t\f\t\u00d6\u0001\t\u0001\t\u0001\n"
          + "\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"
          + "\f\u0001\f\u0003\f\u00e5\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00eb"
          + "\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"
          + "\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00f6\b\u0010\u0001\u0010\u0003"
          + "\u0010\u00f9\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"
          + "\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"
          + "\u0011\u0003\u0011\u0106\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"
          + "\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"
          + "\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"
          + "\u0018\u0004\u0018\u0118\b\u0018\u000b\u0018\f\u0018\u0119\u0001\u0018"
          + "\u0001\u0018\u0003\u0018\u011e\b\u0018\u0001\u0019\u0001\u0019\u0005\u0019"
          + "\u0122\b\u0019\n\u0019\f\u0019\u0125\t\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"
          + "\u001b\u0001\u001c\u0001\u001c\u0004\u001c\u0132\b\u001c\u000b\u001c\f"
          + "\u001c\u0133\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"
          + "\u0001\u001d\u0003\u001d\u013c\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"
          + "\u0001\u001f\u0001\u001f\u0003\u001f\u0143\b\u001f\u0001\u001f\u0001\u001f"
          + "\u0003\u001f\u0147\b\u001f\u0003\u001f\u0149\b\u001f\u0001 \u0001 \u0001"
          + "!\u0001!\u0001!\u0001!\u0001\"\u0004\"\u0152\b\"\u000b\"\f\"\u0153\u0001"
          + "#\u0001#\u0001#\u0003#\u0159\b#\u0001$\u0004$\u015c\b$\u000b$\f$\u015d"
          + "\u0001%\u0001%\u0001%\u0003%\u0163\b%\u0001&\u0004&\u0166\b&\u000b&\f"
          + "&\u0167\u0001\'\u0001\'\u0003\'\u016c\b\'\u0001(\u0001(\u0003(\u0170\b"
          + "(\u0001(\u0001(\u0004(\u0174\b(\u000b(\f(\u0175\u0001(\u0001(\u0001)\u0001"
          + ")\u0001)\u0001)\u0001*\u0001*\u0001*\u0003*\u0181\b*\u0001*\u0001*\u0004"
          + "*\u0185\b*\u000b*\f*\u0186\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u018e"
          + "\b*\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003,\u0198"
          + "\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u01a0\b-\u0001.\u0003"
          + ".\u01a3\b.\u0001.\u0001.\u0001.\u0003.\u01a8\b.\u0001/\u0001/\u0001/\u0001"
          + "/\u0001/\u00010\u00030\u01b0\b0\u00010\u00010\u00010\u00030\u01b5\b0\u0001"
          + "0\u00030\u01b8\b0\u00010\u00030\u01bb\b0\u00011\u00011\u00011\u00031\u01c0"
          + "\b1\u00011\u00011\u00011\u00011\u00011\u00051\u01c7\b1\n1\f1\u01ca\t1"
          + "\u00012\u00012\u00042\u01ce\b2\u000b2\f2\u01cf\u00012\u00012\u00013\u0003"
          + "3\u01d5\b3\u00013\u00013\u00033\u01d9\b3\u00013\u00013\u00013\u00033\u01de"
          + "\b3\u00014\u00014\u00044\u01e2\b4\u000b4\f4\u01e3\u00014\u00014\u0001"
          + "5\u00035\u01e9\b5\u00015\u00015\u00015\u00015\u00035\u01ef\b5\u00015\u0003"
          + "5\u01f2\b5\u00016\u00016\u00016\u00016\u00036\u01f8\b6\u00016\u00036\u01fb"
          + "\b6\u00016\u00016\u00016\u00016\u00016\u00016\u00036\u0203\b6\u00016\u0001"
          + "6\u00016\u00016\u00016\u00016\u00016\u00036\u020c\b6\u00017\u00037\u020f"
          + "\b7\u00017\u00017\u00017\u00037\u0214\b7\u00017\u00037\u0217\b7\u0001"
          + "7\u00037\u021a\b7\u00018\u00018\u00018\u00018\u00038\u0220\b8\u00018\u0003"
          + "8\u0223\b8\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u022b\b8\u0001"
          + "8\u00018\u00038\u022f\b8\u00019\u00039\u0232\b9\u00019\u00019\u00019\u0003"
          + "9\u0237\b9\u00019\u00039\u023a\b9\u0001:\u0001:\u0003:\u023e\b:\u0001"
          + ":\u0001:\u0001:\u0005:\u0243\b:\n:\f:\u0246\t:\u0001;\u0001;\u0001;\u0001"
          + ";\u0003;\u024c\b;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0003"
          + ";\u0255\b;\u0001<\u0003<\u0258\b<\u0001<\u0001<\u0001<\u0003<\u025d\b"
          + "<\u0001<\u0003<\u0260\b<\u0001=\u0001=\u0004=\u0264\b=\u000b=\f=\u0265"
          + "\u0001=\u0001=\u0001>\u0003>\u026b\b>\u0001>\u0001>\u0003>\u026f\b>\u0001"
          + "?\u0001?\u0001?\u0001?\u0003?\u0275\b?\u0001?\u0001?\u0001?\u0001?\u0001"
          + "?\u0001?\u0001?\u0003?\u027e\b?\u0001@\u0003@\u0281\b@\u0001@\u0001@\u0001"
          + "@\u0003@\u0286\b@\u0001@\u0003@\u0289\b@\u0001A\u0001A\u0004A\u028d\b"
          + "A\u000bA\fA\u028e\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0003B\u0297"
          + "\bB\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0003B\u02a0\bB\u0001"
          + "C\u0003C\u02a3\bC\u0001C\u0001C\u0001C\u0001C\u0003C\u02a9\bC\u0001C\u0003"
          + "C\u02ac\bC\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0005D\u02b4\bD\n"
          + "D\fD\u02b7\tD\u0001E\u0001E\u0003E\u02bb\bE\u0001F\u0001F\u0001G\u0001"
          + "G\u0001H\u0001H\u0001H\u0000\u0001bI\u0000\u0002\u0004\u0006\b\n\f\u000e"
          + "\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"
          + "HJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"
          + "\u008e\u0090\u0000\u0005\u0001\u0000\u0001\u0003\u0001\u0000\f\r\u0001"
          + "\u000067\u0001\u0000\")\u0001\u0000*4\u02eb\u0000\u0093\u0001\u0000\u0000"
          + "\u0000\u0002\u009c\u0001\u0000\u0000\u0000\u0004\u009f\u0001\u0000\u0000"
          + "\u0000\u0006\u00a5\u0001\u0000\u0000\u0000\b\u00b4\u0001\u0000\u0000\u0000"
          + "\n\u00b6\u0001\u0000\u0000\u0000\f\u00b8\u0001\u0000\u0000\u0000\u000e"
          + "\u00c3\u0001\u0000\u0000\u0000\u0010\u00c6\u0001\u0000\u0000\u0000\u0012"
          + "\u00d2\u0001\u0000\u0000\u0000\u0014\u00da\u0001\u0000\u0000\u0000\u0016"
          + "\u00de\u0001\u0000\u0000\u0000\u0018\u00e1\u0001\u0000\u0000\u0000\u001a"
          + "\u00e6\u0001\u0000\u0000\u0000\u001c\u00ee\u0001\u0000\u0000\u0000\u001e"
          + "\u00f0\u0001\u0000\u0000\u0000 \u00f3\u0001\u0000\u0000\u0000\"\u0105"
          + "\u0001\u0000\u0000\u0000$\u0107\u0001\u0000\u0000\u0000&\u0109\u0001\u0000"
          + "\u0000\u0000(\u010b\u0001\u0000\u0000\u0000*\u010d\u0001\u0000\u0000\u0000"
          + ",\u010f\u0001\u0000\u0000\u0000.\u0111\u0001\u0000\u0000\u00000\u011d"
          + "\u0001\u0000\u0000\u00002\u011f\u0001\u0000\u0000\u00004\u0128\u0001\u0000"
          + "\u0000\u00006\u012c\u0001\u0000\u0000\u00008\u012f\u0001\u0000\u0000\u0000"
          + ":\u0137\u0001\u0000\u0000\u0000<\u013d\u0001\u0000\u0000\u0000>\u0148"
          + "\u0001\u0000\u0000\u0000@\u014a\u0001\u0000\u0000\u0000B\u014c\u0001\u0000"
          + "\u0000\u0000D\u0151\u0001\u0000\u0000\u0000F\u0155\u0001\u0000\u0000\u0000"
          + "H\u015b\u0001\u0000\u0000\u0000J\u0162\u0001\u0000\u0000\u0000L\u0165"
          + "\u0001\u0000\u0000\u0000N\u016b\u0001\u0000\u0000\u0000P\u016d\u0001\u0000"
          + "\u0000\u0000R\u0179\u0001\u0000\u0000\u0000T\u018d\u0001\u0000\u0000\u0000"
          + "V\u018f\u0001\u0000\u0000\u0000X\u0197\u0001\u0000\u0000\u0000Z\u019f"
          + "\u0001\u0000\u0000\u0000\\\u01a2\u0001\u0000\u0000\u0000^\u01a9\u0001"
          + "\u0000\u0000\u0000`\u01af\u0001\u0000\u0000\u0000b\u01bc\u0001\u0000\u0000"
          + "\u0000d\u01cb\u0001\u0000\u0000\u0000f\u01d4\u0001\u0000\u0000\u0000h"
          + "\u01df\u0001\u0000\u0000\u0000j\u01e8\u0001\u0000\u0000\u0000l\u020b\u0001"
          + "\u0000\u0000\u0000n\u020e\u0001\u0000\u0000\u0000p\u022e\u0001\u0000\u0000"
          + "\u0000r\u0231\u0001\u0000\u0000\u0000t\u023b\u0001\u0000\u0000\u0000v"
          + "\u0254\u0001\u0000\u0000\u0000x\u0257\u0001\u0000\u0000\u0000z\u0261\u0001"
          + "\u0000\u0000\u0000|\u026a\u0001\u0000\u0000\u0000~\u027d\u0001\u0000\u0000"
          + "\u0000\u0080\u0280\u0001\u0000\u0000\u0000\u0082\u028a\u0001\u0000\u0000"
          + "\u0000\u0084\u029f\u0001\u0000\u0000\u0000\u0086\u02a2\u0001\u0000\u0000"
          + "\u0000\u0088\u02b0\u0001\u0000\u0000\u0000\u008a\u02ba\u0001\u0000\u0000"
          + "\u0000\u008c\u02bc\u0001\u0000\u0000\u0000\u008e\u02be\u0001\u0000\u0000"
          + "\u0000\u0090\u02c0\u0001\u0000\u0000\u0000\u0092\u0094\u0003\u0002\u0001"
          + "\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"
          + "\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"
          + "\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0000\u0000"
          + "\u0001\u0098\u0001\u0001\u0000\u0000\u0000\u0099\u009d\u0003\u0004\u0002"
          + "\u0000\u009a\u009d\u0003H$\u0000\u009b\u009d\u0003L&\u0000\u009c\u0099"
          + "\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b"
          + "\u0001\u0000\u0000\u0000\u009d\u0003\u0001\u0000\u0000\u0000\u009e\u00a0"
          + "\u0003\u0006\u0003\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1"
          + "\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2"
          + "\u0001\u0000\u0000\u0000\u00a2\u0005\u0001\u0000\u0000\u0000\u00a3\u00a6"
          + "\u0003\b\u0004\u0000\u00a4\u00a6\u0003\u001a\r\u0000\u00a5\u00a3\u0001"
          + "\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u0007\u0001"
          + "\u0000\u0000\u0000\u00a7\u00a9\u0003\n\u0005\u0000\u00a8\u00aa\u0003\u0090"
          + "H\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"
          + "\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00ad\u00038\u001c\u0000"
          + "\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"
          + "\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00b0\u0003D\"\u0000\u00af"
          + "\u00ae\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"
          + "\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0003\f\u0006\u0000\u00b2\u00b5"
          + "\u0001\u0000\u0000\u0000\u00b3\u00b5\u0003\f\u0006\u0000\u00b4\u00a7\u0001"
          + "\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\t\u0001\u0000"
          + "\u0000\u0000\u00b6\u00b7\u0007\u0000\u0000\u0000\u00b7\u000b\u0001\u0000"
          + "\u0000\u0000\u00b8\u00ba\u0005\u0004\u0000\u0000\u00b9\u00bb\u0003\u000e"
          + "\u0007\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"
          + "\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"
          + "\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u0005"
          + "\u0000\u0000\u00bf\r\u0001\u0000\u0000\u0000\u00c0\u00c4\u0003\u0010\b"
          + "\u0000\u00c1\u00c4\u0003\u0018\f\u0000\u00c2\u00c4\u0003 \u0010\u0000"
          + "\u00c3\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"
          + "\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4\u000f\u0001\u0000\u0000\u0000"
          + "\u00c5\u00c7\u0003\u0016\u000b\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000"
          + "\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000"
          + "\u00c8\u00ca\u0003\u0090H\u0000\u00c9\u00cb\u0003\u0012\t\u0000\u00ca"
          + "\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"
          + "\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003D\"\u0000\u00cd\u00cc"
          + "\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0"
          + "\u0001\u0000\u0000\u0000\u00cf\u00d1\u0003\f\u0006\u0000\u00d0\u00cf\u0001"
          + "\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u0011\u0001"
          + "\u0000\u0000\u0000\u00d2\u00d4\u0005\u0006\u0000\u0000\u00d3\u00d5\u0003"
          + "\u0014\n\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"
          + "\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"
          + "\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0007"
          + "\u0000\u0000\u00d9\u0013\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u0090"
          + "H\u0000\u00db\u00dc\u0005\b\u0000\u0000\u00dc\u00dd\u0003\"\u0011\u0000"
          + "\u00dd\u0015\u0001\u0000\u0000\u0000\u00de\u00df\u0003\u0090H\u0000\u00df"
          + "\u00e0\u0005\b\u0000\u0000\u00e0\u0017\u0001\u0000\u0000\u0000\u00e1\u00e2"
          + "\u0005\t\u0000\u0000\u00e2\u00e4\u0003\u001c\u000e\u0000\u00e3\u00e5\u0003"
          + "D\"\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"
          + "\u0000\u0000\u00e5\u0019\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\n\u0000"
          + "\u0000\u00e7\u00e8\u0003\u001c\u000e\u0000\u00e8\u00ea\u0003\u001e\u000f"
          + "\u0000\u00e9\u00eb\u0003D\"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000"
          + "\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000"
          + "\u00ec\u00ed\u0003\f\u0006\u0000\u00ed\u001b\u0001\u0000\u0000\u0000\u00ee"
          + "\u00ef\u0003\u0090H\u0000\u00ef\u001d\u0001\u0000\u0000\u0000\u00f0\u00f1"
          + "\u0005\u000b\u0000\u0000\u00f1\u00f2\u0003@ \u0000\u00f2\u001f\u0001\u0000"
          + "\u0000\u0000\u00f3\u00f5\u0005\t\u0000\u0000\u00f4\u00f6\u0003\u001e\u000f"
          + "\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"
          + "\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f9\u0003D\"\u0000"
          + "\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000"
          + "\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003\f\u0006\u0000\u00fb"
          + "!\u0001\u0000\u0000\u0000\u00fc\u0106\u00036\u001b\u0000\u00fd\u0106\u0003"
          + "$\u0012\u0000\u00fe\u0106\u0003&\u0013\u0000\u00ff\u0106\u0003*\u0015"
          + "\u0000\u0100\u0106\u0003(\u0014\u0000\u0101\u0106\u0003,\u0016\u0000\u0102"
          + "\u0106\u0003.\u0017\u0000\u0103\u0106\u00030\u0018\u0000\u0104\u0106\u0003"
          + "2\u0019\u0000\u0105\u00fc\u0001\u0000\u0000\u0000\u0105\u00fd\u0001\u0000"
          + "\u0000\u0000\u0105\u00fe\u0001\u0000\u0000\u0000\u0105\u00ff\u0001\u0000"
          + "\u0000\u0000\u0105\u0100\u0001\u0000\u0000\u0000\u0105\u0101\u0001\u0000"
          + "\u0000\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"
          + "\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106#\u0001\u0000\u0000"
          + "\u0000\u0107\u0108\u0005:\u0000\u0000\u0108%\u0001\u0000\u0000\u0000\u0109"
          + "\u010a\u00059\u0000\u0000\u010a\'\u0001\u0000\u0000\u0000\u010b\u010c"
          + "\u0007\u0001\u0000\u0000\u010c)\u0001\u0000\u0000\u0000\u010d\u010e\u0007"
          + "\u0002\u0000\u0000\u010e+\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u000e"
          + "\u0000\u0000\u0110-\u0001\u0000\u0000\u0000\u0111\u0112\u0003\u0090H\u0000"
          + "\u0112/\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u000f\u0000\u0000\u0114"
          + "\u011e\u0005\u0010\u0000\u0000\u0115\u0117\u0005\u000f\u0000\u0000\u0116"
          + "\u0118\u0003\"\u0011\u0000\u0117\u0116\u0001\u0000\u0000\u0000\u0118\u0119"
          + "\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a"
          + "\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c"
          + "\u0005\u0010\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u0113"
          + "\u0001\u0000\u0000\u0000\u011d\u0115\u0001\u0000\u0000\u0000\u011e1\u0001"
          + "\u0000\u0000\u0000\u011f\u0123\u0005\u0004\u0000\u0000\u0120\u0122\u0003"
          + "4\u001a\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122\u0125\u0001\u0000"
          + "\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000"
          + "\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000"
          + "\u0000\u0000\u0126\u0127\u0005\u0005\u0000\u0000\u01273\u0001\u0000\u0000"
          + "\u0000\u0128\u0129\u0003\u0090H\u0000\u0129\u012a\u0005\b\u0000\u0000"
          + "\u012a\u012b\u0003\"\u0011\u0000\u012b5\u0001\u0000\u0000\u0000\u012c"
          + "\u012d\u0005\u0011\u0000\u0000\u012d\u012e\u0003\u0090H\u0000\u012e7\u0001"
          + "\u0000\u0000\u0000\u012f\u0131\u0005\u0006\u0000\u0000\u0130\u0132\u0003"
          + ":\u001d\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"
          + "\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000"
          + "\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0005\u0007"
          + "\u0000\u0000\u01369\u0001\u0000\u0000\u0000\u0137\u0138\u00036\u001b\u0000"
          + "\u0138\u0139\u0005\b\u0000\u0000\u0139\u013b\u0003>\u001f\u0000\u013a"
          + "\u013c\u0003<\u001e\u0000\u013b\u013a\u0001\u0000\u0000\u0000\u013b\u013c"
          + "\u0001\u0000\u0000\u0000\u013c;\u0001\u0000\u0000\u0000\u013d\u013e\u0005"
          + "\u0012\u0000\u0000\u013e\u013f\u0003\"\u0011\u0000\u013f=\u0001\u0000"
          + "\u0000\u0000\u0140\u0142\u0003@ \u0000\u0141\u0143\u0005\u0013\u0000\u0000"
          + "\u0142\u0141\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000"
          + "\u0143\u0149\u0001\u0000\u0000\u0000\u0144\u0146\u0003B!\u0000\u0145\u0147"
          + "\u0005\u0013\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0146\u0147"
          + "\u0001\u0000\u0000\u0000\u0147\u0149\u0001\u0000\u0000\u0000\u0148\u0140"
          + "\u0001\u0000\u0000\u0000\u0148\u0144\u0001\u0000\u0000\u0000\u0149?\u0001"
          + "\u0000\u0000\u0000\u014a\u014b\u0003\u0090H\u0000\u014bA\u0001\u0000\u0000"
          + "\u0000\u014c\u014d\u0005\u000f\u0000\u0000\u014d\u014e\u0003>\u001f\u0000"
          + "\u014e\u014f\u0005\u0010\u0000\u0000\u014fC\u0001\u0000\u0000\u0000\u0150"
          + "\u0152\u0003F#\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001"
          + "\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001"
          + "\u0000\u0000\u0000\u0154E\u0001\u0000\u0000\u0000\u0155\u0156\u0005\u0014"
          + "\u0000\u0000\u0156\u0158\u0003\u0090H\u0000\u0157\u0159\u0003\u0012\t"
          + "\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"
          + "\u0000\u0159G\u0001\u0000\u0000\u0000\u015a\u015c\u0003J%\u0000\u015b"
          + "\u015a\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"
          + "\u015b\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e"
          + "I\u0001\u0000\u0000\u0000\u015f\u0163\u0003P(\u0000\u0160\u0163\u0003"
          + "X,\u0000\u0161\u0163\u0003\u0086C\u0000\u0162\u015f\u0001\u0000\u0000"
          + "\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0161\u0001\u0000\u0000"
          + "\u0000\u0163K\u0001\u0000\u0000\u0000\u0164\u0166\u0003N\'\u0000\u0165"
          + "\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167"
          + "\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168"
          + "M\u0001\u0000\u0000\u0000\u0169\u016c\u0003T*\u0000\u016a\u016c\u0003"
          + "Z-\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016a\u0001\u0000\u0000"
          + "\u0000\u016cO\u0001\u0000\u0000\u0000\u016d\u016f\u0005\u0015\u0000\u0000"
          + "\u016e\u0170\u0003D\"\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u016f"
          + "\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171"
          + "\u0173\u0005\u0004\u0000\u0000\u0172\u0174\u0003R)\u0000\u0173\u0172\u0001"
          + "\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0173\u0001"
          + "\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0001"
          + "\u0000\u0000\u0000\u0177\u0178\u0005\u0005\u0000\u0000\u0178Q\u0001\u0000"
          + "\u0000\u0000\u0179\u017a\u0003\n\u0005\u0000\u017a\u017b\u0005\b\u0000"
          + "\u0000\u017b\u017c\u0003@ \u0000\u017cS\u0001\u0000\u0000\u0000\u017d"
          + "\u017e\u0005\u0016\u0000\u0000\u017e\u0180\u0005\u0015\u0000\u0000\u017f"
          + "\u0181\u0003D\"\u0000\u0180\u017f\u0001\u0000\u0000\u0000\u0180\u0181"
          + "\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0184"
          + "\u0005\u0004\u0000\u0000\u0183\u0185\u0003R)\u0000\u0184\u0183\u0001\u0000"
          + "\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000"
          + "\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000"
          + "\u0000\u0000\u0188\u0189\u0005\u0005\u0000\u0000\u0189\u018e\u0001\u0000"
          + "\u0000\u0000\u018a\u018b\u0005\u0016\u0000\u0000\u018b\u018c\u0005\u0015"
          + "\u0000\u0000\u018c\u018e\u0003D\"\u0000\u018d\u017d\u0001\u0000\u0000"
          + "\u0000\u018d\u018a\u0001\u0000\u0000\u0000\u018eU\u0001\u0000\u0000\u0000"
          + "\u018f\u0190\u0003*\u0015\u0000\u0190W\u0001\u0000\u0000\u0000\u0191\u0198"
          + "\u0003\\.\u0000\u0192\u0198\u0003`0\u0000\u0193\u0198\u0003n7\u0000\u0194"
          + "\u0198\u0003r9\u0000\u0195\u0198\u0003x<\u0000\u0196\u0198\u0003\u0080"
          + "@\u0000\u0197\u0191\u0001\u0000\u0000\u0000\u0197\u0192\u0001\u0000\u0000"
          + "\u0000\u0197\u0193\u0001\u0000\u0000\u0000\u0197\u0194\u0001\u0000\u0000"
          + "\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0196\u0001\u0000\u0000"
          + "\u0000\u0198Y\u0001\u0000\u0000\u0000\u0199\u01a0\u0003^/\u0000\u019a"
          + "\u01a0\u0003l6\u0000\u019b\u01a0\u0003p8\u0000\u019c\u01a0\u0003v;\u0000"
          + "\u019d\u01a0\u0003~?\u0000\u019e\u01a0\u0003\u0084B\u0000\u019f\u0199"
          + "\u0001\u0000\u0000\u0000\u019f\u019a\u0001\u0000\u0000\u0000\u019f\u019b"
          + "\u0001\u0000\u0000\u0000\u019f\u019c\u0001\u0000\u0000\u0000\u019f\u019d"
          + "\u0001\u0000\u0000\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u01a0[\u0001"
          + "\u0000\u0000\u0000\u01a1\u01a3\u0003V+\u0000\u01a2\u01a1\u0001\u0000\u0000"
          + "\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000"
          + "\u0000\u01a4\u01a5\u0005\u0017\u0000\u0000\u01a5\u01a7\u0003\u0090H\u0000"
          + "\u01a6\u01a8\u0003D\"\u0000\u01a7\u01a6\u0001\u0000\u0000\u0000\u01a7"
          + "\u01a8\u0001\u0000\u0000\u0000\u01a8]\u0001\u0000\u0000\u0000\u01a9\u01aa"
          + "\u0005\u0016\u0000\u0000\u01aa\u01ab\u0005\u0017\u0000\u0000\u01ab\u01ac"
          + "\u0003\u0090H\u0000\u01ac\u01ad\u0003D\"\u0000\u01ad_\u0001\u0000\u0000"
          + "\u0000\u01ae\u01b0\u0003V+\u0000\u01af\u01ae\u0001\u0000\u0000\u0000\u01af"
          + "\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1"
          + "\u01b2\u0005\u0018\u0000\u0000\u01b2\u01b4\u0003\u0090H\u0000\u01b3\u01b5"
          + "\u0003b1\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000"
          + "\u0000\u0000\u01b5\u01b7\u0001\u0000\u0000\u0000\u01b6\u01b8\u0003D\""
          + "\u0000\u01b7\u01b6\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000"
          + "\u0000\u01b8\u01ba\u0001\u0000\u0000\u0000\u01b9\u01bb\u0003d2\u0000\u01ba"
          + "\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb"
          + "a\u0001\u0000\u0000\u0000\u01bc\u01bd\u00061\uffff\uffff\u0000\u01bd\u01bf"
          + "\u0005\u0019\u0000\u0000\u01be\u01c0\u0005\u001a\u0000\u0000\u01bf\u01be"
          + "\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c1"
          + "\u0001\u0000\u0000\u0000\u01c1\u01c2\u0003@ \u0000\u01c2\u01c8\u0001\u0000"
          + "\u0000\u0000\u01c3\u01c4\n\u0001\u0000\u0000\u01c4\u01c5\u0005\u001a\u0000"
          + "\u0000\u01c5\u01c7\u0003@ \u0000\u01c6\u01c3\u0001\u0000\u0000\u0000\u01c7"
          + "\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8"
          + "\u01c9\u0001\u0000\u0000\u0000\u01c9c\u0001\u0000\u0000\u0000\u01ca\u01c8"
          + "\u0001\u0000\u0000\u0000\u01cb\u01cd\u0005\u0004\u0000\u0000\u01cc\u01ce"
          + "\u0003f3\u0000\u01cd\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000"
          + "\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000"
          + "\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005\u0005"
          + "\u0000\u0000\u01d2e\u0001\u0000\u0000\u0000\u01d3\u01d5\u0003V+\u0000"
          + "\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000"
          + "\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d8\u0003\u0090H\u0000\u01d7"
          + "\u01d9\u0003h4\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001"
          + "\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db\u0005"
          + "\b\u0000\u0000\u01db\u01dd\u0003>\u001f\u0000\u01dc\u01de\u0003D\"\u0000"
          + "\u01dd\u01dc\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000"
          + "\u01deg\u0001\u0000\u0000\u0000\u01df\u01e1\u0005\u0006\u0000\u0000\u01e0"
          + "\u01e2\u0003j5\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001"
          + "\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001"
          + "\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005"
          + "\u0007\u0000\u0000\u01e6i\u0001\u0000\u0000\u0000\u01e7\u01e9\u0003V+"
          + "\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000"
          + "\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea\u01eb\u0003\u0090H\u0000"
          + "\u01eb\u01ec\u0005\b\u0000\u0000\u01ec\u01ee\u0003>\u001f\u0000\u01ed"
          + "\u01ef\u0003<\u001e\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef"
          + "\u0001\u0000\u0000\u0000\u01ef\u01f1\u0001\u0000\u0000\u0000\u01f0\u01f2"
          + "\u0003D\"\u0000\u01f1\u01f0\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001"
          + "\u0000\u0000\u0000\u01f2k\u0001\u0000\u0000\u0000\u01f3\u01f4\u0005\u0016"
          + "\u0000\u0000\u01f4\u01f5\u0005\u0018\u0000\u0000\u01f5\u01f7\u0003\u0090"
          + "H\u0000\u01f6\u01f8\u0003b1\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000"
          + "\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8\u01fa\u0001\u0000\u0000\u0000"
          + "\u01f9\u01fb\u0003D\"\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fa"
          + "\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc"
          + "\u01fd\u0003d2\u0000\u01fd\u020c\u0001\u0000\u0000\u0000\u01fe\u01ff\u0005"
          + "\u0016\u0000\u0000\u01ff\u0200\u0005\u0018\u0000\u0000\u0200\u0202\u0003"
          + "\u0090H\u0000\u0201\u0203\u0003b1\u0000\u0202\u0201\u0001\u0000\u0000"
          + "\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000"
          + "\u0000\u0204\u0205\u0003D\"\u0000\u0205\u020c\u0001\u0000\u0000\u0000"
          + "\u0206\u0207\u0005\u0016\u0000\u0000\u0207\u0208\u0005\u0018\u0000\u0000"
          + "\u0208\u0209\u0003\u0090H\u0000\u0209\u020a\u0003b1\u0000\u020a\u020c"
          + "\u0001\u0000\u0000\u0000\u020b\u01f3\u0001\u0000\u0000\u0000\u020b\u01fe"
          + "\u0001\u0000\u0000\u0000\u020b\u0206\u0001\u0000\u0000\u0000\u020cm\u0001"
          + "\u0000\u0000\u0000\u020d\u020f\u0003V+\u0000\u020e\u020d\u0001\u0000\u0000"
          + "\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000"
          + "\u0000\u0210\u0211\u0005\u001b\u0000\u0000\u0211\u0213\u0003\u0090H\u0000"
          + "\u0212\u0214\u0003b1\u0000\u0213\u0212\u0001\u0000\u0000\u0000\u0213\u0214"
          + "\u0001\u0000\u0000\u0000\u0214\u0216\u0001\u0000\u0000\u0000\u0215\u0217"
          + "\u0003D\"\u0000\u0216\u0215\u0001\u0000\u0000\u0000\u0216\u0217\u0001"
          + "\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000\u0000\u0218\u021a\u0003"
          + "d2\u0000\u0219\u0218\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000"
          + "\u0000\u021ao\u0001\u0000\u0000\u0000\u021b\u021c\u0005\u0016\u0000\u0000"
          + "\u021c\u021d\u0005\u001b\u0000\u0000\u021d\u021f\u0003\u0090H\u0000\u021e"
          + "\u0220\u0003b1\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u021f\u0220\u0001"
          + "\u0000\u0000\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221\u0223\u0003"
          + "D\"\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000"
          + "\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0225\u0003d2\u0000"
          + "\u0225\u022f\u0001\u0000\u0000\u0000\u0226\u0227\u0005\u0016\u0000\u0000"
          + "\u0227\u0228\u0005\u001b\u0000\u0000\u0228\u022a\u0003\u0090H\u0000\u0229"
          + "\u022b\u0003b1\u0000\u022a\u0229\u0001\u0000\u0000\u0000\u022a\u022b\u0001"
          + "\u0000\u0000\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022d\u0003"
          + "D\"\u0000\u022d\u022f\u0001\u0000\u0000\u0000\u022e\u021b\u0001\u0000"
          + "\u0000\u0000\u022e\u0226\u0001\u0000\u0000\u0000\u022fq\u0001\u0000\u0000"
          + "\u0000\u0230\u0232\u0003V+\u0000\u0231\u0230\u0001\u0000\u0000\u0000\u0231"
          + "\u0232\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233"
          + "\u0234\u0005\u001c\u0000\u0000\u0234\u0236\u0003\u0090H\u0000\u0235\u0237"
          + "\u0003D\"\u0000\u0236\u0235\u0001\u0000\u0000\u0000\u0236\u0237\u0001"
          + "\u0000\u0000\u0000\u0237\u0239\u0001\u0000\u0000\u0000\u0238\u023a\u0003"
          + "t:\u0000\u0239\u0238\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000"
          + "\u0000\u023as\u0001\u0000\u0000\u0000\u023b\u023d\u0005\u0012\u0000\u0000"
          + "\u023c\u023e\u0005\u001d\u0000\u0000\u023d\u023c\u0001\u0000\u0000\u0000"
          + "\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000"
          + "\u023f\u0244\u0003@ \u0000\u0240\u0241\u0005\u001d\u0000\u0000\u0241\u0243"
          + "\u0003@ \u0000\u0242\u0240\u0001\u0000\u0000\u0000\u0243\u0246\u0001\u0000"
          + "\u0000\u0000\u0244\u0242\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000"
          + "\u0000\u0000\u0245u\u0001\u0000\u0000\u0000\u0246\u0244\u0001\u0000\u0000"
          + "\u0000\u0247\u0248\u0005\u0016\u0000\u0000\u0248\u0249\u0005\u001c\u0000"
          + "\u0000\u0249\u024b\u0003\u0090H\u0000\u024a\u024c\u0003D\"\u0000\u024b"
          + "\u024a\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c"
          + "\u024d\u0001\u0000\u0000\u0000\u024d\u024e\u0003t:\u0000\u024e\u0255\u0001"
          + "\u0000\u0000\u0000\u024f\u0250\u0005\u0016\u0000\u0000\u0250\u0251\u0005"
          + "\u001c\u0000\u0000\u0251\u0252\u0003\u0090H\u0000\u0252\u0253\u0003D\""
          + "\u0000\u0253\u0255\u0001\u0000\u0000\u0000\u0254\u0247\u0001\u0000\u0000"
          + "\u0000\u0254\u024f\u0001\u0000\u0000\u0000\u0255w\u0001\u0000\u0000\u0000"
          + "\u0256\u0258\u0003V+\u0000\u0257\u0256\u0001\u0000\u0000\u0000\u0257\u0258"
          + "\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a"
          + "\u0005\u001e\u0000\u0000\u025a\u025c\u0003\u0090H\u0000\u025b\u025d\u0003"
          + "D\"\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000"
          + "\u0000\u0000\u025d\u025f\u0001\u0000\u0000\u0000\u025e\u0260\u0003z=\u0000"
          + "\u025f\u025e\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000\u0000\u0000"
          + "\u0260y\u0001\u0000\u0000\u0000\u0261\u0263\u0005\u0004\u0000\u0000\u0262"
          + "\u0264\u0003|>\u0000\u0263\u0262\u0001\u0000\u0000\u0000\u0264\u0265\u0001"
          + "\u0000\u0000\u0000\u0265\u0263\u0001\u0000\u0000\u0000\u0265\u0266\u0001"
          + "\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0005"
          + "\u0005\u0000\u0000\u0268{\u0001\u0000\u0000\u0000\u0269\u026b\u0003V+"
          + "\u0000\u026a\u0269\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000"
          + "\u0000\u026b\u026c\u0001\u0000\u0000\u0000\u026c\u026e\u0003.\u0017\u0000"
          + "\u026d\u026f\u0003D\"\u0000\u026e\u026d\u0001\u0000\u0000\u0000\u026e"
          + "\u026f\u0001\u0000\u0000\u0000\u026f}\u0001\u0000\u0000\u0000\u0270\u0271"
          + "\u0005\u0016\u0000\u0000\u0271\u0272\u0005\u001e\u0000\u0000\u0272\u0274"
          + "\u0003\u0090H\u0000\u0273\u0275\u0003D\"\u0000\u0274\u0273\u0001\u0000"
          + "\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000"
          + "\u0000\u0000\u0276\u0277\u0003z=\u0000\u0277\u027e\u0001\u0000\u0000\u0000"
          + "\u0278\u0279\u0005\u0016\u0000\u0000\u0279\u027a\u0005\u001e\u0000\u0000"
          + "\u027a\u027b\u0003\u0090H\u0000\u027b\u027c\u0003D\"\u0000\u027c\u027e"
          + "\u0001\u0000\u0000\u0000\u027d\u0270\u0001\u0000\u0000\u0000\u027d\u0278"
          + "\u0001\u0000\u0000\u0000\u027e\u007f\u0001\u0000\u0000\u0000\u027f\u0281"
          + "\u0003V+\u0000\u0280\u027f\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000"
          + "\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0283\u0005\u001f"
          + "\u0000\u0000\u0283\u0285\u0003\u0090H\u0000\u0284\u0286\u0003D\"\u0000"
          + "\u0285\u0284\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000\u0000"
          + "\u0286\u0288\u0001\u0000\u0000\u0000\u0287\u0289\u0003\u0082A\u0000\u0288"
          + "\u0287\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289"
          + "\u0081\u0001\u0000\u0000\u0000\u028a\u028c\u0005\u0004\u0000\u0000\u028b"
          + "\u028d\u0003j5\u0000\u028c\u028b\u0001\u0000\u0000\u0000\u028d\u028e\u0001"
          + "\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028e\u028f\u0001"
          + "\u0000\u0000\u0000\u028f\u0290\u0001\u0000\u0000\u0000\u0290\u0291\u0005"
          + "\u0005\u0000\u0000\u0291\u0083\u0001\u0000\u0000\u0000\u0292\u0293\u0005"
          + "\u0016\u0000\u0000\u0293\u0294\u0005\u001f\u0000\u0000\u0294\u0296\u0003"
          + "\u0090H\u0000\u0295\u0297\u0003D\"\u0000\u0296\u0295\u0001\u0000\u0000"
          + "\u0000\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000"
          + "\u0000\u0298\u0299\u0003\u0082A\u0000\u0299\u02a0\u0001\u0000\u0000\u0000"
          + "\u029a\u029b\u0005\u0016\u0000\u0000\u029b\u029c\u0005\u001f\u0000\u0000"
          + "\u029c\u029d\u0003\u0090H\u0000\u029d\u029e\u0003D\"\u0000\u029e\u02a0"
          + "\u0001\u0000\u0000\u0000\u029f\u0292\u0001\u0000\u0000\u0000\u029f\u029a"
          + "\u0001\u0000\u0000\u0000\u02a0\u0085\u0001\u0000\u0000\u0000\u02a1\u02a3"
          + "\u0003V+\u0000\u02a2\u02a1\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000"
          + "\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a5\u0005 \u0000"
          + "\u0000\u02a5\u02a6\u0005\u0014\u0000\u0000\u02a6\u02a8\u0003\u0090H\u0000"
          + "\u02a7\u02a9\u0003h4\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9"
          + "\u0001\u0000\u0000\u0000\u02a9\u02ab\u0001\u0000\u0000\u0000\u02aa\u02ac"
          + "\u0005!\u0000\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001"
          + "\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000\u02ad\u02ae\u0005"
          + "\u000b\u0000\u0000\u02ae\u02af\u0003\u0088D\u0000\u02af\u0087\u0001\u0000"
          + "\u0000\u0000\u02b0\u02b5\u0003\u008aE\u0000\u02b1\u02b2\u0005\u001d\u0000"
          + "\u0000\u02b2\u02b4\u0003\u008aE\u0000\u02b3\u02b1\u0001\u0000\u0000\u0000"
          + "\u02b4\u02b7\u0001\u0000\u0000\u0000\u02b5\u02b3\u0001\u0000\u0000\u0000"
          + "\u02b5\u02b6\u0001\u0000\u0000\u0000\u02b6\u0089\u0001\u0000\u0000\u0000"
          + "\u02b7\u02b5\u0001\u0000\u0000\u0000\u02b8\u02bb\u0003\u008cF\u0000\u02b9"
          + "\u02bb\u0003\u008eG\u0000\u02ba\u02b8\u0001\u0000\u0000\u0000\u02ba\u02b9"
          + "\u0001\u0000\u0000\u0000\u02bb\u008b\u0001\u0000\u0000\u0000\u02bc\u02bd"
          + "\u0007\u0003\u0000\u0000\u02bd\u008d\u0001\u0000\u0000\u0000\u02be\u02bf"
          + "\u0007\u0004\u0000\u0000\u02bf\u008f\u0001\u0000\u0000\u0000\u02c0\u02c1"
          + "\u00055\u0000\u0000\u02c1\u0091\u0001\u0000\u0000\u0000_\u0095\u009c\u00a1"
          + "\u00a5\u00a9\u00ac\u00af\u00b4\u00bc\u00c3\u00c6\u00ca\u00cd\u00d0\u00d6"
          + "\u00e4\u00ea\u00f5\u00f8\u0105\u0119\u011d\u0123\u0133\u013b\u0142\u0146"
          + "\u0148\u0153\u0158\u015d\u0162\u0167\u016b\u016f\u0175\u0180\u0186\u018d"
          + "\u0197\u019f\u01a2\u01a7\u01af\u01b4\u01b7\u01ba\u01bf\u01c8\u01cf\u01d4"
          + "\u01d8\u01dd\u01e3\u01e8\u01ee\u01f1\u01f7\u01fa\u0202\u020b\u020e\u0213"
          + "\u0216\u0219\u021f\u0222\u022a\u022e\u0231\u0236\u0239\u023d\u0244\u024b"
          + "\u0254\u0257\u025c\u025f\u0265\u026a\u026e\u0274\u027d\u0280\u0285\u0288"
          + "\u028e\u0296\u029f\u02a2\u02a8\u02ab\u02b5\u02ba";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
