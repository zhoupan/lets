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
public class WebIDLParser extends Parser {
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
      T__52 = 53,
      T__53 = 54,
      T__54 = 55,
      T__55 = 56,
      T__56 = 57,
      T__57 = 58,
      T__58 = 59,
      T__59 = 60,
      T__60 = 61,
      T__61 = 62,
      T__62 = 63,
      T__63 = 64,
      T__64 = 65,
      T__65 = 66,
      T__66 = 67,
      T__67 = 68,
      T__68 = 69,
      T__69 = 70,
      T__70 = 71,
      T__71 = 72,
      T__72 = 73,
      T__73 = 74,
      T__74 = 75,
      T__75 = 76,
      T__76 = 77,
      T__77 = 78,
      T__78 = 79,
      T__79 = 80,
      T__80 = 81,
      INTEGER_WEBIDL = 82,
      DECIMAL_WEBIDL = 83,
      IDENTIFIER_WEBIDL = 84,
      STRING_WEBIDL = 85,
      WHITESPACE_WEBIDL = 86,
      COMMENT_WEBIDL = 87,
      OTHER_WEBIDL = 88;
  public static final int RULE_webIDL = 0,
      RULE_definitions = 1,
      RULE_definition = 2,
      RULE_argumentNameKeyword = 3,
      RULE_callbackOrInterfaceOrMixin = 4,
      RULE_interfaceOrMixin = 5,
      RULE_interfaceRest = 6,
      RULE_partial = 7,
      RULE_partialDefinition = 8,
      RULE_partialInterfaceOrPartialMixin = 9,
      RULE_partialInterfaceRest = 10,
      RULE_interfaceMembers = 11,
      RULE_interfaceMember = 12,
      RULE_partialInterfaceMembers = 13,
      RULE_partialInterfaceMember = 14,
      RULE_inheritance = 15,
      RULE_mixinRest = 16,
      RULE_mixinMembers = 17,
      RULE_mixinMember = 18,
      RULE_includesStatement = 19,
      RULE_callbackRestOrInterface = 20,
      RULE_callbackInterfaceMembers = 21,
      RULE_callbackInterfaceMember = 22,
      RULE_const_ = 23,
      RULE_constValue = 24,
      RULE_booleanLiteral = 25,
      RULE_floatLiteral = 26,
      RULE_constType = 27,
      RULE_readonlyMember = 28,
      RULE_readonlyMemberRest = 29,
      RULE_readWriteAttribute = 30,
      RULE_inheritAttribute = 31,
      RULE_attributeRest = 32,
      RULE_attributeName = 33,
      RULE_attributeNameKeyword = 34,
      RULE_optionalReadOnly = 35,
      RULE_defaultValue = 36,
      RULE_operation = 37,
      RULE_regularOperation = 38,
      RULE_specialOperation = 39,
      RULE_special = 40,
      RULE_operationRest = 41,
      RULE_optionalOperationName = 42,
      RULE_operationName = 43,
      RULE_operationNameKeyword = 44,
      RULE_argumentList = 45,
      RULE_arguments = 46,
      RULE_argument = 47,
      RULE_argumentRest = 48,
      RULE_argumentName = 49,
      RULE_ellipsis = 50,
      RULE_constructor = 51,
      RULE_stringifier = 52,
      RULE_stringifierRest = 53,
      RULE_staticMember = 54,
      RULE_staticMemberRest = 55,
      RULE_iterable = 56,
      RULE_optionalType = 57,
      RULE_asyncIterable = 58,
      RULE_optionalArgumentList = 59,
      RULE_readWriteMaplike = 60,
      RULE_maplikeRest = 61,
      RULE_readWriteSetlike = 62,
      RULE_setlikeRest = 63,
      RULE_namespace_ = 64,
      RULE_namespaceMembers = 65,
      RULE_namespaceMember = 66,
      RULE_dictionary = 67,
      RULE_dictionaryMembers = 68,
      RULE_dictionaryMember = 69,
      RULE_dictionaryMemberRest = 70,
      RULE_partialDictionary = 71,
      RULE_default_ = 72,
      RULE_enum_ = 73,
      RULE_enumValueList = 74,
      RULE_enumValueListComma = 75,
      RULE_enumValueListString = 76,
      RULE_callbackRest = 77,
      RULE_typedef_ = 78,
      RULE_type_ = 79,
      RULE_typeWithExtendedAttributes = 80,
      RULE_singleType = 81,
      RULE_unionType = 82,
      RULE_unionMemberType = 83,
      RULE_unionMemberTypes = 84,
      RULE_distinguishableType = 85,
      RULE_primitiveType = 86,
      RULE_unrestrictedFloatType = 87,
      RULE_floatType = 88,
      RULE_unsignedIntegerType = 89,
      RULE_integerType = 90,
      RULE_optionalLong = 91,
      RULE_stringType = 92,
      RULE_promiseType = 93,
      RULE_recordType = 94,
      RULE_null_ = 95,
      RULE_bufferRelatedType = 96,
      RULE_extendedAttributeList = 97,
      RULE_extendedAttributes = 98,
      RULE_extendedAttribute = 99,
      RULE_other = 100,
      RULE_otherOrComma = 101,
      RULE_identifierList = 102,
      RULE_identifiers = 103,
      RULE_extendedAttributeNoArgs = 104,
      RULE_extendedAttributeArgList = 105,
      RULE_extendedAttributeIdent = 106,
      RULE_extendedAttributeIdentList = 107,
      RULE_extendedAttributeNamedArgList = 108,
      RULE_extendedAttributeString = 109,
      RULE_extendedAttributeStringList = 110,
      RULE_stringList = 111,
      RULE_strings = 112;

  private static String[] makeRuleNames() {
    return new String[] {
      "webIDL",
      "definitions",
      "definition",
      "argumentNameKeyword",
      "callbackOrInterfaceOrMixin",
      "interfaceOrMixin",
      "interfaceRest",
      "partial",
      "partialDefinition",
      "partialInterfaceOrPartialMixin",
      "partialInterfaceRest",
      "interfaceMembers",
      "interfaceMember",
      "partialInterfaceMembers",
      "partialInterfaceMember",
      "inheritance",
      "mixinRest",
      "mixinMembers",
      "mixinMember",
      "includesStatement",
      "callbackRestOrInterface",
      "callbackInterfaceMembers",
      "callbackInterfaceMember",
      "const_",
      "constValue",
      "booleanLiteral",
      "floatLiteral",
      "constType",
      "readonlyMember",
      "readonlyMemberRest",
      "readWriteAttribute",
      "inheritAttribute",
      "attributeRest",
      "attributeName",
      "attributeNameKeyword",
      "optionalReadOnly",
      "defaultValue",
      "operation",
      "regularOperation",
      "specialOperation",
      "special",
      "operationRest",
      "optionalOperationName",
      "operationName",
      "operationNameKeyword",
      "argumentList",
      "arguments",
      "argument",
      "argumentRest",
      "argumentName",
      "ellipsis",
      "constructor",
      "stringifier",
      "stringifierRest",
      "staticMember",
      "staticMemberRest",
      "iterable",
      "optionalType",
      "asyncIterable",
      "optionalArgumentList",
      "readWriteMaplike",
      "maplikeRest",
      "readWriteSetlike",
      "setlikeRest",
      "namespace_",
      "namespaceMembers",
      "namespaceMember",
      "dictionary",
      "dictionaryMembers",
      "dictionaryMember",
      "dictionaryMemberRest",
      "partialDictionary",
      "default_",
      "enum_",
      "enumValueList",
      "enumValueListComma",
      "enumValueListString",
      "callbackRest",
      "typedef_",
      "type_",
      "typeWithExtendedAttributes",
      "singleType",
      "unionType",
      "unionMemberType",
      "unionMemberTypes",
      "distinguishableType",
      "primitiveType",
      "unrestrictedFloatType",
      "floatType",
      "unsignedIntegerType",
      "integerType",
      "optionalLong",
      "stringType",
      "promiseType",
      "recordType",
      "null_",
      "bufferRelatedType",
      "extendedAttributeList",
      "extendedAttributes",
      "extendedAttribute",
      "other",
      "otherOrComma",
      "identifierList",
      "identifiers",
      "extendedAttributeNoArgs",
      "extendedAttributeArgList",
      "extendedAttributeIdent",
      "extendedAttributeIdentList",
      "extendedAttributeNamedArgList",
      "extendedAttributeString",
      "extendedAttributeStringList",
      "stringList",
      "strings"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'async'",
      "'attribute'",
      "'callback'",
      "'const'",
      "'constructor'",
      "'deleter'",
      "'dictionary'",
      "'enum'",
      "'getter'",
      "'includes'",
      "'inherit'",
      "'interface'",
      "'iterable'",
      "'maplike'",
      "'mixin'",
      "'namespace'",
      "'partial'",
      "'readonly'",
      "'required'",
      "'setlike'",
      "'setter'",
      "'static'",
      "'stringifier'",
      "'typedef'",
      "'unrestricted'",
      "'{'",
      "'}'",
      "';'",
      "':'",
      "'='",
      "'true'",
      "'false'",
      "'-Infinity'",
      "'Infinity'",
      "'NaN'",
      "'['",
      "']'",
      "'null'",
      "'('",
      "')'",
      "','",
      "'optional'",
      "'...'",
      "'<'",
      "'>'",
      "'any'",
      "'or'",
      "'sequence'",
      "'object'",
      "'symbol'",
      "'FrozenArray'",
      "'ObservableArray'",
      "'undefined'",
      "'boolean'",
      "'byte'",
      "'octet'",
      "'bigint'",
      "'float'",
      "'double'",
      "'unsigned'",
      "'short'",
      "'long'",
      "'ByteString'",
      "'DOMString'",
      "'USVString'",
      "'Promise'",
      "'record'",
      "'?'",
      "'ArrayBuffer'",
      "'DataView'",
      "'Int8Array'",
      "'Int16Array'",
      "'Int32Array'",
      "'Uint8Array'",
      "'Uint16Array'",
      "'Uint32Array'",
      "'Uint8ClampedArray'",
      "'Float32Array'",
      "'Float64Array'",
      "'-'",
      "'.'"
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
      "INTEGER_WEBIDL",
      "DECIMAL_WEBIDL",
      "IDENTIFIER_WEBIDL",
      "STRING_WEBIDL",
      "WHITESPACE_WEBIDL",
      "COMMENT_WEBIDL",
      "OTHER_WEBIDL"
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
    return "WebIDL.g4";
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

  public WebIDLParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class WebIDLContext extends ParserRuleContext {
    public DefinitionsContext definitions() {
      return getRuleContext(DefinitionsContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(WebIDLParser.EOF, 0);
    }

    public WebIDLContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_webIDL;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterWebIDL(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitWebIDL(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitWebIDL(this);
      else return visitor.visitChildren(this);
    }
  }

  public final WebIDLContext webIDL() throws RecognitionException {
    WebIDLContext _localctx = new WebIDLContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_webIDL);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(226);
        definitions();
        setState(227);
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
  public static class DefinitionsContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public DefinitionContext definition() {
      return getRuleContext(DefinitionContext.class, 0);
    }

    public DefinitionsContext definitions() {
      return getRuleContext(DefinitionsContext.class, 0);
    }

    public DefinitionsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_definitions;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterDefinitions(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitDefinitions(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDefinitions(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefinitionsContext definitions() throws RecognitionException {
    DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_definitions);
    try {
      setState(234);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__2:
        case T__6:
        case T__7:
        case T__11:
        case T__15:
        case T__16:
        case T__23:
        case T__35:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(229);
            extendedAttributeList();
            setState(230);
            definition();
            setState(231);
            definitions();
          }
          break;
        case EOF:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class DefinitionContext extends ParserRuleContext {
    public CallbackOrInterfaceOrMixinContext callbackOrInterfaceOrMixin() {
      return getRuleContext(CallbackOrInterfaceOrMixinContext.class, 0);
    }

    public Namespace_Context namespace_() {
      return getRuleContext(Namespace_Context.class, 0);
    }

    public PartialContext partial() {
      return getRuleContext(PartialContext.class, 0);
    }

    public DictionaryContext dictionary() {
      return getRuleContext(DictionaryContext.class, 0);
    }

    public Enum_Context enum_() {
      return getRuleContext(Enum_Context.class, 0);
    }

    public Typedef_Context typedef_() {
      return getRuleContext(Typedef_Context.class, 0);
    }

    public IncludesStatementContext includesStatement() {
      return getRuleContext(IncludesStatementContext.class, 0);
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
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefinitionContext definition() throws RecognitionException {
    DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_definition);
    try {
      setState(243);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__2:
        case T__11:
          enterOuterAlt(_localctx, 1);
          {
            setState(236);
            callbackOrInterfaceOrMixin();
          }
          break;
        case T__15:
          enterOuterAlt(_localctx, 2);
          {
            setState(237);
            namespace_();
          }
          break;
        case T__16:
          enterOuterAlt(_localctx, 3);
          {
            setState(238);
            partial();
          }
          break;
        case T__6:
          enterOuterAlt(_localctx, 4);
          {
            setState(239);
            dictionary();
          }
          break;
        case T__7:
          enterOuterAlt(_localctx, 5);
          {
            setState(240);
            enum_();
          }
          break;
        case T__23:
          enterOuterAlt(_localctx, 6);
          {
            setState(241);
            typedef_();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 7);
          {
            setState(242);
            includesStatement();
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
  public static class ArgumentNameKeywordContext extends ParserRuleContext {
    public ArgumentNameKeywordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentNameKeyword;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterArgumentNameKeyword(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitArgumentNameKeyword(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArgumentNameKeyword(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentNameKeywordContext argumentNameKeyword() throws RecognitionException {
    ArgumentNameKeywordContext _localctx = new ArgumentNameKeywordContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_argumentNameKeyword);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(245);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 67108862L) != 0))) {
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
  public static class CallbackOrInterfaceOrMixinContext extends ParserRuleContext {
    public CallbackRestOrInterfaceContext callbackRestOrInterface() {
      return getRuleContext(CallbackRestOrInterfaceContext.class, 0);
    }

    public InterfaceOrMixinContext interfaceOrMixin() {
      return getRuleContext(InterfaceOrMixinContext.class, 0);
    }

    public CallbackOrInterfaceOrMixinContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callbackOrInterfaceOrMixin;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterCallbackOrInterfaceOrMixin(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitCallbackOrInterfaceOrMixin(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitCallbackOrInterfaceOrMixin(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallbackOrInterfaceOrMixinContext callbackOrInterfaceOrMixin()
      throws RecognitionException {
    CallbackOrInterfaceOrMixinContext _localctx =
        new CallbackOrInterfaceOrMixinContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_callbackOrInterfaceOrMixin);
    try {
      setState(251);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__2:
          enterOuterAlt(_localctx, 1);
          {
            setState(247);
            match(T__2);
            setState(248);
            callbackRestOrInterface();
          }
          break;
        case T__11:
          enterOuterAlt(_localctx, 2);
          {
            setState(249);
            match(T__11);
            setState(250);
            interfaceOrMixin();
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
  public static class InterfaceOrMixinContext extends ParserRuleContext {
    public InterfaceRestContext interfaceRest() {
      return getRuleContext(InterfaceRestContext.class, 0);
    }

    public MixinRestContext mixinRest() {
      return getRuleContext(MixinRestContext.class, 0);
    }

    public InterfaceOrMixinContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceOrMixin;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterInterfaceOrMixin(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitInterfaceOrMixin(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInterfaceOrMixin(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceOrMixinContext interfaceOrMixin() throws RecognitionException {
    InterfaceOrMixinContext _localctx = new InterfaceOrMixinContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_interfaceOrMixin);
    try {
      setState(255);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(253);
            interfaceRest();
          }
          break;
        case T__14:
          enterOuterAlt(_localctx, 2);
          {
            setState(254);
            mixinRest();
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
  public static class InterfaceRestContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public InheritanceContext inheritance() {
      return getRuleContext(InheritanceContext.class, 0);
    }

    public InterfaceMembersContext interfaceMembers() {
      return getRuleContext(InterfaceMembersContext.class, 0);
    }

    public InterfaceRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterInterfaceRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitInterfaceRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInterfaceRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceRestContext interfaceRest() throws RecognitionException {
    InterfaceRestContext _localctx = new InterfaceRestContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_interfaceRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(257);
        match(IDENTIFIER_WEBIDL);
        setState(258);
        inheritance();
        setState(259);
        match(T__25);
        setState(260);
        interfaceMembers();
        setState(261);
        match(T__26);
        setState(262);
        match(T__27);
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
  public static class PartialContext extends ParserRuleContext {
    public PartialDefinitionContext partialDefinition() {
      return getRuleContext(PartialDefinitionContext.class, 0);
    }

    public PartialContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partial;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterPartial(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitPartial(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartial(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialContext partial() throws RecognitionException {
    PartialContext _localctx = new PartialContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_partial);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(264);
        match(T__16);
        setState(265);
        partialDefinition();
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
  public static class PartialDefinitionContext extends ParserRuleContext {
    public PartialInterfaceOrPartialMixinContext partialInterfaceOrPartialMixin() {
      return getRuleContext(PartialInterfaceOrPartialMixinContext.class, 0);
    }

    public PartialDictionaryContext partialDictionary() {
      return getRuleContext(PartialDictionaryContext.class, 0);
    }

    public Namespace_Context namespace_() {
      return getRuleContext(Namespace_Context.class, 0);
    }

    public PartialDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialDefinitionContext partialDefinition() throws RecognitionException {
    PartialDefinitionContext _localctx = new PartialDefinitionContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_partialDefinition);
    try {
      setState(271);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__11:
          enterOuterAlt(_localctx, 1);
          {
            setState(267);
            match(T__11);
            setState(268);
            partialInterfaceOrPartialMixin();
          }
          break;
        case T__6:
          enterOuterAlt(_localctx, 2);
          {
            setState(269);
            partialDictionary();
          }
          break;
        case T__15:
          enterOuterAlt(_localctx, 3);
          {
            setState(270);
            namespace_();
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
  public static class PartialInterfaceOrPartialMixinContext extends ParserRuleContext {
    public PartialInterfaceRestContext partialInterfaceRest() {
      return getRuleContext(PartialInterfaceRestContext.class, 0);
    }

    public MixinRestContext mixinRest() {
      return getRuleContext(MixinRestContext.class, 0);
    }

    public PartialInterfaceOrPartialMixinContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialInterfaceOrPartialMixin;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialInterfaceOrPartialMixin(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialInterfaceOrPartialMixin(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialInterfaceOrPartialMixin(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialInterfaceOrPartialMixinContext partialInterfaceOrPartialMixin()
      throws RecognitionException {
    PartialInterfaceOrPartialMixinContext _localctx =
        new PartialInterfaceOrPartialMixinContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_partialInterfaceOrPartialMixin);
    try {
      setState(275);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(273);
            partialInterfaceRest();
          }
          break;
        case T__14:
          enterOuterAlt(_localctx, 2);
          {
            setState(274);
            mixinRest();
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
  public static class PartialInterfaceRestContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public PartialInterfaceMembersContext partialInterfaceMembers() {
      return getRuleContext(PartialInterfaceMembersContext.class, 0);
    }

    public PartialInterfaceRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialInterfaceRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialInterfaceRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialInterfaceRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialInterfaceRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialInterfaceRestContext partialInterfaceRest() throws RecognitionException {
    PartialInterfaceRestContext _localctx = new PartialInterfaceRestContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_partialInterfaceRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(277);
        match(IDENTIFIER_WEBIDL);
        setState(278);
        match(T__25);
        setState(279);
        partialInterfaceMembers();
        setState(280);
        match(T__26);
        setState(281);
        match(T__27);
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
  public static class InterfaceMembersContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public InterfaceMemberContext interfaceMember() {
      return getRuleContext(InterfaceMemberContext.class, 0);
    }

    public InterfaceMembersContext interfaceMembers() {
      return getRuleContext(InterfaceMembersContext.class, 0);
    }

    public InterfaceMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterInterfaceMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitInterfaceMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInterfaceMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceMembersContext interfaceMembers() throws RecognitionException {
    InterfaceMembersContext _localctx = new InterfaceMembersContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_interfaceMembers);
    try {
      setState(288);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__3:
        case T__4:
        case T__5:
        case T__8:
        case T__10:
        case T__12:
        case T__13:
        case T__17:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(283);
            extendedAttributeList();
            setState(284);
            interfaceMember();
            setState(285);
            interfaceMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class InterfaceMemberContext extends ParserRuleContext {
    public PartialInterfaceMemberContext partialInterfaceMember() {
      return getRuleContext(PartialInterfaceMemberContext.class, 0);
    }

    public ConstructorContext constructor() {
      return getRuleContext(ConstructorContext.class, 0);
    }

    public InterfaceMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_interfaceMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterInterfaceMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitInterfaceMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInterfaceMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InterfaceMemberContext interfaceMember() throws RecognitionException {
    InterfaceMemberContext _localctx = new InterfaceMemberContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_interfaceMember);
    try {
      setState(292);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__3:
        case T__5:
        case T__8:
        case T__10:
        case T__12:
        case T__13:
        case T__17:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(290);
            partialInterfaceMember();
          }
          break;
        case T__4:
          enterOuterAlt(_localctx, 2);
          {
            setState(291);
            constructor();
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
  public static class PartialInterfaceMembersContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public PartialInterfaceMemberContext partialInterfaceMember() {
      return getRuleContext(PartialInterfaceMemberContext.class, 0);
    }

    public PartialInterfaceMembersContext partialInterfaceMembers() {
      return getRuleContext(PartialInterfaceMembersContext.class, 0);
    }

    public PartialInterfaceMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialInterfaceMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialInterfaceMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialInterfaceMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialInterfaceMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialInterfaceMembersContext partialInterfaceMembers()
      throws RecognitionException {
    PartialInterfaceMembersContext _localctx = new PartialInterfaceMembersContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_partialInterfaceMembers);
    try {
      setState(299);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__3:
        case T__5:
        case T__8:
        case T__10:
        case T__12:
        case T__13:
        case T__17:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(294);
            extendedAttributeList();
            setState(295);
            partialInterfaceMember();
            setState(296);
            partialInterfaceMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class PartialInterfaceMemberContext extends ParserRuleContext {
    public Const_Context const_() {
      return getRuleContext(Const_Context.class, 0);
    }

    public OperationContext operation() {
      return getRuleContext(OperationContext.class, 0);
    }

    public StringifierContext stringifier() {
      return getRuleContext(StringifierContext.class, 0);
    }

    public StaticMemberContext staticMember() {
      return getRuleContext(StaticMemberContext.class, 0);
    }

    public IterableContext iterable() {
      return getRuleContext(IterableContext.class, 0);
    }

    public AsyncIterableContext asyncIterable() {
      return getRuleContext(AsyncIterableContext.class, 0);
    }

    public ReadonlyMemberContext readonlyMember() {
      return getRuleContext(ReadonlyMemberContext.class, 0);
    }

    public ReadWriteAttributeContext readWriteAttribute() {
      return getRuleContext(ReadWriteAttributeContext.class, 0);
    }

    public ReadWriteMaplikeContext readWriteMaplike() {
      return getRuleContext(ReadWriteMaplikeContext.class, 0);
    }

    public ReadWriteSetlikeContext readWriteSetlike() {
      return getRuleContext(ReadWriteSetlikeContext.class, 0);
    }

    public InheritAttributeContext inheritAttribute() {
      return getRuleContext(InheritAttributeContext.class, 0);
    }

    public PartialInterfaceMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialInterfaceMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialInterfaceMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialInterfaceMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialInterfaceMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialInterfaceMemberContext partialInterfaceMember() throws RecognitionException {
    PartialInterfaceMemberContext _localctx = new PartialInterfaceMemberContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_partialInterfaceMember);
    try {
      setState(312);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__3:
          enterOuterAlt(_localctx, 1);
          {
            setState(301);
            const_();
          }
          break;
        case T__5:
        case T__8:
        case T__20:
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(302);
            operation();
          }
          break;
        case T__22:
          enterOuterAlt(_localctx, 3);
          {
            setState(303);
            stringifier();
          }
          break;
        case T__21:
          enterOuterAlt(_localctx, 4);
          {
            setState(304);
            staticMember();
          }
          break;
        case T__12:
          enterOuterAlt(_localctx, 5);
          {
            setState(305);
            iterable();
          }
          break;
        case T__0:
          enterOuterAlt(_localctx, 6);
          {
            setState(306);
            asyncIterable();
          }
          break;
        case T__17:
          enterOuterAlt(_localctx, 7);
          {
            setState(307);
            readonlyMember();
          }
          break;
        case T__1:
          enterOuterAlt(_localctx, 8);
          {
            setState(308);
            readWriteAttribute();
          }
          break;
        case T__13:
          enterOuterAlt(_localctx, 9);
          {
            setState(309);
            readWriteMaplike();
          }
          break;
        case T__19:
          enterOuterAlt(_localctx, 10);
          {
            setState(310);
            readWriteSetlike();
          }
          break;
        case T__10:
          enterOuterAlt(_localctx, 11);
          {
            setState(311);
            inheritAttribute();
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
  public static class InheritanceContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public InheritanceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inheritance;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterInheritance(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitInheritance(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInheritance(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InheritanceContext inheritance() throws RecognitionException {
    InheritanceContext _localctx = new InheritanceContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_inheritance);
    try {
      setState(317);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__28:
          enterOuterAlt(_localctx, 1);
          {
            setState(314);
            match(T__28);
            setState(315);
            match(IDENTIFIER_WEBIDL);
          }
          break;
        case T__25:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class MixinRestContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public MixinMembersContext mixinMembers() {
      return getRuleContext(MixinMembersContext.class, 0);
    }

    public MixinRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_mixinRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterMixinRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitMixinRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitMixinRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MixinRestContext mixinRest() throws RecognitionException {
    MixinRestContext _localctx = new MixinRestContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_mixinRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(319);
        match(T__14);
        setState(320);
        match(IDENTIFIER_WEBIDL);
        setState(321);
        match(T__25);
        setState(322);
        mixinMembers();
        setState(323);
        match(T__26);
        setState(324);
        match(T__27);
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
  public static class MixinMembersContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public MixinMemberContext mixinMember() {
      return getRuleContext(MixinMemberContext.class, 0);
    }

    public MixinMembersContext mixinMembers() {
      return getRuleContext(MixinMembersContext.class, 0);
    }

    public MixinMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_mixinMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterMixinMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitMixinMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitMixinMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MixinMembersContext mixinMembers() throws RecognitionException {
    MixinMembersContext _localctx = new MixinMembersContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_mixinMembers);
    try {
      setState(331);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__1:
        case T__3:
        case T__17:
        case T__22:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(326);
            extendedAttributeList();
            setState(327);
            mixinMember();
            setState(328);
            mixinMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class MixinMemberContext extends ParserRuleContext {
    public Const_Context const_() {
      return getRuleContext(Const_Context.class, 0);
    }

    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public StringifierContext stringifier() {
      return getRuleContext(StringifierContext.class, 0);
    }

    public OptionalReadOnlyContext optionalReadOnly() {
      return getRuleContext(OptionalReadOnlyContext.class, 0);
    }

    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public MixinMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_mixinMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterMixinMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitMixinMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitMixinMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MixinMemberContext mixinMember() throws RecognitionException {
    MixinMemberContext _localctx = new MixinMemberContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_mixinMember);
    try {
      setState(339);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__3:
          enterOuterAlt(_localctx, 1);
          {
            setState(333);
            const_();
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(334);
            regularOperation();
          }
          break;
        case T__22:
          enterOuterAlt(_localctx, 3);
          {
            setState(335);
            stringifier();
          }
          break;
        case T__1:
        case T__17:
          enterOuterAlt(_localctx, 4);
          {
            setState(336);
            optionalReadOnly();
            setState(337);
            attributeRest();
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
  public static class IncludesStatementContext extends ParserRuleContext {
    public List<TerminalNode> IDENTIFIER_WEBIDL() {
      return getTokens(WebIDLParser.IDENTIFIER_WEBIDL);
    }

    public TerminalNode IDENTIFIER_WEBIDL(int i) {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, i);
    }

    public IncludesStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_includesStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterIncludesStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitIncludesStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitIncludesStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IncludesStatementContext includesStatement() throws RecognitionException {
    IncludesStatementContext _localctx = new IncludesStatementContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_includesStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(341);
        match(IDENTIFIER_WEBIDL);
        setState(342);
        match(T__9);
        setState(343);
        match(IDENTIFIER_WEBIDL);
        setState(344);
        match(T__27);
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
  public static class CallbackRestOrInterfaceContext extends ParserRuleContext {
    public CallbackRestContext callbackRest() {
      return getRuleContext(CallbackRestContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public CallbackInterfaceMembersContext callbackInterfaceMembers() {
      return getRuleContext(CallbackInterfaceMembersContext.class, 0);
    }

    public CallbackRestOrInterfaceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callbackRestOrInterface;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterCallbackRestOrInterface(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitCallbackRestOrInterface(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitCallbackRestOrInterface(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallbackRestOrInterfaceContext callbackRestOrInterface()
      throws RecognitionException {
    CallbackRestOrInterfaceContext _localctx = new CallbackRestOrInterfaceContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_callbackRestOrInterface);
    try {
      setState(354);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(346);
            callbackRest();
          }
          break;
        case T__11:
          enterOuterAlt(_localctx, 2);
          {
            setState(347);
            match(T__11);
            setState(348);
            match(IDENTIFIER_WEBIDL);
            setState(349);
            match(T__25);
            setState(350);
            callbackInterfaceMembers();
            setState(351);
            match(T__26);
            setState(352);
            match(T__27);
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
  public static class CallbackInterfaceMembersContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public CallbackInterfaceMemberContext callbackInterfaceMember() {
      return getRuleContext(CallbackInterfaceMemberContext.class, 0);
    }

    public CallbackInterfaceMembersContext callbackInterfaceMembers() {
      return getRuleContext(CallbackInterfaceMembersContext.class, 0);
    }

    public CallbackInterfaceMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callbackInterfaceMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterCallbackInterfaceMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitCallbackInterfaceMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitCallbackInterfaceMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallbackInterfaceMembersContext callbackInterfaceMembers()
      throws RecognitionException {
    CallbackInterfaceMembersContext _localctx =
        new CallbackInterfaceMembersContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_callbackInterfaceMembers);
    try {
      setState(361);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__3:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(356);
            extendedAttributeList();
            setState(357);
            callbackInterfaceMember();
            setState(358);
            callbackInterfaceMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class CallbackInterfaceMemberContext extends ParserRuleContext {
    public Const_Context const_() {
      return getRuleContext(Const_Context.class, 0);
    }

    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public CallbackInterfaceMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callbackInterfaceMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterCallbackInterfaceMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitCallbackInterfaceMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitCallbackInterfaceMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallbackInterfaceMemberContext callbackInterfaceMember()
      throws RecognitionException {
    CallbackInterfaceMemberContext _localctx = new CallbackInterfaceMemberContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_callbackInterfaceMember);
    try {
      setState(365);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__3:
          enterOuterAlt(_localctx, 1);
          {
            setState(363);
            const_();
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(364);
            regularOperation();
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
  public static class Const_Context extends ParserRuleContext {
    public ConstTypeContext constType() {
      return getRuleContext(ConstTypeContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public ConstValueContext constValue() {
      return getRuleContext(ConstValueContext.class, 0);
    }

    public Const_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_const_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterConst_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitConst_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitConst_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Const_Context const_() throws RecognitionException {
    Const_Context _localctx = new Const_Context(_ctx, getState());
    enterRule(_localctx, 46, RULE_const_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(367);
        match(T__3);
        setState(368);
        constType();
        setState(369);
        match(IDENTIFIER_WEBIDL);
        setState(370);
        match(T__29);
        setState(371);
        constValue();
        setState(372);
        match(T__27);
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
  public static class ConstValueContext extends ParserRuleContext {
    public BooleanLiteralContext booleanLiteral() {
      return getRuleContext(BooleanLiteralContext.class, 0);
    }

    public FloatLiteralContext floatLiteral() {
      return getRuleContext(FloatLiteralContext.class, 0);
    }

    public TerminalNode INTEGER_WEBIDL() {
      return getToken(WebIDLParser.INTEGER_WEBIDL, 0);
    }

    public ConstValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_constValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterConstValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitConstValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitConstValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ConstValueContext constValue() throws RecognitionException {
    ConstValueContext _localctx = new ConstValueContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_constValue);
    try {
      setState(377);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__30:
        case T__31:
          enterOuterAlt(_localctx, 1);
          {
            setState(374);
            booleanLiteral();
          }
          break;
        case T__32:
        case T__33:
        case T__34:
        case DECIMAL_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(375);
            floatLiteral();
          }
          break;
        case INTEGER_WEBIDL:
          enterOuterAlt(_localctx, 3);
          {
            setState(376);
            match(INTEGER_WEBIDL);
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
  public static class BooleanLiteralContext extends ParserRuleContext {
    public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_booleanLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterBooleanLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitBooleanLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitBooleanLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
    BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_booleanLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(379);
        _la = _input.LA(1);
        if (!(_la == T__30 || _la == T__31)) {
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
  public static class FloatLiteralContext extends ParserRuleContext {
    public TerminalNode DECIMAL_WEBIDL() {
      return getToken(WebIDLParser.DECIMAL_WEBIDL, 0);
    }

    public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_floatLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterFloatLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitFloatLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitFloatLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FloatLiteralContext floatLiteral() throws RecognitionException {
    FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_floatLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(381);
        _la = _input.LA(1);
        if (!(((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & 1125899906842631L) != 0))) {
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
  public static class ConstTypeContext extends ParserRuleContext {
    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public ConstTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_constType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterConstType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitConstType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitConstType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ConstTypeContext constType() throws RecognitionException {
    ConstTypeContext _localctx = new ConstTypeContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_constType);
    try {
      setState(385);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
          enterOuterAlt(_localctx, 1);
          {
            setState(383);
            primitiveType();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(384);
            match(IDENTIFIER_WEBIDL);
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
  public static class ReadonlyMemberContext extends ParserRuleContext {
    public ReadonlyMemberRestContext readonlyMemberRest() {
      return getRuleContext(ReadonlyMemberRestContext.class, 0);
    }

    public ReadonlyMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_readonlyMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterReadonlyMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitReadonlyMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitReadonlyMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReadonlyMemberContext readonlyMember() throws RecognitionException {
    ReadonlyMemberContext _localctx = new ReadonlyMemberContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_readonlyMember);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(387);
        match(T__17);
        setState(388);
        readonlyMemberRest();
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
  public static class ReadonlyMemberRestContext extends ParserRuleContext {
    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public MaplikeRestContext maplikeRest() {
      return getRuleContext(MaplikeRestContext.class, 0);
    }

    public SetlikeRestContext setlikeRest() {
      return getRuleContext(SetlikeRestContext.class, 0);
    }

    public ReadonlyMemberRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_readonlyMemberRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterReadonlyMemberRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitReadonlyMemberRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitReadonlyMemberRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReadonlyMemberRestContext readonlyMemberRest() throws RecognitionException {
    ReadonlyMemberRestContext _localctx = new ReadonlyMemberRestContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_readonlyMemberRest);
    try {
      setState(393);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__1:
          enterOuterAlt(_localctx, 1);
          {
            setState(390);
            attributeRest();
          }
          break;
        case T__13:
          enterOuterAlt(_localctx, 2);
          {
            setState(391);
            maplikeRest();
          }
          break;
        case T__19:
          enterOuterAlt(_localctx, 3);
          {
            setState(392);
            setlikeRest();
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
  public static class ReadWriteAttributeContext extends ParserRuleContext {
    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public ReadWriteAttributeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_readWriteAttribute;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterReadWriteAttribute(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitReadWriteAttribute(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitReadWriteAttribute(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReadWriteAttributeContext readWriteAttribute() throws RecognitionException {
    ReadWriteAttributeContext _localctx = new ReadWriteAttributeContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_readWriteAttribute);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(395);
        attributeRest();
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
  public static class InheritAttributeContext extends ParserRuleContext {
    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public InheritAttributeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inheritAttribute;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterInheritAttribute(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitInheritAttribute(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitInheritAttribute(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InheritAttributeContext inheritAttribute() throws RecognitionException {
    InheritAttributeContext _localctx = new InheritAttributeContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_inheritAttribute);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(397);
        match(T__10);
        setState(398);
        attributeRest();
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
  public static class AttributeRestContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public AttributeNameContext attributeName() {
      return getRuleContext(AttributeNameContext.class, 0);
    }

    public AttributeRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_attributeRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterAttributeRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitAttributeRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitAttributeRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AttributeRestContext attributeRest() throws RecognitionException {
    AttributeRestContext _localctx = new AttributeRestContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_attributeRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(400);
        match(T__1);
        setState(401);
        typeWithExtendedAttributes();
        setState(402);
        attributeName();
        setState(403);
        match(T__27);
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
  public static class AttributeNameContext extends ParserRuleContext {
    public AttributeNameKeywordContext attributeNameKeyword() {
      return getRuleContext(AttributeNameKeywordContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public AttributeNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_attributeName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterAttributeName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitAttributeName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitAttributeName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AttributeNameContext attributeName() throws RecognitionException {
    AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_attributeName);
    try {
      setState(407);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__18:
          enterOuterAlt(_localctx, 1);
          {
            setState(405);
            attributeNameKeyword();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(406);
            match(IDENTIFIER_WEBIDL);
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
  public static class AttributeNameKeywordContext extends ParserRuleContext {
    public AttributeNameKeywordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_attributeNameKeyword;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterAttributeNameKeyword(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitAttributeNameKeyword(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitAttributeNameKeyword(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AttributeNameKeywordContext attributeNameKeyword() throws RecognitionException {
    AttributeNameKeywordContext _localctx = new AttributeNameKeywordContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_attributeNameKeyword);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(409);
        _la = _input.LA(1);
        if (!(_la == T__0 || _la == T__18)) {
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
  public static class OptionalReadOnlyContext extends ParserRuleContext {
    public OptionalReadOnlyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionalReadOnly;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterOptionalReadOnly(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitOptionalReadOnly(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOptionalReadOnly(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptionalReadOnlyContext optionalReadOnly() throws RecognitionException {
    OptionalReadOnlyContext _localctx = new OptionalReadOnlyContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_optionalReadOnly);
    try {
      setState(413);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__17:
          enterOuterAlt(_localctx, 1);
          {
            setState(411);
            match(T__17);
          }
          break;
        case T__1:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class DefaultValueContext extends ParserRuleContext {
    public ConstValueContext constValue() {
      return getRuleContext(ConstValueContext.class, 0);
    }

    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
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
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterDefaultValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitDefaultValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDefaultValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefaultValueContext defaultValue() throws RecognitionException {
    DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_defaultValue);
    try {
      setState(422);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__30:
        case T__31:
        case T__32:
        case T__33:
        case T__34:
        case INTEGER_WEBIDL:
        case DECIMAL_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(415);
            constValue();
          }
          break;
        case STRING_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(416);
            match(STRING_WEBIDL);
          }
          break;
        case T__35:
          enterOuterAlt(_localctx, 3);
          {
            setState(417);
            match(T__35);
            setState(418);
            match(T__36);
          }
          break;
        case T__25:
          enterOuterAlt(_localctx, 4);
          {
            setState(419);
            match(T__25);
            setState(420);
            match(T__26);
          }
          break;
        case T__37:
          enterOuterAlt(_localctx, 5);
          {
            setState(421);
            match(T__37);
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
  public static class OperationContext extends ParserRuleContext {
    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public SpecialOperationContext specialOperation() {
      return getRuleContext(SpecialOperationContext.class, 0);
    }

    public OperationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOperation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOperation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOperation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationContext operation() throws RecognitionException {
    OperationContext _localctx = new OperationContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_operation);
    try {
      setState(426);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(424);
            regularOperation();
          }
          break;
        case T__5:
        case T__8:
        case T__20:
          enterOuterAlt(_localctx, 2);
          {
            setState(425);
            specialOperation();
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
  public static class RegularOperationContext extends ParserRuleContext {
    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public OperationRestContext operationRest() {
      return getRuleContext(OperationRestContext.class, 0);
    }

    public RegularOperationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_regularOperation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterRegularOperation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitRegularOperation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitRegularOperation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RegularOperationContext regularOperation() throws RecognitionException {
    RegularOperationContext _localctx = new RegularOperationContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_regularOperation);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(428);
        type_();
        setState(429);
        operationRest();
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
  public static class SpecialOperationContext extends ParserRuleContext {
    public SpecialContext special() {
      return getRuleContext(SpecialContext.class, 0);
    }

    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public SpecialOperationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_specialOperation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterSpecialOperation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitSpecialOperation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitSpecialOperation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SpecialOperationContext specialOperation() throws RecognitionException {
    SpecialOperationContext _localctx = new SpecialOperationContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_specialOperation);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(431);
        special();
        setState(432);
        regularOperation();
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
  public static class SpecialContext extends ParserRuleContext {
    public SpecialContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_special;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterSpecial(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitSpecial(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitSpecial(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SpecialContext special() throws RecognitionException {
    SpecialContext _localctx = new SpecialContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_special);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(434);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097728L) != 0))) {
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
  public static class OperationRestContext extends ParserRuleContext {
    public OptionalOperationNameContext optionalOperationName() {
      return getRuleContext(OptionalOperationNameContext.class, 0);
    }

    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public OperationRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOperationRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOperationRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOperationRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationRestContext operationRest() throws RecognitionException {
    OperationRestContext _localctx = new OperationRestContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_operationRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(436);
        optionalOperationName();
        setState(437);
        match(T__38);
        setState(438);
        argumentList();
        setState(439);
        match(T__39);
        setState(440);
        match(T__27);
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
  public static class OptionalOperationNameContext extends ParserRuleContext {
    public OperationNameContext operationName() {
      return getRuleContext(OperationNameContext.class, 0);
    }

    public OptionalOperationNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionalOperationName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterOptionalOperationName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitOptionalOperationName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOptionalOperationName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptionalOperationNameContext optionalOperationName() throws RecognitionException {
    OptionalOperationNameContext _localctx = new OptionalOperationNameContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_optionalOperationName);
    try {
      setState(444);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__9:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(442);
            operationName();
          }
          break;
        case T__38:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class OperationNameContext extends ParserRuleContext {
    public OperationNameKeywordContext operationNameKeyword() {
      return getRuleContext(OperationNameKeywordContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public OperationNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOperationName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOperationName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOperationName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationNameContext operationName() throws RecognitionException {
    OperationNameContext _localctx = new OperationNameContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_operationName);
    try {
      setState(448);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__9:
          enterOuterAlt(_localctx, 1);
          {
            setState(446);
            operationNameKeyword();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(447);
            match(IDENTIFIER_WEBIDL);
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
  public static class OperationNameKeywordContext extends ParserRuleContext {
    public OperationNameKeywordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_operationNameKeyword;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterOperationNameKeyword(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitOperationNameKeyword(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOperationNameKeyword(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OperationNameKeywordContext operationNameKeyword() throws RecognitionException {
    OperationNameKeywordContext _localctx = new OperationNameKeywordContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_operationNameKeyword);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(450);
        match(T__9);
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
  public static class ArgumentListContext extends ParserRuleContext {
    public ArgumentContext argument() {
      return getRuleContext(ArgumentContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ArgumentListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterArgumentList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitArgumentList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArgumentList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentListContext argumentList() throws RecognitionException {
    ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_argumentList);
    try {
      setState(456);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__35:
        case T__38:
        case T__41:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(452);
            argument();
            setState(453);
            arguments();
          }
          break;
        case T__39:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ArgumentsContext extends ParserRuleContext {
    public ArgumentContext argument() {
      return getRuleContext(ArgumentContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
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
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitArguments(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArguments(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentsContext arguments() throws RecognitionException {
    ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_arguments);
    try {
      setState(463);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(458);
            match(T__40);
            setState(459);
            argument();
            setState(460);
            arguments();
          }
          break;
        case T__39:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ArgumentContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public ArgumentRestContext argumentRest() {
      return getRuleContext(ArgumentRestContext.class, 0);
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
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterArgument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitArgument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArgument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentContext argument() throws RecognitionException {
    ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_argument);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(465);
        extendedAttributeList();
        setState(466);
        argumentRest();
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
  public static class ArgumentRestContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public ArgumentNameContext argumentName() {
      return getRuleContext(ArgumentNameContext.class, 0);
    }

    public Default_Context default_() {
      return getRuleContext(Default_Context.class, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public EllipsisContext ellipsis() {
      return getRuleContext(EllipsisContext.class, 0);
    }

    public ArgumentRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterArgumentRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitArgumentRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArgumentRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentRestContext argumentRest() throws RecognitionException {
    ArgumentRestContext _localctx = new ArgumentRestContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_argumentRest);
    try {
      setState(477);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__41:
          enterOuterAlt(_localctx, 1);
          {
            setState(468);
            match(T__41);
            setState(469);
            typeWithExtendedAttributes();
            setState(470);
            argumentName();
            setState(471);
            default_();
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(473);
            type_();
            setState(474);
            ellipsis();
            setState(475);
            argumentName();
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
  public static class ArgumentNameContext extends ParserRuleContext {
    public ArgumentNameKeywordContext argumentNameKeyword() {
      return getRuleContext(ArgumentNameKeywordContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public ArgumentNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterArgumentName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitArgumentName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitArgumentName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentNameContext argumentName() throws RecognitionException {
    ArgumentNameContext _localctx = new ArgumentNameContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_argumentName);
    try {
      setState(481);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
          enterOuterAlt(_localctx, 1);
          {
            setState(479);
            argumentNameKeyword();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(480);
            match(IDENTIFIER_WEBIDL);
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
  public static class EllipsisContext extends ParserRuleContext {
    public EllipsisContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ellipsis;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterEllipsis(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitEllipsis(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitEllipsis(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EllipsisContext ellipsis() throws RecognitionException {
    EllipsisContext _localctx = new EllipsisContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_ellipsis);
    try {
      setState(485);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__42:
          enterOuterAlt(_localctx, 1);
          {
            setState(483);
            match(T__42);
          }
          break;
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ConstructorContext extends ParserRuleContext {
    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public ConstructorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_constructor;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterConstructor(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitConstructor(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitConstructor(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ConstructorContext constructor() throws RecognitionException {
    ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_constructor);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(487);
        match(T__4);
        setState(488);
        match(T__38);
        setState(489);
        argumentList();
        setState(490);
        match(T__39);
        setState(491);
        match(T__27);
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
  public static class StringifierContext extends ParserRuleContext {
    public StringifierRestContext stringifierRest() {
      return getRuleContext(StringifierRestContext.class, 0);
    }

    public StringifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterStringifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStringifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStringifier(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringifierContext stringifier() throws RecognitionException {
    StringifierContext _localctx = new StringifierContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_stringifier);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(493);
        match(T__22);
        setState(494);
        stringifierRest();
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
  public static class StringifierRestContext extends ParserRuleContext {
    public OptionalReadOnlyContext optionalReadOnly() {
      return getRuleContext(OptionalReadOnlyContext.class, 0);
    }

    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public StringifierRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringifierRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterStringifierRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStringifierRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStringifierRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringifierRestContext stringifierRest() throws RecognitionException {
    StringifierRestContext _localctx = new StringifierRestContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_stringifierRest);
    try {
      setState(501);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__1:
        case T__17:
          enterOuterAlt(_localctx, 1);
          {
            setState(496);
            optionalReadOnly();
            setState(497);
            attributeRest();
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(499);
            regularOperation();
          }
          break;
        case T__27:
          enterOuterAlt(_localctx, 3);
          {
            setState(500);
            match(T__27);
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
  public static class StaticMemberContext extends ParserRuleContext {
    public StaticMemberRestContext staticMemberRest() {
      return getRuleContext(StaticMemberRestContext.class, 0);
    }

    public StaticMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_staticMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterStaticMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStaticMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStaticMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StaticMemberContext staticMember() throws RecognitionException {
    StaticMemberContext _localctx = new StaticMemberContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_staticMember);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(503);
        match(T__21);
        setState(504);
        staticMemberRest();
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
  public static class StaticMemberRestContext extends ParserRuleContext {
    public OptionalReadOnlyContext optionalReadOnly() {
      return getRuleContext(OptionalReadOnlyContext.class, 0);
    }

    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public StaticMemberRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_staticMemberRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterStaticMemberRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitStaticMemberRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStaticMemberRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StaticMemberRestContext staticMemberRest() throws RecognitionException {
    StaticMemberRestContext _localctx = new StaticMemberRestContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_staticMemberRest);
    try {
      setState(510);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__1:
        case T__17:
          enterOuterAlt(_localctx, 1);
          {
            setState(506);
            optionalReadOnly();
            setState(507);
            attributeRest();
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(509);
            regularOperation();
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
  public static class IterableContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public OptionalTypeContext optionalType() {
      return getRuleContext(OptionalTypeContext.class, 0);
    }

    public IterableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_iterable;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterIterable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitIterable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitIterable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IterableContext iterable() throws RecognitionException {
    IterableContext _localctx = new IterableContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_iterable);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(512);
        match(T__12);
        setState(513);
        match(T__43);
        setState(514);
        typeWithExtendedAttributes();
        setState(515);
        optionalType();
        setState(516);
        match(T__44);
        setState(517);
        match(T__27);
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
  public static class OptionalTypeContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public OptionalTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionalType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOptionalType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOptionalType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOptionalType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptionalTypeContext optionalType() throws RecognitionException {
    OptionalTypeContext _localctx = new OptionalTypeContext(_ctx, getState());
    enterRule(_localctx, 114, RULE_optionalType);
    try {
      setState(522);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(519);
            match(T__40);
            setState(520);
            typeWithExtendedAttributes();
          }
          break;
        case T__44:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class AsyncIterableContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public OptionalTypeContext optionalType() {
      return getRuleContext(OptionalTypeContext.class, 0);
    }

    public OptionalArgumentListContext optionalArgumentList() {
      return getRuleContext(OptionalArgumentListContext.class, 0);
    }

    public AsyncIterableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_asyncIterable;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterAsyncIterable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitAsyncIterable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitAsyncIterable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AsyncIterableContext asyncIterable() throws RecognitionException {
    AsyncIterableContext _localctx = new AsyncIterableContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_asyncIterable);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(524);
        match(T__0);
        setState(525);
        match(T__12);
        setState(526);
        match(T__43);
        setState(527);
        typeWithExtendedAttributes();
        setState(528);
        optionalType();
        setState(529);
        match(T__44);
        setState(530);
        optionalArgumentList();
        setState(531);
        match(T__27);
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
  public static class OptionalArgumentListContext extends ParserRuleContext {
    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public OptionalArgumentListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionalArgumentList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterOptionalArgumentList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitOptionalArgumentList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOptionalArgumentList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptionalArgumentListContext optionalArgumentList() throws RecognitionException {
    OptionalArgumentListContext _localctx = new OptionalArgumentListContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_optionalArgumentList);
    try {
      setState(538);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__38:
          enterOuterAlt(_localctx, 1);
          {
            setState(533);
            match(T__38);
            setState(534);
            argumentList();
            setState(535);
            match(T__39);
          }
          break;
        case T__27:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ReadWriteMaplikeContext extends ParserRuleContext {
    public MaplikeRestContext maplikeRest() {
      return getRuleContext(MaplikeRestContext.class, 0);
    }

    public ReadWriteMaplikeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_readWriteMaplike;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterReadWriteMaplike(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitReadWriteMaplike(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitReadWriteMaplike(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReadWriteMaplikeContext readWriteMaplike() throws RecognitionException {
    ReadWriteMaplikeContext _localctx = new ReadWriteMaplikeContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_readWriteMaplike);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(540);
        maplikeRest();
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
  public static class MaplikeRestContext extends ParserRuleContext {
    public List<TypeWithExtendedAttributesContext> typeWithExtendedAttributes() {
      return getRuleContexts(TypeWithExtendedAttributesContext.class);
    }

    public TypeWithExtendedAttributesContext typeWithExtendedAttributes(int i) {
      return getRuleContext(TypeWithExtendedAttributesContext.class, i);
    }

    public MaplikeRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_maplikeRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterMaplikeRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitMaplikeRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitMaplikeRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MaplikeRestContext maplikeRest() throws RecognitionException {
    MaplikeRestContext _localctx = new MaplikeRestContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_maplikeRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(542);
        match(T__13);
        setState(543);
        match(T__43);
        setState(544);
        typeWithExtendedAttributes();
        setState(545);
        match(T__40);
        setState(546);
        typeWithExtendedAttributes();
        setState(547);
        match(T__44);
        setState(548);
        match(T__27);
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
  public static class ReadWriteSetlikeContext extends ParserRuleContext {
    public SetlikeRestContext setlikeRest() {
      return getRuleContext(SetlikeRestContext.class, 0);
    }

    public ReadWriteSetlikeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_readWriteSetlike;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterReadWriteSetlike(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitReadWriteSetlike(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitReadWriteSetlike(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReadWriteSetlikeContext readWriteSetlike() throws RecognitionException {
    ReadWriteSetlikeContext _localctx = new ReadWriteSetlikeContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_readWriteSetlike);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(550);
        setlikeRest();
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
  public static class SetlikeRestContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public SetlikeRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_setlikeRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterSetlikeRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitSetlikeRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitSetlikeRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SetlikeRestContext setlikeRest() throws RecognitionException {
    SetlikeRestContext _localctx = new SetlikeRestContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_setlikeRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(552);
        match(T__19);
        setState(553);
        match(T__43);
        setState(554);
        typeWithExtendedAttributes();
        setState(555);
        match(T__44);
        setState(556);
        match(T__27);
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
  public static class Namespace_Context extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public NamespaceMembersContext namespaceMembers() {
      return getRuleContext(NamespaceMembersContext.class, 0);
    }

    public Namespace_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_namespace_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterNamespace_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitNamespace_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitNamespace_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Namespace_Context namespace_() throws RecognitionException {
    Namespace_Context _localctx = new Namespace_Context(_ctx, getState());
    enterRule(_localctx, 128, RULE_namespace_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(558);
        match(T__15);
        setState(559);
        match(IDENTIFIER_WEBIDL);
        setState(560);
        match(T__25);
        setState(561);
        namespaceMembers();
        setState(562);
        match(T__26);
        setState(563);
        match(T__27);
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
  public static class NamespaceMembersContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public NamespaceMemberContext namespaceMember() {
      return getRuleContext(NamespaceMemberContext.class, 0);
    }

    public NamespaceMembersContext namespaceMembers() {
      return getRuleContext(NamespaceMembersContext.class, 0);
    }

    public NamespaceMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_namespaceMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterNamespaceMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitNamespaceMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitNamespaceMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NamespaceMembersContext namespaceMembers() throws RecognitionException {
    NamespaceMembersContext _localctx = new NamespaceMembersContext(_ctx, getState());
    enterRule(_localctx, 130, RULE_namespaceMembers);
    try {
      setState(570);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__3:
        case T__17:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(565);
            extendedAttributeList();
            setState(566);
            namespaceMember();
            setState(567);
            namespaceMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class NamespaceMemberContext extends ParserRuleContext {
    public RegularOperationContext regularOperation() {
      return getRuleContext(RegularOperationContext.class, 0);
    }

    public AttributeRestContext attributeRest() {
      return getRuleContext(AttributeRestContext.class, 0);
    }

    public Const_Context const_() {
      return getRuleContext(Const_Context.class, 0);
    }

    public NamespaceMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_namespaceMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterNamespaceMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitNamespaceMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitNamespaceMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NamespaceMemberContext namespaceMember() throws RecognitionException {
    NamespaceMemberContext _localctx = new NamespaceMemberContext(_ctx, getState());
    enterRule(_localctx, 132, RULE_namespaceMember);
    try {
      setState(576);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(572);
            regularOperation();
          }
          break;
        case T__17:
          enterOuterAlt(_localctx, 2);
          {
            setState(573);
            match(T__17);
            setState(574);
            attributeRest();
          }
          break;
        case T__3:
          enterOuterAlt(_localctx, 3);
          {
            setState(575);
            const_();
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
  public static class DictionaryContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public InheritanceContext inheritance() {
      return getRuleContext(InheritanceContext.class, 0);
    }

    public DictionaryMembersContext dictionaryMembers() {
      return getRuleContext(DictionaryMembersContext.class, 0);
    }

    public DictionaryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dictionary;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterDictionary(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitDictionary(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDictionary(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DictionaryContext dictionary() throws RecognitionException {
    DictionaryContext _localctx = new DictionaryContext(_ctx, getState());
    enterRule(_localctx, 134, RULE_dictionary);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(578);
        match(T__6);
        setState(579);
        match(IDENTIFIER_WEBIDL);
        setState(580);
        inheritance();
        setState(581);
        match(T__25);
        setState(582);
        dictionaryMembers();
        setState(583);
        match(T__26);
        setState(584);
        match(T__27);
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
  public static class DictionaryMembersContext extends ParserRuleContext {
    public DictionaryMemberContext dictionaryMember() {
      return getRuleContext(DictionaryMemberContext.class, 0);
    }

    public DictionaryMembersContext dictionaryMembers() {
      return getRuleContext(DictionaryMembersContext.class, 0);
    }

    public DictionaryMembersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dictionaryMembers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterDictionaryMembers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitDictionaryMembers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDictionaryMembers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DictionaryMembersContext dictionaryMembers() throws RecognitionException {
    DictionaryMembersContext _localctx = new DictionaryMembersContext(_ctx, getState());
    enterRule(_localctx, 136, RULE_dictionaryMembers);
    try {
      setState(590);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__18:
        case T__24:
        case T__35:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(586);
            dictionaryMember();
            setState(587);
            dictionaryMembers();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class DictionaryMemberContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public DictionaryMemberRestContext dictionaryMemberRest() {
      return getRuleContext(DictionaryMemberRestContext.class, 0);
    }

    public DictionaryMemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dictionaryMember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterDictionaryMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitDictionaryMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDictionaryMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DictionaryMemberContext dictionaryMember() throws RecognitionException {
    DictionaryMemberContext _localctx = new DictionaryMemberContext(_ctx, getState());
    enterRule(_localctx, 138, RULE_dictionaryMember);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(592);
        extendedAttributeList();
        setState(593);
        dictionaryMemberRest();
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
  public static class DictionaryMemberRestContext extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public Default_Context default_() {
      return getRuleContext(Default_Context.class, 0);
    }

    public DictionaryMemberRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dictionaryMemberRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterDictionaryMemberRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitDictionaryMemberRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDictionaryMemberRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DictionaryMemberRestContext dictionaryMemberRest() throws RecognitionException {
    DictionaryMemberRestContext _localctx = new DictionaryMemberRestContext(_ctx, getState());
    enterRule(_localctx, 140, RULE_dictionaryMemberRest);
    try {
      setState(605);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__18:
          enterOuterAlt(_localctx, 1);
          {
            setState(595);
            match(T__18);
            setState(596);
            typeWithExtendedAttributes();
            setState(597);
            match(IDENTIFIER_WEBIDL);
            setState(598);
            match(T__27);
          }
          break;
        case T__24:
        case T__38:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(600);
            type_();
            setState(601);
            match(IDENTIFIER_WEBIDL);
            setState(602);
            default_();
            setState(603);
            match(T__27);
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
  public static class PartialDictionaryContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public DictionaryMembersContext dictionaryMembers() {
      return getRuleContext(DictionaryMembersContext.class, 0);
    }

    public PartialDictionaryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_partialDictionary;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterPartialDictionary(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitPartialDictionary(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPartialDictionary(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PartialDictionaryContext partialDictionary() throws RecognitionException {
    PartialDictionaryContext _localctx = new PartialDictionaryContext(_ctx, getState());
    enterRule(_localctx, 142, RULE_partialDictionary);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(607);
        match(T__6);
        setState(608);
        match(IDENTIFIER_WEBIDL);
        setState(609);
        match(T__25);
        setState(610);
        dictionaryMembers();
        setState(611);
        match(T__26);
        setState(612);
        match(T__27);
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
  public static class Default_Context extends ParserRuleContext {
    public DefaultValueContext defaultValue() {
      return getRuleContext(DefaultValueContext.class, 0);
    }

    public Default_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_default_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterDefault_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitDefault_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDefault_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Default_Context default_() throws RecognitionException {
    Default_Context _localctx = new Default_Context(_ctx, getState());
    enterRule(_localctx, 144, RULE_default_);
    try {
      setState(617);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__29:
          enterOuterAlt(_localctx, 1);
          {
            setState(614);
            match(T__29);
            setState(615);
            defaultValue();
          }
          break;
        case T__27:
        case T__39:
        case T__40:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class Enum_Context extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public EnumValueListContext enumValueList() {
      return getRuleContext(EnumValueListContext.class, 0);
    }

    public Enum_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enum_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterEnum_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitEnum_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitEnum_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Enum_Context enum_() throws RecognitionException {
    Enum_Context _localctx = new Enum_Context(_ctx, getState());
    enterRule(_localctx, 146, RULE_enum_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(619);
        match(T__7);
        setState(620);
        match(IDENTIFIER_WEBIDL);
        setState(621);
        match(T__25);
        setState(622);
        enumValueList();
        setState(623);
        match(T__26);
        setState(624);
        match(T__27);
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
  public static class EnumValueListContext extends ParserRuleContext {
    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public EnumValueListCommaContext enumValueListComma() {
      return getRuleContext(EnumValueListCommaContext.class, 0);
    }

    public EnumValueListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValueList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterEnumValueList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitEnumValueList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitEnumValueList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValueListContext enumValueList() throws RecognitionException {
    EnumValueListContext _localctx = new EnumValueListContext(_ctx, getState());
    enterRule(_localctx, 148, RULE_enumValueList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(626);
        match(STRING_WEBIDL);
        setState(627);
        enumValueListComma();
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
  public static class EnumValueListCommaContext extends ParserRuleContext {
    public EnumValueListStringContext enumValueListString() {
      return getRuleContext(EnumValueListStringContext.class, 0);
    }

    public EnumValueListCommaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValueListComma;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterEnumValueListComma(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitEnumValueListComma(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitEnumValueListComma(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValueListCommaContext enumValueListComma() throws RecognitionException {
    EnumValueListCommaContext _localctx = new EnumValueListCommaContext(_ctx, getState());
    enterRule(_localctx, 150, RULE_enumValueListComma);
    try {
      setState(632);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(629);
            match(T__40);
            setState(630);
            enumValueListString();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class EnumValueListStringContext extends ParserRuleContext {
    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public EnumValueListCommaContext enumValueListComma() {
      return getRuleContext(EnumValueListCommaContext.class, 0);
    }

    public EnumValueListStringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumValueListString;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterEnumValueListString(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitEnumValueListString(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitEnumValueListString(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EnumValueListStringContext enumValueListString() throws RecognitionException {
    EnumValueListStringContext _localctx = new EnumValueListStringContext(_ctx, getState());
    enterRule(_localctx, 152, RULE_enumValueListString);
    try {
      setState(637);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case STRING_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(634);
            match(STRING_WEBIDL);
            setState(635);
            enumValueListComma();
          }
          break;
        case T__26:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class CallbackRestContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public CallbackRestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callbackRest;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterCallbackRest(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitCallbackRest(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitCallbackRest(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallbackRestContext callbackRest() throws RecognitionException {
    CallbackRestContext _localctx = new CallbackRestContext(_ctx, getState());
    enterRule(_localctx, 154, RULE_callbackRest);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(639);
        match(IDENTIFIER_WEBIDL);
        setState(640);
        match(T__29);
        setState(641);
        type_();
        setState(642);
        match(T__38);
        setState(643);
        argumentList();
        setState(644);
        match(T__39);
        setState(645);
        match(T__27);
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
  public static class Typedef_Context extends ParserRuleContext {
    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public Typedef_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typedef_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterTypedef_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitTypedef_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitTypedef_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Typedef_Context typedef_() throws RecognitionException {
    Typedef_Context _localctx = new Typedef_Context(_ctx, getState());
    enterRule(_localctx, 156, RULE_typedef_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(647);
        match(T__23);
        setState(648);
        typeWithExtendedAttributes();
        setState(649);
        match(IDENTIFIER_WEBIDL);
        setState(650);
        match(T__27);
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
    public SingleTypeContext singleType() {
      return getRuleContext(SingleTypeContext.class, 0);
    }

    public UnionTypeContext unionType() {
      return getRuleContext(UnionTypeContext.class, 0);
    }

    public Null_Context null_() {
      return getRuleContext(Null_Context.class, 0);
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
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterType_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitType_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitType_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Type_Context type_() throws RecognitionException {
    Type_Context _localctx = new Type_Context(_ctx, getState());
    enterRule(_localctx, 158, RULE_type_);
    try {
      setState(656);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(652);
            singleType();
          }
          break;
        case T__38:
          enterOuterAlt(_localctx, 2);
          {
            setState(653);
            unionType();
            setState(654);
            null_();
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
  public static class TypeWithExtendedAttributesContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public TypeWithExtendedAttributesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeWithExtendedAttributes;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterTypeWithExtendedAttributes(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitTypeWithExtendedAttributes(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitTypeWithExtendedAttributes(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeWithExtendedAttributesContext typeWithExtendedAttributes()
      throws RecognitionException {
    TypeWithExtendedAttributesContext _localctx =
        new TypeWithExtendedAttributesContext(_ctx, getState());
    enterRule(_localctx, 160, RULE_typeWithExtendedAttributes);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(658);
        extendedAttributeList();
        setState(659);
        type_();
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
  public static class SingleTypeContext extends ParserRuleContext {
    public DistinguishableTypeContext distinguishableType() {
      return getRuleContext(DistinguishableTypeContext.class, 0);
    }

    public PromiseTypeContext promiseType() {
      return getRuleContext(PromiseTypeContext.class, 0);
    }

    public SingleTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_singleType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterSingleType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitSingleType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitSingleType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SingleTypeContext singleType() throws RecognitionException {
    SingleTypeContext _localctx = new SingleTypeContext(_ctx, getState());
    enterRule(_localctx, 162, RULE_singleType);
    try {
      setState(664);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(661);
            distinguishableType();
          }
          break;
        case T__45:
          enterOuterAlt(_localctx, 2);
          {
            setState(662);
            match(T__45);
          }
          break;
        case T__65:
          enterOuterAlt(_localctx, 3);
          {
            setState(663);
            promiseType();
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
  public static class UnionTypeContext extends ParserRuleContext {
    public List<UnionMemberTypeContext> unionMemberType() {
      return getRuleContexts(UnionMemberTypeContext.class);
    }

    public UnionMemberTypeContext unionMemberType(int i) {
      return getRuleContext(UnionMemberTypeContext.class, i);
    }

    public UnionMemberTypesContext unionMemberTypes() {
      return getRuleContext(UnionMemberTypesContext.class, 0);
    }

    public UnionTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterUnionType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitUnionType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitUnionType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionTypeContext unionType() throws RecognitionException {
    UnionTypeContext _localctx = new UnionTypeContext(_ctx, getState());
    enterRule(_localctx, 164, RULE_unionType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(666);
        match(T__38);
        setState(667);
        unionMemberType();
        setState(668);
        match(T__46);
        setState(669);
        unionMemberType();
        setState(670);
        unionMemberTypes();
        setState(671);
        match(T__39);
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
  public static class UnionMemberTypeContext extends ParserRuleContext {
    public ExtendedAttributeListContext extendedAttributeList() {
      return getRuleContext(ExtendedAttributeListContext.class, 0);
    }

    public DistinguishableTypeContext distinguishableType() {
      return getRuleContext(DistinguishableTypeContext.class, 0);
    }

    public UnionTypeContext unionType() {
      return getRuleContext(UnionTypeContext.class, 0);
    }

    public Null_Context null_() {
      return getRuleContext(Null_Context.class, 0);
    }

    public UnionMemberTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionMemberType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterUnionMemberType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitUnionMemberType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitUnionMemberType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionMemberTypeContext unionMemberType() throws RecognitionException {
    UnionMemberTypeContext _localctx = new UnionMemberTypeContext(_ctx, getState());
    enterRule(_localctx, 166, RULE_unionMemberType);
    try {
      setState(679);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__35:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(673);
            extendedAttributeList();
            setState(674);
            distinguishableType();
          }
          break;
        case T__38:
          enterOuterAlt(_localctx, 2);
          {
            setState(676);
            unionType();
            setState(677);
            null_();
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
  public static class UnionMemberTypesContext extends ParserRuleContext {
    public UnionMemberTypeContext unionMemberType() {
      return getRuleContext(UnionMemberTypeContext.class, 0);
    }

    public UnionMemberTypesContext unionMemberTypes() {
      return getRuleContext(UnionMemberTypesContext.class, 0);
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
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterUnionMemberTypes(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitUnionMemberTypes(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitUnionMemberTypes(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionMemberTypesContext unionMemberTypes() throws RecognitionException {
    UnionMemberTypesContext _localctx = new UnionMemberTypesContext(_ctx, getState());
    enterRule(_localctx, 168, RULE_unionMemberTypes);
    try {
      setState(686);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__46:
          enterOuterAlt(_localctx, 1);
          {
            setState(681);
            match(T__46);
            setState(682);
            unionMemberType();
            setState(683);
            unionMemberTypes();
          }
          break;
        case T__39:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class DistinguishableTypeContext extends ParserRuleContext {
    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public Null_Context null_() {
      return getRuleContext(Null_Context.class, 0);
    }

    public StringTypeContext stringType() {
      return getRuleContext(StringTypeContext.class, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public BufferRelatedTypeContext bufferRelatedType() {
      return getRuleContext(BufferRelatedTypeContext.class, 0);
    }

    public RecordTypeContext recordType() {
      return getRuleContext(RecordTypeContext.class, 0);
    }

    public DistinguishableTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_distinguishableType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterDistinguishableType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitDistinguishableType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitDistinguishableType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DistinguishableTypeContext distinguishableType() throws RecognitionException {
    DistinguishableTypeContext _localctx = new DistinguishableTypeContext(_ctx, getState());
    enterRule(_localctx, 170, RULE_distinguishableType);
    try {
      setState(724);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
          enterOuterAlt(_localctx, 1);
          {
            setState(688);
            primitiveType();
            setState(689);
            null_();
          }
          break;
        case T__62:
        case T__63:
        case T__64:
          enterOuterAlt(_localctx, 2);
          {
            setState(691);
            stringType();
            setState(692);
            null_();
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 3);
          {
            setState(694);
            match(IDENTIFIER_WEBIDL);
            setState(695);
            null_();
          }
          break;
        case T__47:
          enterOuterAlt(_localctx, 4);
          {
            setState(696);
            match(T__47);
            setState(697);
            match(T__43);
            setState(698);
            typeWithExtendedAttributes();
            setState(699);
            match(T__44);
            setState(700);
            null_();
          }
          break;
        case T__48:
          enterOuterAlt(_localctx, 5);
          {
            setState(702);
            match(T__48);
            setState(703);
            null_();
          }
          break;
        case T__49:
          enterOuterAlt(_localctx, 6);
          {
            setState(704);
            match(T__49);
            setState(705);
            null_();
          }
          break;
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
          enterOuterAlt(_localctx, 7);
          {
            setState(706);
            bufferRelatedType();
            setState(707);
            null_();
          }
          break;
        case T__50:
          enterOuterAlt(_localctx, 8);
          {
            setState(709);
            match(T__50);
            setState(710);
            match(T__43);
            setState(711);
            typeWithExtendedAttributes();
            setState(712);
            match(T__44);
            setState(713);
            null_();
          }
          break;
        case T__51:
          enterOuterAlt(_localctx, 9);
          {
            setState(715);
            match(T__51);
            setState(716);
            match(T__43);
            setState(717);
            typeWithExtendedAttributes();
            setState(718);
            match(T__44);
            setState(719);
            null_();
          }
          break;
        case T__66:
          enterOuterAlt(_localctx, 10);
          {
            setState(721);
            recordType();
            setState(722);
            null_();
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
  public static class PrimitiveTypeContext extends ParserRuleContext {
    public UnsignedIntegerTypeContext unsignedIntegerType() {
      return getRuleContext(UnsignedIntegerTypeContext.class, 0);
    }

    public UnrestrictedFloatTypeContext unrestrictedFloatType() {
      return getRuleContext(UnrestrictedFloatTypeContext.class, 0);
    }

    public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primitiveType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterPrimitiveType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitPrimitiveType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPrimitiveType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PrimitiveTypeContext primitiveType() throws RecognitionException {
    PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
    enterRule(_localctx, 172, RULE_primitiveType);
    try {
      setState(733);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__59:
        case T__60:
        case T__61:
          enterOuterAlt(_localctx, 1);
          {
            setState(726);
            unsignedIntegerType();
          }
          break;
        case T__24:
        case T__57:
        case T__58:
          enterOuterAlt(_localctx, 2);
          {
            setState(727);
            unrestrictedFloatType();
          }
          break;
        case T__52:
          enterOuterAlt(_localctx, 3);
          {
            setState(728);
            match(T__52);
          }
          break;
        case T__53:
          enterOuterAlt(_localctx, 4);
          {
            setState(729);
            match(T__53);
          }
          break;
        case T__54:
          enterOuterAlt(_localctx, 5);
          {
            setState(730);
            match(T__54);
          }
          break;
        case T__55:
          enterOuterAlt(_localctx, 6);
          {
            setState(731);
            match(T__55);
          }
          break;
        case T__56:
          enterOuterAlt(_localctx, 7);
          {
            setState(732);
            match(T__56);
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
  public static class UnrestrictedFloatTypeContext extends ParserRuleContext {
    public FloatTypeContext floatType() {
      return getRuleContext(FloatTypeContext.class, 0);
    }

    public UnrestrictedFloatTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unrestrictedFloatType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterUnrestrictedFloatType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitUnrestrictedFloatType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitUnrestrictedFloatType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnrestrictedFloatTypeContext unrestrictedFloatType() throws RecognitionException {
    UnrestrictedFloatTypeContext _localctx = new UnrestrictedFloatTypeContext(_ctx, getState());
    enterRule(_localctx, 174, RULE_unrestrictedFloatType);
    try {
      setState(738);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__24:
          enterOuterAlt(_localctx, 1);
          {
            setState(735);
            match(T__24);
            setState(736);
            floatType();
          }
          break;
        case T__57:
        case T__58:
          enterOuterAlt(_localctx, 2);
          {
            setState(737);
            floatType();
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
  public static class FloatTypeContext extends ParserRuleContext {
    public FloatTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_floatType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterFloatType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitFloatType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitFloatType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FloatTypeContext floatType() throws RecognitionException {
    FloatTypeContext _localctx = new FloatTypeContext(_ctx, getState());
    enterRule(_localctx, 176, RULE_floatType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(740);
        _la = _input.LA(1);
        if (!(_la == T__57 || _la == T__58)) {
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
  public static class UnsignedIntegerTypeContext extends ParserRuleContext {
    public IntegerTypeContext integerType() {
      return getRuleContext(IntegerTypeContext.class, 0);
    }

    public UnsignedIntegerTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unsignedIntegerType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterUnsignedIntegerType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitUnsignedIntegerType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitUnsignedIntegerType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnsignedIntegerTypeContext unsignedIntegerType() throws RecognitionException {
    UnsignedIntegerTypeContext _localctx = new UnsignedIntegerTypeContext(_ctx, getState());
    enterRule(_localctx, 178, RULE_unsignedIntegerType);
    try {
      setState(745);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__59:
          enterOuterAlt(_localctx, 1);
          {
            setState(742);
            match(T__59);
            setState(743);
            integerType();
          }
          break;
        case T__60:
        case T__61:
          enterOuterAlt(_localctx, 2);
          {
            setState(744);
            integerType();
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
  public static class IntegerTypeContext extends ParserRuleContext {
    public OptionalLongContext optionalLong() {
      return getRuleContext(OptionalLongContext.class, 0);
    }

    public IntegerTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_integerType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterIntegerType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitIntegerType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitIntegerType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IntegerTypeContext integerType() throws RecognitionException {
    IntegerTypeContext _localctx = new IntegerTypeContext(_ctx, getState());
    enterRule(_localctx, 180, RULE_integerType);
    try {
      setState(750);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__60:
          enterOuterAlt(_localctx, 1);
          {
            setState(747);
            match(T__60);
          }
          break;
        case T__61:
          enterOuterAlt(_localctx, 2);
          {
            setState(748);
            match(T__61);
            setState(749);
            optionalLong();
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
  public static class OptionalLongContext extends ParserRuleContext {
    public OptionalLongContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionalLong;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOptionalLong(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOptionalLong(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOptionalLong(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptionalLongContext optionalLong() throws RecognitionException {
    OptionalLongContext _localctx = new OptionalLongContext(_ctx, getState());
    enterRule(_localctx, 182, RULE_optionalLong);
    try {
      setState(754);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__61:
          enterOuterAlt(_localctx, 1);
          {
            setState(752);
            match(T__61);
          }
          break;
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
        case T__38:
        case T__39:
        case T__40:
        case T__42:
        case T__44:
        case T__46:
        case T__67:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class StringTypeContext extends ParserRuleContext {
    public StringTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterStringType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStringType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStringType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringTypeContext stringType() throws RecognitionException {
    StringTypeContext _localctx = new StringTypeContext(_ctx, getState());
    enterRule(_localctx, 184, RULE_stringType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(756);
        _la = _input.LA(1);
        if (!(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0))) {
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
  public static class PromiseTypeContext extends ParserRuleContext {
    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public PromiseTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_promiseType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterPromiseType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitPromiseType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitPromiseType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PromiseTypeContext promiseType() throws RecognitionException {
    PromiseTypeContext _localctx = new PromiseTypeContext(_ctx, getState());
    enterRule(_localctx, 186, RULE_promiseType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(758);
        match(T__65);
        setState(759);
        match(T__43);
        setState(760);
        type_();
        setState(761);
        match(T__44);
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
  public static class RecordTypeContext extends ParserRuleContext {
    public StringTypeContext stringType() {
      return getRuleContext(StringTypeContext.class, 0);
    }

    public TypeWithExtendedAttributesContext typeWithExtendedAttributes() {
      return getRuleContext(TypeWithExtendedAttributesContext.class, 0);
    }

    public RecordTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_recordType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterRecordType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitRecordType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitRecordType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RecordTypeContext recordType() throws RecognitionException {
    RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
    enterRule(_localctx, 188, RULE_recordType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(763);
        match(T__66);
        setState(764);
        match(T__43);
        setState(765);
        stringType();
        setState(766);
        match(T__40);
        setState(767);
        typeWithExtendedAttributes();
        setState(768);
        match(T__44);
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
  public static class Null_Context extends ParserRuleContext {
    public Null_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_null_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterNull_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitNull_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitNull_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Null_Context null_() throws RecognitionException {
    Null_Context _localctx = new Null_Context(_ctx, getState());
    enterRule(_localctx, 190, RULE_null_);
    try {
      setState(772);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__67:
          enterOuterAlt(_localctx, 1);
          {
            setState(770);
            match(T__67);
          }
          break;
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
        case T__38:
        case T__39:
        case T__40:
        case T__42:
        case T__44:
        case T__46:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class BufferRelatedTypeContext extends ParserRuleContext {
    public BufferRelatedTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_bufferRelatedType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterBufferRelatedType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitBufferRelatedType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitBufferRelatedType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BufferRelatedTypeContext bufferRelatedType() throws RecognitionException {
    BufferRelatedTypeContext _localctx = new BufferRelatedTypeContext(_ctx, getState());
    enterRule(_localctx, 192, RULE_bufferRelatedType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(774);
        _la = _input.LA(1);
        if (!(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 2047L) != 0))) {
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
  public static class ExtendedAttributeListContext extends ParserRuleContext {
    public ExtendedAttributeContext extendedAttribute() {
      return getRuleContext(ExtendedAttributeContext.class, 0);
    }

    public ExtendedAttributesContext extendedAttributes() {
      return getRuleContext(ExtendedAttributesContext.class, 0);
    }

    public ExtendedAttributeListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeListContext extendedAttributeList() throws RecognitionException {
    ExtendedAttributeListContext _localctx = new ExtendedAttributeListContext(_ctx, getState());
    enterRule(_localctx, 194, RULE_extendedAttributeList);
    try {
      setState(782);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__35:
          enterOuterAlt(_localctx, 1);
          {
            setState(776);
            match(T__35);
            setState(777);
            extendedAttribute();
            setState(778);
            extendedAttributes();
            setState(779);
            match(T__36);
          }
          break;
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
        case T__38:
        case T__41:
        case T__45:
        case T__47:
        case T__48:
        case T__49:
        case T__50:
        case T__51:
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ExtendedAttributesContext extends ParserRuleContext {
    public ExtendedAttributeContext extendedAttribute() {
      return getRuleContext(ExtendedAttributeContext.class, 0);
    }

    public ExtendedAttributesContext extendedAttributes() {
      return getRuleContext(ExtendedAttributesContext.class, 0);
    }

    public ExtendedAttributesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributes;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributes(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributes(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributes(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributesContext extendedAttributes() throws RecognitionException {
    ExtendedAttributesContext _localctx = new ExtendedAttributesContext(_ctx, getState());
    enterRule(_localctx, 196, RULE_extendedAttributes);
    try {
      setState(789);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(784);
            match(T__40);
            setState(785);
            extendedAttribute();
            setState(786);
            extendedAttributes();
          }
          break;
        case T__36:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ExtendedAttributeContext extends ParserRuleContext {
    public ExtendedAttributeNoArgsContext extendedAttributeNoArgs() {
      return getRuleContext(ExtendedAttributeNoArgsContext.class, 0);
    }

    public ExtendedAttributeArgListContext extendedAttributeArgList() {
      return getRuleContext(ExtendedAttributeArgListContext.class, 0);
    }

    public ExtendedAttributeNamedArgListContext extendedAttributeNamedArgList() {
      return getRuleContext(ExtendedAttributeNamedArgListContext.class, 0);
    }

    public ExtendedAttributeIdentContext extendedAttributeIdent() {
      return getRuleContext(ExtendedAttributeIdentContext.class, 0);
    }

    public ExtendedAttributeIdentListContext extendedAttributeIdentList() {
      return getRuleContext(ExtendedAttributeIdentListContext.class, 0);
    }

    public ExtendedAttributeStringContext extendedAttributeString() {
      return getRuleContext(ExtendedAttributeStringContext.class, 0);
    }

    public ExtendedAttributeStringListContext extendedAttributeStringList() {
      return getRuleContext(ExtendedAttributeStringListContext.class, 0);
    }

    public ExtendedAttributeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttribute;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttribute(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttribute(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttribute(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeContext extendedAttribute() throws RecognitionException {
    ExtendedAttributeContext _localctx = new ExtendedAttributeContext(_ctx, getState());
    enterRule(_localctx, 198, RULE_extendedAttribute);
    try {
      setState(798);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(791);
            extendedAttributeNoArgs();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(792);
            extendedAttributeArgList();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(793);
            extendedAttributeNamedArgList();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(794);
            extendedAttributeIdent();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(795);
            extendedAttributeIdentList();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(796);
            extendedAttributeString();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(797);
            extendedAttributeStringList();
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
  public static class OtherContext extends ParserRuleContext {
    public TerminalNode INTEGER_WEBIDL() {
      return getToken(WebIDLParser.INTEGER_WEBIDL, 0);
    }

    public TerminalNode DECIMAL_WEBIDL() {
      return getToken(WebIDLParser.DECIMAL_WEBIDL, 0);
    }

    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public TerminalNode OTHER_WEBIDL() {
      return getToken(WebIDLParser.OTHER_WEBIDL, 0);
    }

    public ArgumentNameKeywordContext argumentNameKeyword() {
      return getRuleContext(ArgumentNameKeywordContext.class, 0);
    }

    public BufferRelatedTypeContext bufferRelatedType() {
      return getRuleContext(BufferRelatedTypeContext.class, 0);
    }

    public OtherContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_other;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOther(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOther(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOther(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OtherContext other() throws RecognitionException {
    OtherContext _localctx = new OtherContext(_ctx, getState());
    enterRule(_localctx, 200, RULE_other);
    try {
      setState(845);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case INTEGER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(800);
            match(INTEGER_WEBIDL);
          }
          break;
        case DECIMAL_WEBIDL:
          enterOuterAlt(_localctx, 2);
          {
            setState(801);
            match(DECIMAL_WEBIDL);
          }
          break;
        case IDENTIFIER_WEBIDL:
          enterOuterAlt(_localctx, 3);
          {
            setState(802);
            match(IDENTIFIER_WEBIDL);
          }
          break;
        case STRING_WEBIDL:
          enterOuterAlt(_localctx, 4);
          {
            setState(803);
            match(STRING_WEBIDL);
          }
          break;
        case OTHER_WEBIDL:
          enterOuterAlt(_localctx, 5);
          {
            setState(804);
            match(OTHER_WEBIDL);
          }
          break;
        case T__79:
          enterOuterAlt(_localctx, 6);
          {
            setState(805);
            match(T__79);
          }
          break;
        case T__32:
          enterOuterAlt(_localctx, 7);
          {
            setState(806);
            match(T__32);
          }
          break;
        case T__80:
          enterOuterAlt(_localctx, 8);
          {
            setState(807);
            match(T__80);
          }
          break;
        case T__42:
          enterOuterAlt(_localctx, 9);
          {
            setState(808);
            match(T__42);
          }
          break;
        case T__28:
          enterOuterAlt(_localctx, 10);
          {
            setState(809);
            match(T__28);
          }
          break;
        case T__27:
          enterOuterAlt(_localctx, 11);
          {
            setState(810);
            match(T__27);
          }
          break;
        case T__43:
          enterOuterAlt(_localctx, 12);
          {
            setState(811);
            match(T__43);
          }
          break;
        case T__29:
          enterOuterAlt(_localctx, 13);
          {
            setState(812);
            match(T__29);
          }
          break;
        case T__44:
          enterOuterAlt(_localctx, 14);
          {
            setState(813);
            match(T__44);
          }
          break;
        case T__67:
          enterOuterAlt(_localctx, 15);
          {
            setState(814);
            match(T__67);
          }
          break;
        case T__62:
          enterOuterAlt(_localctx, 16);
          {
            setState(815);
            match(T__62);
          }
          break;
        case T__63:
          enterOuterAlt(_localctx, 17);
          {
            setState(816);
            match(T__63);
          }
          break;
        case T__50:
          enterOuterAlt(_localctx, 18);
          {
            setState(817);
            match(T__50);
          }
          break;
        case T__33:
          enterOuterAlt(_localctx, 19);
          {
            setState(818);
            match(T__33);
          }
          break;
        case T__34:
          enterOuterAlt(_localctx, 20);
          {
            setState(819);
            match(T__34);
          }
          break;
        case T__51:
          enterOuterAlt(_localctx, 21);
          {
            setState(820);
            match(T__51);
          }
          break;
        case T__65:
          enterOuterAlt(_localctx, 22);
          {
            setState(821);
            match(T__65);
          }
          break;
        case T__64:
          enterOuterAlt(_localctx, 23);
          {
            setState(822);
            match(T__64);
          }
          break;
        case T__45:
          enterOuterAlt(_localctx, 24);
          {
            setState(823);
            match(T__45);
          }
          break;
        case T__56:
          enterOuterAlt(_localctx, 25);
          {
            setState(824);
            match(T__56);
          }
          break;
        case T__53:
          enterOuterAlt(_localctx, 26);
          {
            setState(825);
            match(T__53);
          }
          break;
        case T__54:
          enterOuterAlt(_localctx, 27);
          {
            setState(826);
            match(T__54);
          }
          break;
        case T__58:
          enterOuterAlt(_localctx, 28);
          {
            setState(827);
            match(T__58);
          }
          break;
        case T__31:
          enterOuterAlt(_localctx, 29);
          {
            setState(828);
            match(T__31);
          }
          break;
        case T__57:
          enterOuterAlt(_localctx, 30);
          {
            setState(829);
            match(T__57);
          }
          break;
        case T__61:
          enterOuterAlt(_localctx, 31);
          {
            setState(830);
            match(T__61);
          }
          break;
        case T__37:
          enterOuterAlt(_localctx, 32);
          {
            setState(831);
            match(T__37);
          }
          break;
        case T__48:
          enterOuterAlt(_localctx, 33);
          {
            setState(832);
            match(T__48);
          }
          break;
        case T__55:
          enterOuterAlt(_localctx, 34);
          {
            setState(833);
            match(T__55);
          }
          break;
        case T__46:
          enterOuterAlt(_localctx, 35);
          {
            setState(834);
            match(T__46);
          }
          break;
        case T__41:
          enterOuterAlt(_localctx, 36);
          {
            setState(835);
            match(T__41);
          }
          break;
        case T__66:
          enterOuterAlt(_localctx, 37);
          {
            setState(836);
            match(T__66);
          }
          break;
        case T__47:
          enterOuterAlt(_localctx, 38);
          {
            setState(837);
            match(T__47);
          }
          break;
        case T__60:
          enterOuterAlt(_localctx, 39);
          {
            setState(838);
            match(T__60);
          }
          break;
        case T__49:
          enterOuterAlt(_localctx, 40);
          {
            setState(839);
            match(T__49);
          }
          break;
        case T__30:
          enterOuterAlt(_localctx, 41);
          {
            setState(840);
            match(T__30);
          }
          break;
        case T__59:
          enterOuterAlt(_localctx, 42);
          {
            setState(841);
            match(T__59);
          }
          break;
        case T__52:
          enterOuterAlt(_localctx, 43);
          {
            setState(842);
            match(T__52);
          }
          break;
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
          enterOuterAlt(_localctx, 44);
          {
            setState(843);
            argumentNameKeyword();
          }
          break;
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
          enterOuterAlt(_localctx, 45);
          {
            setState(844);
            bufferRelatedType();
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
  public static class OtherOrCommaContext extends ParserRuleContext {
    public OtherContext other() {
      return getRuleContext(OtherContext.class, 0);
    }

    public OtherOrCommaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_otherOrComma;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterOtherOrComma(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitOtherOrComma(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitOtherOrComma(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OtherOrCommaContext otherOrComma() throws RecognitionException {
    OtherOrCommaContext _localctx = new OtherOrCommaContext(_ctx, getState());
    enterRule(_localctx, 202, RULE_otherOrComma);
    try {
      setState(849);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case T__7:
        case T__8:
        case T__9:
        case T__10:
        case T__11:
        case T__12:
        case T__13:
        case T__14:
        case T__15:
        case T__16:
        case T__17:
        case T__18:
        case T__19:
        case T__20:
        case T__21:
        case T__22:
        case T__23:
        case T__24:
        case T__27:
        case T__28:
        case T__29:
        case T__30:
        case T__31:
        case T__32:
        case T__33:
        case T__34:
        case T__37:
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
        case T__52:
        case T__53:
        case T__54:
        case T__55:
        case T__56:
        case T__57:
        case T__58:
        case T__59:
        case T__60:
        case T__61:
        case T__62:
        case T__63:
        case T__64:
        case T__65:
        case T__66:
        case T__67:
        case T__68:
        case T__69:
        case T__70:
        case T__71:
        case T__72:
        case T__73:
        case T__74:
        case T__75:
        case T__76:
        case T__77:
        case T__78:
        case T__79:
        case T__80:
        case INTEGER_WEBIDL:
        case DECIMAL_WEBIDL:
        case IDENTIFIER_WEBIDL:
        case STRING_WEBIDL:
        case OTHER_WEBIDL:
          enterOuterAlt(_localctx, 1);
          {
            setState(847);
            other();
          }
          break;
        case T__40:
          enterOuterAlt(_localctx, 2);
          {
            setState(848);
            match(T__40);
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
  public static class IdentifierListContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public IdentifiersContext identifiers() {
      return getRuleContext(IdentifiersContext.class, 0);
    }

    public IdentifierListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_identifierList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterIdentifierList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitIdentifierList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitIdentifierList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdentifierListContext identifierList() throws RecognitionException {
    IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
    enterRule(_localctx, 204, RULE_identifierList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(851);
        match(IDENTIFIER_WEBIDL);
        setState(852);
        identifiers();
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
  public static class IdentifiersContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public IdentifiersContext identifiers() {
      return getRuleContext(IdentifiersContext.class, 0);
    }

    public IdentifiersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_identifiers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterIdentifiers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitIdentifiers(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitIdentifiers(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdentifiersContext identifiers() throws RecognitionException {
    IdentifiersContext _localctx = new IdentifiersContext(_ctx, getState());
    enterRule(_localctx, 206, RULE_identifiers);
    try {
      setState(858);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(854);
            match(T__40);
            setState(855);
            match(IDENTIFIER_WEBIDL);
            setState(856);
            identifiers();
          }
          break;
        case T__39:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ExtendedAttributeNoArgsContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public ExtendedAttributeNoArgsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeNoArgs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeNoArgs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeNoArgs(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeNoArgs(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeNoArgsContext extendedAttributeNoArgs()
      throws RecognitionException {
    ExtendedAttributeNoArgsContext _localctx = new ExtendedAttributeNoArgsContext(_ctx, getState());
    enterRule(_localctx, 208, RULE_extendedAttributeNoArgs);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(860);
        match(IDENTIFIER_WEBIDL);
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
  public static class ExtendedAttributeArgListContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public ExtendedAttributeArgListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeArgList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeArgList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeArgList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeArgList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeArgListContext extendedAttributeArgList()
      throws RecognitionException {
    ExtendedAttributeArgListContext _localctx =
        new ExtendedAttributeArgListContext(_ctx, getState());
    enterRule(_localctx, 210, RULE_extendedAttributeArgList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(862);
        match(IDENTIFIER_WEBIDL);
        setState(863);
        match(T__38);
        setState(864);
        argumentList();
        setState(865);
        match(T__39);
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
  public static class ExtendedAttributeIdentContext extends ParserRuleContext {
    public List<TerminalNode> IDENTIFIER_WEBIDL() {
      return getTokens(WebIDLParser.IDENTIFIER_WEBIDL);
    }

    public TerminalNode IDENTIFIER_WEBIDL(int i) {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, i);
    }

    public ExtendedAttributeIdentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeIdent;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeIdent(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeIdent(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeIdent(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeIdentContext extendedAttributeIdent() throws RecognitionException {
    ExtendedAttributeIdentContext _localctx = new ExtendedAttributeIdentContext(_ctx, getState());
    enterRule(_localctx, 212, RULE_extendedAttributeIdent);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(867);
        match(IDENTIFIER_WEBIDL);
        setState(868);
        match(T__29);
        setState(869);
        match(IDENTIFIER_WEBIDL);
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
  public static class ExtendedAttributeIdentListContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public IdentifierListContext identifierList() {
      return getRuleContext(IdentifierListContext.class, 0);
    }

    public ExtendedAttributeIdentListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeIdentList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeIdentList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeIdentList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeIdentList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeIdentListContext extendedAttributeIdentList()
      throws RecognitionException {
    ExtendedAttributeIdentListContext _localctx =
        new ExtendedAttributeIdentListContext(_ctx, getState());
    enterRule(_localctx, 214, RULE_extendedAttributeIdentList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(871);
        match(IDENTIFIER_WEBIDL);
        setState(872);
        match(T__29);
        setState(873);
        match(T__38);
        setState(874);
        identifierList();
        setState(875);
        match(T__39);
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
  public static class ExtendedAttributeNamedArgListContext extends ParserRuleContext {
    public List<TerminalNode> IDENTIFIER_WEBIDL() {
      return getTokens(WebIDLParser.IDENTIFIER_WEBIDL);
    }

    public TerminalNode IDENTIFIER_WEBIDL(int i) {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, i);
    }

    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public ExtendedAttributeNamedArgListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeNamedArgList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeNamedArgList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeNamedArgList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeNamedArgList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeNamedArgListContext extendedAttributeNamedArgList()
      throws RecognitionException {
    ExtendedAttributeNamedArgListContext _localctx =
        new ExtendedAttributeNamedArgListContext(_ctx, getState());
    enterRule(_localctx, 216, RULE_extendedAttributeNamedArgList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(877);
        match(IDENTIFIER_WEBIDL);
        setState(878);
        match(T__29);
        setState(879);
        match(IDENTIFIER_WEBIDL);
        setState(880);
        match(T__38);
        setState(881);
        argumentList();
        setState(882);
        match(T__39);
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
  public static class ExtendedAttributeStringContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public ExtendedAttributeStringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeString;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeString(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeString(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeString(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeStringContext extendedAttributeString()
      throws RecognitionException {
    ExtendedAttributeStringContext _localctx = new ExtendedAttributeStringContext(_ctx, getState());
    enterRule(_localctx, 218, RULE_extendedAttributeString);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(884);
        match(IDENTIFIER_WEBIDL);
        setState(885);
        match(T__29);
        setState(886);
        match(STRING_WEBIDL);
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
  public static class ExtendedAttributeStringListContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER_WEBIDL() {
      return getToken(WebIDLParser.IDENTIFIER_WEBIDL, 0);
    }

    public StringListContext stringList() {
      return getRuleContext(StringListContext.class, 0);
    }

    public ExtendedAttributeStringListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendedAttributeStringList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).enterExtendedAttributeStringList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener)
        ((WebIDLListener) listener).exitExtendedAttributeStringList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitExtendedAttributeStringList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExtendedAttributeStringListContext extendedAttributeStringList()
      throws RecognitionException {
    ExtendedAttributeStringListContext _localctx =
        new ExtendedAttributeStringListContext(_ctx, getState());
    enterRule(_localctx, 220, RULE_extendedAttributeStringList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(888);
        match(IDENTIFIER_WEBIDL);
        setState(889);
        match(T__29);
        setState(890);
        match(T__38);
        setState(891);
        stringList();
        setState(892);
        match(T__39);
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
  public static class StringListContext extends ParserRuleContext {
    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public StringsContext strings() {
      return getRuleContext(StringsContext.class, 0);
    }

    public StringListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterStringList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStringList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStringList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringListContext stringList() throws RecognitionException {
    StringListContext _localctx = new StringListContext(_ctx, getState());
    enterRule(_localctx, 222, RULE_stringList);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(894);
        match(STRING_WEBIDL);
        setState(895);
        strings();
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
  public static class StringsContext extends ParserRuleContext {
    public TerminalNode STRING_WEBIDL() {
      return getToken(WebIDLParser.STRING_WEBIDL, 0);
    }

    public StringsContext strings() {
      return getRuleContext(StringsContext.class, 0);
    }

    public StringsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_strings;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).enterStrings(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof WebIDLListener) ((WebIDLListener) listener).exitStrings(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof WebIDLVisitor)
        return ((WebIDLVisitor<? extends T>) visitor).visitStrings(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringsContext strings() throws RecognitionException {
    StringsContext _localctx = new StringsContext(_ctx, getState());
    enterRule(_localctx, 224, RULE_strings);
    try {
      setState(901);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__40:
          enterOuterAlt(_localctx, 1);
          {
            setState(897);
            match(T__40);
            setState(898);
            match(STRING_WEBIDL);
            setState(899);
            strings();
          }
          break;
        case T__39:
          enterOuterAlt(_localctx, 2);
          {
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

  public static final String _serializedATN =
      "\u0004\u0001X\u0388\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
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
          + "F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"
          + "K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"
          + "P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"
          + "U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"
          + "Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"
          + "_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"
          + "d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007h\u0002"
          + "i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007m\u0002"
          + "n\u0007n\u0002o\u0007o\u0002p\u0007p\u0001\u0000\u0001\u0000\u0001\u0000"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"
          + "\u00eb\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0002\u0001\u0002\u0003\u0002\u00f4\b\u0002\u0001\u0003\u0001\u0003"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00fc\b\u0004"
          + "\u0001\u0005\u0001\u0005\u0003\u0005\u0100\b\u0005\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0110"
          + "\b\b\u0001\t\u0001\t\u0003\t\u0114\b\t\u0001\n\u0001\n\u0001\n\u0001\n"
          + "\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"
          + "\u000b\u0003\u000b\u0121\b\u000b\u0001\f\u0001\f\u0003\f\u0125\b\f\u0001"
          + "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u012c\b\r\u0001\u000e\u0001"
          + "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"
          + "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0139\b\u000e\u0001"
          + "\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u013e\b\u000f\u0001\u0010\u0001"
          + "\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"
          + "\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u014c"
          + "\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0003\u0012\u0154\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"
          + "\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"
          + "\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0163\b\u0014\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u016a"
          + "\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u016e\b\u0016\u0001\u0017"
          + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
          + "\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u017a\b\u0018\u0001\u0019"
          + "\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b"
          + "\u0182\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"
          + "\u0001\u001d\u0003\u001d\u018a\b\u001d\u0001\u001e\u0001\u001e\u0001\u001f"
          + "\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001"
          + "!\u0003!\u0198\b!\u0001\"\u0001\"\u0001#\u0001#\u0003#\u019e\b#\u0001"
          + "$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u01a7\b$\u0001%\u0001"
          + "%\u0003%\u01ab\b%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001("
          + "\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0003"
          + "*\u01bd\b*\u0001+\u0001+\u0003+\u01c1\b+\u0001,\u0001,\u0001-\u0001-\u0001"
          + "-\u0001-\u0003-\u01c9\b-\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u01d0"
          + "\b.\u0001/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00010\u00010\u0001"
          + "0\u00010\u00010\u00030\u01de\b0\u00011\u00011\u00031\u01e2\b1\u00012\u0001"
          + "2\u00032\u01e6\b2\u00013\u00013\u00013\u00013\u00013\u00013\u00014\u0001"
          + "4\u00014\u00015\u00015\u00015\u00015\u00015\u00035\u01f6\b5\u00016\u0001"
          + "6\u00016\u00017\u00017\u00017\u00017\u00037\u01ff\b7\u00018\u00018\u0001"
          + "8\u00018\u00018\u00018\u00018\u00019\u00019\u00019\u00039\u020b\b9\u0001"
          + ":\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"
          + ";\u0001;\u0001;\u0001;\u0003;\u021b\b;\u0001<\u0001<\u0001=\u0001=\u0001"
          + "=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001>\u0001>\u0001?\u0001?\u0001"
          + "?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001"
          + "@\u0001A\u0001A\u0001A\u0001A\u0001A\u0003A\u023b\bA\u0001B\u0001B\u0001"
          + "B\u0001B\u0003B\u0241\bB\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"
          + "C\u0001C\u0001D\u0001D\u0001D\u0001D\u0003D\u024f\bD\u0001E\u0001E\u0001"
          + "E\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"
          + "F\u0003F\u025e\bF\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"
          + "H\u0001H\u0001H\u0003H\u026a\bH\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"
          + "I\u0001I\u0001J\u0001J\u0001J\u0001K\u0001K\u0001K\u0003K\u0279\bK\u0001"
          + "L\u0001L\u0001L\u0003L\u027e\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"
          + "M\u0001M\u0001M\u0001N\u0001N\u0001N\u0001N\u0001N\u0001O\u0001O\u0001"
          + "O\u0001O\u0003O\u0291\bO\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0003"
          + "Q\u0299\bQ\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001S\u0001"
          + "S\u0001S\u0001S\u0001S\u0001S\u0003S\u02a8\bS\u0001T\u0001T\u0001T\u0001"
          + "T\u0001T\u0003T\u02af\bT\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"
          + "U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"
          + "U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"
          + "U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0003"
          + "U\u02d5\bU\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0003V\u02de"
          + "\bV\u0001W\u0001W\u0001W\u0003W\u02e3\bW\u0001X\u0001X\u0001Y\u0001Y\u0001"
          + "Y\u0003Y\u02ea\bY\u0001Z\u0001Z\u0001Z\u0003Z\u02ef\bZ\u0001[\u0001[\u0003"
          + "[\u02f3\b[\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001]\u0001^\u0001"
          + "^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0003_\u0305\b_\u0001"
          + "`\u0001`\u0001a\u0001a\u0001a\u0001a\u0001a\u0001a\u0003a\u030f\ba\u0001"
          + "b\u0001b\u0001b\u0001b\u0001b\u0003b\u0316\bb\u0001c\u0001c\u0001c\u0001"
          + "c\u0001c\u0001c\u0001c\u0003c\u031f\bc\u0001d\u0001d\u0001d\u0001d\u0001"
          + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
          + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
          + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
          + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
          + "d\u0003d\u034e\bd\u0001e\u0001e\u0003e\u0352\be\u0001f\u0001f\u0001f\u0001"
          + "g\u0001g\u0001g\u0001g\u0003g\u035b\bg\u0001h\u0001h\u0001i\u0001i\u0001"
          + "i\u0001i\u0001i\u0001j\u0001j\u0001j\u0001j\u0001k\u0001k\u0001k\u0001"
          + "k\u0001k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001"
          + "m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001"
          + "o\u0001o\u0001o\u0001p\u0001p\u0001p\u0001p\u0003p\u0386\bp\u0001p\u0000"
          + "\u0000q\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"
          + "\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"
          + "\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"
          + "\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"
          + "\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"
          + "\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"
          + "\u0000\b\u0001\u0000\u0001\u0019\u0001\u0000\u001f \u0002\u0000!#SS\u0002"
          + "\u0000\u0001\u0001\u0013\u0013\u0003\u0000\u0006\u0006\t\t\u0015\u0015"
          + "\u0001\u0000:;\u0001\u0000?A\u0001\u0000EO\u03a7\u0000\u00e2\u0001\u0000"
          + "\u0000\u0000\u0002\u00ea\u0001\u0000\u0000\u0000\u0004\u00f3\u0001\u0000"
          + "\u0000\u0000\u0006\u00f5\u0001\u0000\u0000\u0000\b\u00fb\u0001\u0000\u0000"
          + "\u0000\n\u00ff\u0001\u0000\u0000\u0000\f\u0101\u0001\u0000\u0000\u0000"
          + "\u000e\u0108\u0001\u0000\u0000\u0000\u0010\u010f\u0001\u0000\u0000\u0000"
          + "\u0012\u0113\u0001\u0000\u0000\u0000\u0014\u0115\u0001\u0000\u0000\u0000"
          + "\u0016\u0120\u0001\u0000\u0000\u0000\u0018\u0124\u0001\u0000\u0000\u0000"
          + "\u001a\u012b\u0001\u0000\u0000\u0000\u001c\u0138\u0001\u0000\u0000\u0000"
          + "\u001e\u013d\u0001\u0000\u0000\u0000 \u013f\u0001\u0000\u0000\u0000\""
          + "\u014b\u0001\u0000\u0000\u0000$\u0153\u0001\u0000\u0000\u0000&\u0155\u0001"
          + "\u0000\u0000\u0000(\u0162\u0001\u0000\u0000\u0000*\u0169\u0001\u0000\u0000"
          + "\u0000,\u016d\u0001\u0000\u0000\u0000.\u016f\u0001\u0000\u0000\u00000"
          + "\u0179\u0001\u0000\u0000\u00002\u017b\u0001\u0000\u0000\u00004\u017d\u0001"
          + "\u0000\u0000\u00006\u0181\u0001\u0000\u0000\u00008\u0183\u0001\u0000\u0000"
          + "\u0000:\u0189\u0001\u0000\u0000\u0000<\u018b\u0001\u0000\u0000\u0000>"
          + "\u018d\u0001\u0000\u0000\u0000@\u0190\u0001\u0000\u0000\u0000B\u0197\u0001"
          + "\u0000\u0000\u0000D\u0199\u0001\u0000\u0000\u0000F\u019d\u0001\u0000\u0000"
          + "\u0000H\u01a6\u0001\u0000\u0000\u0000J\u01aa\u0001\u0000\u0000\u0000L"
          + "\u01ac\u0001\u0000\u0000\u0000N\u01af\u0001\u0000\u0000\u0000P\u01b2\u0001"
          + "\u0000\u0000\u0000R\u01b4\u0001\u0000\u0000\u0000T\u01bc\u0001\u0000\u0000"
          + "\u0000V\u01c0\u0001\u0000\u0000\u0000X\u01c2\u0001\u0000\u0000\u0000Z"
          + "\u01c8\u0001\u0000\u0000\u0000\\\u01cf\u0001\u0000\u0000\u0000^\u01d1"
          + "\u0001\u0000\u0000\u0000`\u01dd\u0001\u0000\u0000\u0000b\u01e1\u0001\u0000"
          + "\u0000\u0000d\u01e5\u0001\u0000\u0000\u0000f\u01e7\u0001\u0000\u0000\u0000"
          + "h\u01ed\u0001\u0000\u0000\u0000j\u01f5\u0001\u0000\u0000\u0000l\u01f7"
          + "\u0001\u0000\u0000\u0000n\u01fe\u0001\u0000\u0000\u0000p\u0200\u0001\u0000"
          + "\u0000\u0000r\u020a\u0001\u0000\u0000\u0000t\u020c\u0001\u0000\u0000\u0000"
          + "v\u021a\u0001\u0000\u0000\u0000x\u021c\u0001\u0000\u0000\u0000z\u021e"
          + "\u0001\u0000\u0000\u0000|\u0226\u0001\u0000\u0000\u0000~\u0228\u0001\u0000"
          + "\u0000\u0000\u0080\u022e\u0001\u0000\u0000\u0000\u0082\u023a\u0001\u0000"
          + "\u0000\u0000\u0084\u0240\u0001\u0000\u0000\u0000\u0086\u0242\u0001\u0000"
          + "\u0000\u0000\u0088\u024e\u0001\u0000\u0000\u0000\u008a\u0250\u0001\u0000"
          + "\u0000\u0000\u008c\u025d\u0001\u0000\u0000\u0000\u008e\u025f\u0001\u0000"
          + "\u0000\u0000\u0090\u0269\u0001\u0000\u0000\u0000\u0092\u026b\u0001\u0000"
          + "\u0000\u0000\u0094\u0272\u0001\u0000\u0000\u0000\u0096\u0278\u0001\u0000"
          + "\u0000\u0000\u0098\u027d\u0001\u0000\u0000\u0000\u009a\u027f\u0001\u0000"
          + "\u0000\u0000\u009c\u0287\u0001\u0000\u0000\u0000\u009e\u0290\u0001\u0000"
          + "\u0000\u0000\u00a0\u0292\u0001\u0000\u0000\u0000\u00a2\u0298\u0001\u0000"
          + "\u0000\u0000\u00a4\u029a\u0001\u0000\u0000\u0000\u00a6\u02a7\u0001\u0000"
          + "\u0000\u0000\u00a8\u02ae\u0001\u0000\u0000\u0000\u00aa\u02d4\u0001\u0000"
          + "\u0000\u0000\u00ac\u02dd\u0001\u0000\u0000\u0000\u00ae\u02e2\u0001\u0000"
          + "\u0000\u0000\u00b0\u02e4\u0001\u0000\u0000\u0000\u00b2\u02e9\u0001\u0000"
          + "\u0000\u0000\u00b4\u02ee\u0001\u0000\u0000\u0000\u00b6\u02f2\u0001\u0000"
          + "\u0000\u0000\u00b8\u02f4\u0001\u0000\u0000\u0000\u00ba\u02f6\u0001\u0000"
          + "\u0000\u0000\u00bc\u02fb\u0001\u0000\u0000\u0000\u00be\u0304\u0001\u0000"
          + "\u0000\u0000\u00c0\u0306\u0001\u0000\u0000\u0000\u00c2\u030e\u0001\u0000"
          + "\u0000\u0000\u00c4\u0315\u0001\u0000\u0000\u0000\u00c6\u031e\u0001\u0000"
          + "\u0000\u0000\u00c8\u034d\u0001\u0000\u0000\u0000\u00ca\u0351\u0001\u0000"
          + "\u0000\u0000\u00cc\u0353\u0001\u0000\u0000\u0000\u00ce\u035a\u0001\u0000"
          + "\u0000\u0000\u00d0\u035c\u0001\u0000\u0000\u0000\u00d2\u035e\u0001\u0000"
          + "\u0000\u0000\u00d4\u0363\u0001\u0000\u0000\u0000\u00d6\u0367\u0001\u0000"
          + "\u0000\u0000\u00d8\u036d\u0001\u0000\u0000\u0000\u00da\u0374\u0001\u0000"
          + "\u0000\u0000\u00dc\u0378\u0001\u0000\u0000\u0000\u00de\u037e\u0001\u0000"
          + "\u0000\u0000\u00e0\u0385\u0001\u0000\u0000\u0000\u00e2\u00e3\u0003\u0002"
          + "\u0001\u0000\u00e3\u00e4\u0005\u0000\u0000\u0001\u00e4\u0001\u0001\u0000"
          + "\u0000\u0000\u00e5\u00e6\u0003\u00c2a\u0000\u00e6\u00e7\u0003\u0004\u0002"
          + "\u0000\u00e7\u00e8\u0003\u0002\u0001\u0000\u00e8\u00eb\u0001\u0000\u0000"
          + "\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e5\u0001\u0000\u0000"
          + "\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u0003\u0001\u0000\u0000"
          + "\u0000\u00ec\u00f4\u0003\b\u0004\u0000\u00ed\u00f4\u0003\u0080@\u0000"
          + "\u00ee\u00f4\u0003\u000e\u0007\u0000\u00ef\u00f4\u0003\u0086C\u0000\u00f0"
          + "\u00f4\u0003\u0092I\u0000\u00f1\u00f4\u0003\u009cN\u0000\u00f2\u00f4\u0003"
          + "&\u0013\u0000\u00f3\u00ec\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001\u0000"
          + "\u0000\u0000\u00f3\u00ee\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000"
          + "\u0000\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"
          + "\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u0005\u0001\u0000"
          + "\u0000\u0000\u00f5\u00f6\u0007\u0000\u0000\u0000\u00f6\u0007\u0001\u0000"
          + "\u0000\u0000\u00f7\u00f8\u0005\u0003\u0000\u0000\u00f8\u00fc\u0003(\u0014"
          + "\u0000\u00f9\u00fa\u0005\f\u0000\u0000\u00fa\u00fc\u0003\n\u0005\u0000"
          + "\u00fb\u00f7\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"
          + "\u00fc\t\u0001\u0000\u0000\u0000\u00fd\u0100\u0003\f\u0006\u0000\u00fe"
          + "\u0100\u0003 \u0010\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u00fe"
          + "\u0001\u0000\u0000\u0000\u0100\u000b\u0001\u0000\u0000\u0000\u0101\u0102"
          + "\u0005T\u0000\u0000\u0102\u0103\u0003\u001e\u000f\u0000\u0103\u0104\u0005"
          + "\u001a\u0000\u0000\u0104\u0105\u0003\u0016\u000b\u0000\u0105\u0106\u0005"
          + "\u001b\u0000\u0000\u0106\u0107\u0005\u001c\u0000\u0000\u0107\r\u0001\u0000"
          + "\u0000\u0000\u0108\u0109\u0005\u0011\u0000\u0000\u0109\u010a\u0003\u0010"
          + "\b\u0000\u010a\u000f\u0001\u0000\u0000\u0000\u010b\u010c\u0005\f\u0000"
          + "\u0000\u010c\u0110\u0003\u0012\t\u0000\u010d\u0110\u0003\u008eG\u0000"
          + "\u010e\u0110\u0003\u0080@\u0000\u010f\u010b\u0001\u0000\u0000\u0000\u010f"
          + "\u010d\u0001\u0000\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u0110"
          + "\u0011\u0001\u0000\u0000\u0000\u0111\u0114\u0003\u0014\n\u0000\u0112\u0114"
          + "\u0003 \u0010\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0112\u0001"
          + "\u0000\u0000\u0000\u0114\u0013\u0001\u0000\u0000\u0000\u0115\u0116\u0005"
          + "T\u0000\u0000\u0116\u0117\u0005\u001a\u0000\u0000\u0117\u0118\u0003\u001a"
          + "\r\u0000\u0118\u0119\u0005\u001b\u0000\u0000\u0119\u011a\u0005\u001c\u0000"
          + "\u0000\u011a\u0015\u0001\u0000\u0000\u0000\u011b\u011c\u0003\u00c2a\u0000"
          + "\u011c\u011d\u0003\u0018\f\u0000\u011d\u011e\u0003\u0016\u000b\u0000\u011e"
          + "\u0121\u0001\u0000\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120"
          + "\u011b\u0001\u0000\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121"
          + "\u0017\u0001\u0000\u0000\u0000\u0122\u0125\u0003\u001c\u000e\u0000\u0123"
          + "\u0125\u0003f3\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0123\u0001"
          + "\u0000\u0000\u0000\u0125\u0019\u0001\u0000\u0000\u0000\u0126\u0127\u0003"
          + "\u00c2a\u0000\u0127\u0128\u0003\u001c\u000e\u0000\u0128\u0129\u0003\u001a"
          + "\r\u0000\u0129\u012c\u0001\u0000\u0000\u0000\u012a\u012c\u0001\u0000\u0000"
          + "\u0000\u012b\u0126\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000"
          + "\u0000\u012c\u001b\u0001\u0000\u0000\u0000\u012d\u0139\u0003.\u0017\u0000"
          + "\u012e\u0139\u0003J%\u0000\u012f\u0139\u0003h4\u0000\u0130\u0139\u0003"
          + "l6\u0000\u0131\u0139\u0003p8\u0000\u0132\u0139\u0003t:\u0000\u0133\u0139"
          + "\u00038\u001c\u0000\u0134\u0139\u0003<\u001e\u0000\u0135\u0139\u0003x"
          + "<\u0000\u0136\u0139\u0003|>\u0000\u0137\u0139\u0003>\u001f\u0000\u0138"
          + "\u012d\u0001\u0000\u0000\u0000\u0138\u012e\u0001\u0000\u0000\u0000\u0138"
          + "\u012f\u0001\u0000\u0000\u0000\u0138\u0130\u0001\u0000\u0000\u0000\u0138"
          + "\u0131\u0001\u0000\u0000\u0000\u0138\u0132\u0001\u0000\u0000\u0000\u0138"
          + "\u0133\u0001\u0000\u0000\u0000\u0138\u0134\u0001\u0000\u0000\u0000\u0138"
          + "\u0135\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138"
          + "\u0137\u0001\u0000\u0000\u0000\u0139\u001d\u0001\u0000\u0000\u0000\u013a"
          + "\u013b\u0005\u001d\u0000\u0000\u013b\u013e\u0005T\u0000\u0000\u013c\u013e"
          + "\u0001\u0000\u0000\u0000\u013d\u013a\u0001\u0000\u0000\u0000\u013d\u013c"
          + "\u0001\u0000\u0000\u0000\u013e\u001f\u0001\u0000\u0000\u0000\u013f\u0140"
          + "\u0005\u000f\u0000\u0000\u0140\u0141\u0005T\u0000\u0000\u0141\u0142\u0005"
          + "\u001a\u0000\u0000\u0142\u0143\u0003\"\u0011\u0000\u0143\u0144\u0005\u001b"
          + "\u0000\u0000\u0144\u0145\u0005\u001c\u0000\u0000\u0145!\u0001\u0000\u0000"
          + "\u0000\u0146\u0147\u0003\u00c2a\u0000\u0147\u0148\u0003$\u0012\u0000\u0148"
          + "\u0149\u0003\"\u0011\u0000\u0149\u014c\u0001\u0000\u0000\u0000\u014a\u014c"
          + "\u0001\u0000\u0000\u0000\u014b\u0146\u0001\u0000\u0000\u0000\u014b\u014a"
          + "\u0001\u0000\u0000\u0000\u014c#\u0001\u0000\u0000\u0000\u014d\u0154\u0003"
          + ".\u0017\u0000\u014e\u0154\u0003L&\u0000\u014f\u0154\u0003h4\u0000\u0150"
          + "\u0151\u0003F#\u0000\u0151\u0152\u0003@ \u0000\u0152\u0154\u0001\u0000"
          + "\u0000\u0000\u0153\u014d\u0001\u0000\u0000\u0000\u0153\u014e\u0001\u0000"
          + "\u0000\u0000\u0153\u014f\u0001\u0000\u0000\u0000\u0153\u0150\u0001\u0000"
          + "\u0000\u0000\u0154%\u0001\u0000\u0000\u0000\u0155\u0156\u0005T\u0000\u0000"
          + "\u0156\u0157\u0005\n\u0000\u0000\u0157\u0158\u0005T\u0000\u0000\u0158"
          + "\u0159\u0005\u001c\u0000\u0000\u0159\'\u0001\u0000\u0000\u0000\u015a\u0163"
          + "\u0003\u009aM\u0000\u015b\u015c\u0005\f\u0000\u0000\u015c\u015d\u0005"
          + "T\u0000\u0000\u015d\u015e\u0005\u001a\u0000\u0000\u015e\u015f\u0003*\u0015"
          + "\u0000\u015f\u0160\u0005\u001b\u0000\u0000\u0160\u0161\u0005\u001c\u0000"
          + "\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u015a\u0001\u0000\u0000"
          + "\u0000\u0162\u015b\u0001\u0000\u0000\u0000\u0163)\u0001\u0000\u0000\u0000"
          + "\u0164\u0165\u0003\u00c2a\u0000\u0165\u0166\u0003,\u0016\u0000\u0166\u0167"
          + "\u0003*\u0015\u0000\u0167\u016a\u0001\u0000\u0000\u0000\u0168\u016a\u0001"
          + "\u0000\u0000\u0000\u0169\u0164\u0001\u0000\u0000\u0000\u0169\u0168\u0001"
          + "\u0000\u0000\u0000\u016a+\u0001\u0000\u0000\u0000\u016b\u016e\u0003.\u0017"
          + "\u0000\u016c\u016e\u0003L&\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d"
          + "\u016c\u0001\u0000\u0000\u0000\u016e-\u0001\u0000\u0000\u0000\u016f\u0170"
          + "\u0005\u0004\u0000\u0000\u0170\u0171\u00036\u001b\u0000\u0171\u0172\u0005"
          + "T\u0000\u0000\u0172\u0173\u0005\u001e\u0000\u0000\u0173\u0174\u00030\u0018"
          + "\u0000\u0174\u0175\u0005\u001c\u0000\u0000\u0175/\u0001\u0000\u0000\u0000"
          + "\u0176\u017a\u00032\u0019\u0000\u0177\u017a\u00034\u001a\u0000\u0178\u017a"
          + "\u0005R\u0000\u0000\u0179\u0176\u0001\u0000\u0000\u0000\u0179\u0177\u0001"
          + "\u0000\u0000\u0000\u0179\u0178\u0001\u0000\u0000\u0000\u017a1\u0001\u0000"
          + "\u0000\u0000\u017b\u017c\u0007\u0001\u0000\u0000\u017c3\u0001\u0000\u0000"
          + "\u0000\u017d\u017e\u0007\u0002\u0000\u0000\u017e5\u0001\u0000\u0000\u0000"
          + "\u017f\u0182\u0003\u00acV\u0000\u0180\u0182\u0005T\u0000\u0000\u0181\u017f"
          + "\u0001\u0000\u0000\u0000\u0181\u0180\u0001\u0000\u0000\u0000\u01827\u0001"
          + "\u0000\u0000\u0000\u0183\u0184\u0005\u0012\u0000\u0000\u0184\u0185\u0003"
          + ":\u001d\u0000\u01859\u0001\u0000\u0000\u0000\u0186\u018a\u0003@ \u0000"
          + "\u0187\u018a\u0003z=\u0000\u0188\u018a\u0003~?\u0000\u0189\u0186\u0001"
          + "\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u0188\u0001"
          + "\u0000\u0000\u0000\u018a;\u0001\u0000\u0000\u0000\u018b\u018c\u0003@ "
          + "\u0000\u018c=\u0001\u0000\u0000\u0000\u018d\u018e\u0005\u000b\u0000\u0000"
          + "\u018e\u018f\u0003@ \u0000\u018f?\u0001\u0000\u0000\u0000\u0190\u0191"
          + "\u0005\u0002\u0000\u0000\u0191\u0192\u0003\u00a0P\u0000\u0192\u0193\u0003"
          + "B!\u0000\u0193\u0194\u0005\u001c\u0000\u0000\u0194A\u0001\u0000\u0000"
          + "\u0000\u0195\u0198\u0003D\"\u0000\u0196\u0198\u0005T\u0000\u0000\u0197"
          + "\u0195\u0001\u0000\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0198"
          + "C\u0001\u0000\u0000\u0000\u0199\u019a\u0007\u0003\u0000\u0000\u019aE\u0001"
          + "\u0000\u0000\u0000\u019b\u019e\u0005\u0012\u0000\u0000\u019c\u019e\u0001"
          + "\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019c\u0001"
          + "\u0000\u0000\u0000\u019eG\u0001\u0000\u0000\u0000\u019f\u01a7\u00030\u0018"
          + "\u0000\u01a0\u01a7\u0005U\u0000\u0000\u01a1\u01a2\u0005$\u0000\u0000\u01a2"
          + "\u01a7\u0005%\u0000\u0000\u01a3\u01a4\u0005\u001a\u0000\u0000\u01a4\u01a7"
          + "\u0005\u001b\u0000\u0000\u01a5\u01a7\u0005&\u0000\u0000\u01a6\u019f\u0001"
          + "\u0000\u0000\u0000\u01a6\u01a0\u0001\u0000\u0000\u0000\u01a6\u01a1\u0001"
          + "\u0000\u0000\u0000\u01a6\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a5\u0001"
          + "\u0000\u0000\u0000\u01a7I\u0001\u0000\u0000\u0000\u01a8\u01ab\u0003L&"
          + "\u0000\u01a9\u01ab\u0003N\'\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"
          + "\u01aa\u01a9\u0001\u0000\u0000\u0000\u01abK\u0001\u0000\u0000\u0000\u01ac"
          + "\u01ad\u0003\u009eO\u0000\u01ad\u01ae\u0003R)\u0000\u01aeM\u0001\u0000"
          + "\u0000\u0000\u01af\u01b0\u0003P(\u0000\u01b0\u01b1\u0003L&\u0000\u01b1"
          + "O\u0001\u0000\u0000\u0000\u01b2\u01b3\u0007\u0004\u0000\u0000\u01b3Q\u0001"
          + "\u0000\u0000\u0000\u01b4\u01b5\u0003T*\u0000\u01b5\u01b6\u0005\'\u0000"
          + "\u0000\u01b6\u01b7\u0003Z-\u0000\u01b7\u01b8\u0005(\u0000\u0000\u01b8"
          + "\u01b9\u0005\u001c\u0000\u0000\u01b9S\u0001\u0000\u0000\u0000\u01ba\u01bd"
          + "\u0003V+\u0000\u01bb\u01bd\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000"
          + "\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000\u01bdU\u0001\u0000\u0000"
          + "\u0000\u01be\u01c1\u0003X,\u0000\u01bf\u01c1\u0005T\u0000\u0000\u01c0"
          + "\u01be\u0001\u0000\u0000\u0000\u01c0\u01bf\u0001\u0000\u0000\u0000\u01c1"
          + "W\u0001\u0000\u0000\u0000\u01c2\u01c3\u0005\n\u0000\u0000\u01c3Y\u0001"
          + "\u0000\u0000\u0000\u01c4\u01c5\u0003^/\u0000\u01c5\u01c6\u0003\\.\u0000"
          + "\u01c6\u01c9\u0001\u0000\u0000\u0000\u01c7\u01c9\u0001\u0000\u0000\u0000"
          + "\u01c8\u01c4\u0001\u0000\u0000\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000"
          + "\u01c9[\u0001\u0000\u0000\u0000\u01ca\u01cb\u0005)\u0000\u0000\u01cb\u01cc"
          + "\u0003^/\u0000\u01cc\u01cd\u0003\\.\u0000\u01cd\u01d0\u0001\u0000\u0000"
          + "\u0000\u01ce\u01d0\u0001\u0000\u0000\u0000\u01cf\u01ca\u0001\u0000\u0000"
          + "\u0000\u01cf\u01ce\u0001\u0000\u0000\u0000\u01d0]\u0001\u0000\u0000\u0000"
          + "\u01d1\u01d2\u0003\u00c2a\u0000\u01d2\u01d3\u0003`0\u0000\u01d3_\u0001"
          + "\u0000\u0000\u0000\u01d4\u01d5\u0005*\u0000\u0000\u01d5\u01d6\u0003\u00a0"
          + "P\u0000\u01d6\u01d7\u0003b1\u0000\u01d7\u01d8\u0003\u0090H\u0000\u01d8"
          + "\u01de\u0001\u0000\u0000\u0000\u01d9\u01da\u0003\u009eO\u0000\u01da\u01db"
          + "\u0003d2\u0000\u01db\u01dc\u0003b1\u0000\u01dc\u01de\u0001\u0000\u0000"
          + "\u0000\u01dd\u01d4\u0001\u0000\u0000\u0000\u01dd\u01d9\u0001\u0000\u0000"
          + "\u0000\u01dea\u0001\u0000\u0000\u0000\u01df\u01e2\u0003\u0006\u0003\u0000"
          + "\u01e0\u01e2\u0005T\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1"
          + "\u01e0\u0001\u0000\u0000\u0000\u01e2c\u0001\u0000\u0000\u0000\u01e3\u01e6"
          + "\u0005+\u0000\u0000\u01e4\u01e6\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001"
          + "\u0000\u0000\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000\u01e6e\u0001\u0000"
          + "\u0000\u0000\u01e7\u01e8\u0005\u0005\u0000\u0000\u01e8\u01e9\u0005\'\u0000"
          + "\u0000\u01e9\u01ea\u0003Z-\u0000\u01ea\u01eb\u0005(\u0000\u0000\u01eb"
          + "\u01ec\u0005\u001c\u0000\u0000\u01ecg\u0001\u0000\u0000\u0000\u01ed\u01ee"
          + "\u0005\u0017\u0000\u0000\u01ee\u01ef\u0003j5\u0000\u01efi\u0001\u0000"
          + "\u0000\u0000\u01f0\u01f1\u0003F#\u0000\u01f1\u01f2\u0003@ \u0000\u01f2"
          + "\u01f6\u0001\u0000\u0000\u0000\u01f3\u01f6\u0003L&\u0000\u01f4\u01f6\u0005"
          + "\u001c\u0000\u0000\u01f5\u01f0\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001"
          + "\u0000\u0000\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f6k\u0001\u0000"
          + "\u0000\u0000\u01f7\u01f8\u0005\u0016\u0000\u0000\u01f8\u01f9\u0003n7\u0000"
          + "\u01f9m\u0001\u0000\u0000\u0000\u01fa\u01fb\u0003F#\u0000\u01fb\u01fc"
          + "\u0003@ \u0000\u01fc\u01ff\u0001\u0000\u0000\u0000\u01fd\u01ff\u0003L"
          + "&\u0000\u01fe\u01fa\u0001\u0000\u0000\u0000\u01fe\u01fd\u0001\u0000\u0000"
          + "\u0000\u01ffo\u0001\u0000\u0000\u0000\u0200\u0201\u0005\r\u0000\u0000"
          + "\u0201\u0202\u0005,\u0000\u0000\u0202\u0203\u0003\u00a0P\u0000\u0203\u0204"
          + "\u0003r9\u0000\u0204\u0205\u0005-\u0000\u0000\u0205\u0206\u0005\u001c"
          + "\u0000\u0000\u0206q\u0001\u0000\u0000\u0000\u0207\u0208\u0005)\u0000\u0000"
          + "\u0208\u020b\u0003\u00a0P\u0000\u0209\u020b\u0001\u0000\u0000\u0000\u020a"
          + "\u0207\u0001\u0000\u0000\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020b"
          + "s\u0001\u0000\u0000\u0000\u020c\u020d\u0005\u0001\u0000\u0000\u020d\u020e"
          + "\u0005\r\u0000\u0000\u020e\u020f\u0005,\u0000\u0000\u020f\u0210\u0003"
          + "\u00a0P\u0000\u0210\u0211\u0003r9\u0000\u0211\u0212\u0005-\u0000\u0000"
          + "\u0212\u0213\u0003v;\u0000\u0213\u0214\u0005\u001c\u0000\u0000\u0214u"
          + "\u0001\u0000\u0000\u0000\u0215\u0216\u0005\'\u0000\u0000\u0216\u0217\u0003"
          + "Z-\u0000\u0217\u0218\u0005(\u0000\u0000\u0218\u021b\u0001\u0000\u0000"
          + "\u0000\u0219\u021b\u0001\u0000\u0000\u0000\u021a\u0215\u0001\u0000\u0000"
          + "\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021bw\u0001\u0000\u0000\u0000"
          + "\u021c\u021d\u0003z=\u0000\u021dy\u0001\u0000\u0000\u0000\u021e\u021f"
          + "\u0005\u000e\u0000\u0000\u021f\u0220\u0005,\u0000\u0000\u0220\u0221\u0003"
          + "\u00a0P\u0000\u0221\u0222\u0005)\u0000\u0000\u0222\u0223\u0003\u00a0P"
          + "\u0000\u0223\u0224\u0005-\u0000\u0000\u0224\u0225\u0005\u001c\u0000\u0000"
          + "\u0225{\u0001\u0000\u0000\u0000\u0226\u0227\u0003~?\u0000\u0227}\u0001"
          + "\u0000\u0000\u0000\u0228\u0229\u0005\u0014\u0000\u0000\u0229\u022a\u0005"
          + ",\u0000\u0000\u022a\u022b\u0003\u00a0P\u0000\u022b\u022c\u0005-\u0000"
          + "\u0000\u022c\u022d\u0005\u001c\u0000\u0000\u022d\u007f\u0001\u0000\u0000"
          + "\u0000\u022e\u022f\u0005\u0010\u0000\u0000\u022f\u0230\u0005T\u0000\u0000"
          + "\u0230\u0231\u0005\u001a\u0000\u0000\u0231\u0232\u0003\u0082A\u0000\u0232"
          + "\u0233\u0005\u001b\u0000\u0000\u0233\u0234\u0005\u001c\u0000\u0000\u0234"
          + "\u0081\u0001\u0000\u0000\u0000\u0235\u0236\u0003\u00c2a\u0000\u0236\u0237"
          + "\u0003\u0084B\u0000\u0237\u0238\u0003\u0082A\u0000\u0238\u023b\u0001\u0000"
          + "\u0000\u0000\u0239\u023b\u0001\u0000\u0000\u0000\u023a\u0235\u0001\u0000"
          + "\u0000\u0000\u023a\u0239\u0001\u0000\u0000\u0000\u023b\u0083\u0001\u0000"
          + "\u0000\u0000\u023c\u0241\u0003L&\u0000\u023d\u023e\u0005\u0012\u0000\u0000"
          + "\u023e\u0241\u0003@ \u0000\u023f\u0241\u0003.\u0017\u0000\u0240\u023c"
          + "\u0001\u0000\u0000\u0000\u0240\u023d\u0001\u0000\u0000\u0000\u0240\u023f"
          + "\u0001\u0000\u0000\u0000\u0241\u0085\u0001\u0000\u0000\u0000\u0242\u0243"
          + "\u0005\u0007\u0000\u0000\u0243\u0244\u0005T\u0000\u0000\u0244\u0245\u0003"
          + "\u001e\u000f\u0000\u0245\u0246\u0005\u001a\u0000\u0000\u0246\u0247\u0003"
          + "\u0088D\u0000\u0247\u0248\u0005\u001b\u0000\u0000\u0248\u0249\u0005\u001c"
          + "\u0000\u0000\u0249\u0087\u0001\u0000\u0000\u0000\u024a\u024b\u0003\u008a"
          + "E\u0000\u024b\u024c\u0003\u0088D\u0000\u024c\u024f\u0001\u0000\u0000\u0000"
          + "\u024d\u024f\u0001\u0000\u0000\u0000\u024e\u024a\u0001\u0000\u0000\u0000"
          + "\u024e\u024d\u0001\u0000\u0000\u0000\u024f\u0089\u0001\u0000\u0000\u0000"
          + "\u0250\u0251\u0003\u00c2a\u0000\u0251\u0252\u0003\u008cF\u0000\u0252\u008b"
          + "\u0001\u0000\u0000\u0000\u0253\u0254\u0005\u0013\u0000\u0000\u0254\u0255"
          + "\u0003\u00a0P\u0000\u0255\u0256\u0005T\u0000\u0000\u0256\u0257\u0005\u001c"
          + "\u0000\u0000\u0257\u025e\u0001\u0000\u0000\u0000\u0258\u0259\u0003\u009e"
          + "O\u0000\u0259\u025a\u0005T\u0000\u0000\u025a\u025b\u0003\u0090H\u0000"
          + "\u025b\u025c\u0005\u001c\u0000\u0000\u025c\u025e\u0001\u0000\u0000\u0000"
          + "\u025d\u0253\u0001\u0000\u0000\u0000\u025d\u0258\u0001\u0000\u0000\u0000"
          + "\u025e\u008d\u0001\u0000\u0000\u0000\u025f\u0260\u0005\u0007\u0000\u0000"
          + "\u0260\u0261\u0005T\u0000\u0000\u0261\u0262\u0005\u001a\u0000\u0000\u0262"
          + "\u0263\u0003\u0088D\u0000\u0263\u0264\u0005\u001b\u0000\u0000\u0264\u0265"
          + "\u0005\u001c\u0000\u0000\u0265\u008f\u0001\u0000\u0000\u0000\u0266\u0267"
          + "\u0005\u001e\u0000\u0000\u0267\u026a\u0003H$\u0000\u0268\u026a\u0001\u0000"
          + "\u0000\u0000\u0269\u0266\u0001\u0000\u0000\u0000\u0269\u0268\u0001\u0000"
          + "\u0000\u0000\u026a\u0091\u0001\u0000\u0000\u0000\u026b\u026c\u0005\b\u0000"
          + "\u0000\u026c\u026d\u0005T\u0000\u0000\u026d\u026e\u0005\u001a\u0000\u0000"
          + "\u026e\u026f\u0003\u0094J\u0000\u026f\u0270\u0005\u001b\u0000\u0000\u0270"
          + "\u0271\u0005\u001c\u0000\u0000\u0271\u0093\u0001\u0000\u0000\u0000\u0272"
          + "\u0273\u0005U\u0000\u0000\u0273\u0274\u0003\u0096K\u0000\u0274\u0095\u0001"
          + "\u0000\u0000\u0000\u0275\u0276\u0005)\u0000\u0000\u0276\u0279\u0003\u0098"
          + "L\u0000\u0277\u0279\u0001\u0000\u0000\u0000\u0278\u0275\u0001\u0000\u0000"
          + "\u0000\u0278\u0277\u0001\u0000\u0000\u0000\u0279\u0097\u0001\u0000\u0000"
          + "\u0000\u027a\u027b\u0005U\u0000\u0000\u027b\u027e\u0003\u0096K\u0000\u027c"
          + "\u027e\u0001\u0000\u0000\u0000\u027d\u027a\u0001\u0000\u0000\u0000\u027d"
          + "\u027c\u0001\u0000\u0000\u0000\u027e\u0099\u0001\u0000\u0000\u0000\u027f"
          + "\u0280\u0005T\u0000\u0000\u0280\u0281\u0005\u001e\u0000\u0000\u0281\u0282"
          + "\u0003\u009eO\u0000\u0282\u0283\u0005\'\u0000\u0000\u0283\u0284\u0003"
          + "Z-\u0000\u0284\u0285\u0005(\u0000\u0000\u0285\u0286\u0005\u001c\u0000"
          + "\u0000\u0286\u009b\u0001\u0000\u0000\u0000\u0287\u0288\u0005\u0018\u0000"
          + "\u0000\u0288\u0289\u0003\u00a0P\u0000\u0289\u028a\u0005T\u0000\u0000\u028a"
          + "\u028b\u0005\u001c\u0000\u0000\u028b\u009d\u0001\u0000\u0000\u0000\u028c"
          + "\u0291\u0003\u00a2Q\u0000\u028d\u028e\u0003\u00a4R\u0000\u028e\u028f\u0003"
          + "\u00be_\u0000\u028f\u0291\u0001\u0000\u0000\u0000\u0290\u028c\u0001\u0000"
          + "\u0000\u0000\u0290\u028d\u0001\u0000\u0000\u0000\u0291\u009f\u0001\u0000"
          + "\u0000\u0000\u0292\u0293\u0003\u00c2a\u0000\u0293\u0294\u0003\u009eO\u0000"
          + "\u0294\u00a1\u0001\u0000\u0000\u0000\u0295\u0299\u0003\u00aaU\u0000\u0296"
          + "\u0299\u0005.\u0000\u0000\u0297\u0299\u0003\u00ba]\u0000\u0298\u0295\u0001"
          + "\u0000\u0000\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0298\u0297\u0001"
          + "\u0000\u0000\u0000\u0299\u00a3\u0001\u0000\u0000\u0000\u029a\u029b\u0005"
          + "\'\u0000\u0000\u029b\u029c\u0003\u00a6S\u0000\u029c\u029d\u0005/\u0000"
          + "\u0000\u029d\u029e\u0003\u00a6S\u0000\u029e\u029f\u0003\u00a8T\u0000\u029f"
          + "\u02a0\u0005(\u0000\u0000\u02a0\u00a5\u0001\u0000\u0000\u0000\u02a1\u02a2"
          + "\u0003\u00c2a\u0000\u02a2\u02a3\u0003\u00aaU\u0000\u02a3\u02a8\u0001\u0000"
          + "\u0000\u0000\u02a4\u02a5\u0003\u00a4R\u0000\u02a5\u02a6\u0003\u00be_\u0000"
          + "\u02a6\u02a8\u0001\u0000\u0000\u0000\u02a7\u02a1\u0001\u0000\u0000\u0000"
          + "\u02a7\u02a4\u0001\u0000\u0000\u0000\u02a8\u00a7\u0001\u0000\u0000\u0000"
          + "\u02a9\u02aa\u0005/\u0000\u0000\u02aa\u02ab\u0003\u00a6S\u0000\u02ab\u02ac"
          + "\u0003\u00a8T\u0000\u02ac\u02af\u0001\u0000\u0000\u0000\u02ad\u02af\u0001"
          + "\u0000\u0000\u0000\u02ae\u02a9\u0001\u0000\u0000\u0000\u02ae\u02ad\u0001"
          + "\u0000\u0000\u0000\u02af\u00a9\u0001\u0000\u0000\u0000\u02b0\u02b1\u0003"
          + "\u00acV\u0000\u02b1\u02b2\u0003\u00be_\u0000\u02b2\u02d5\u0001\u0000\u0000"
          + "\u0000\u02b3\u02b4\u0003\u00b8\\\u0000\u02b4\u02b5\u0003\u00be_\u0000"
          + "\u02b5\u02d5\u0001\u0000\u0000\u0000\u02b6\u02b7\u0005T\u0000\u0000\u02b7"
          + "\u02d5\u0003\u00be_\u0000\u02b8\u02b9\u00050\u0000\u0000\u02b9\u02ba\u0005"
          + ",\u0000\u0000\u02ba\u02bb\u0003\u00a0P\u0000\u02bb\u02bc\u0005-\u0000"
          + "\u0000\u02bc\u02bd\u0003\u00be_\u0000\u02bd\u02d5\u0001\u0000\u0000\u0000"
          + "\u02be\u02bf\u00051\u0000\u0000\u02bf\u02d5\u0003\u00be_\u0000\u02c0\u02c1"
          + "\u00052\u0000\u0000\u02c1\u02d5\u0003\u00be_\u0000\u02c2\u02c3\u0003\u00c0"
          + "`\u0000\u02c3\u02c4\u0003\u00be_\u0000\u02c4\u02d5\u0001\u0000\u0000\u0000"
          + "\u02c5\u02c6\u00053\u0000\u0000\u02c6\u02c7\u0005,\u0000\u0000\u02c7\u02c8"
          + "\u0003\u00a0P\u0000\u02c8\u02c9\u0005-\u0000\u0000\u02c9\u02ca\u0003\u00be"
          + "_\u0000\u02ca\u02d5\u0001\u0000\u0000\u0000\u02cb\u02cc\u00054\u0000\u0000"
          + "\u02cc\u02cd\u0005,\u0000\u0000\u02cd\u02ce\u0003\u00a0P\u0000\u02ce\u02cf"
          + "\u0005-\u0000\u0000\u02cf\u02d0\u0003\u00be_\u0000\u02d0\u02d5\u0001\u0000"
          + "\u0000\u0000\u02d1\u02d2\u0003\u00bc^\u0000\u02d2\u02d3\u0003\u00be_\u0000"
          + "\u02d3\u02d5\u0001\u0000\u0000\u0000\u02d4\u02b0\u0001\u0000\u0000\u0000"
          + "\u02d4\u02b3\u0001\u0000\u0000\u0000\u02d4\u02b6\u0001\u0000\u0000\u0000"
          + "\u02d4\u02b8\u0001\u0000\u0000\u0000\u02d4\u02be\u0001\u0000\u0000\u0000"
          + "\u02d4\u02c0\u0001\u0000\u0000\u0000\u02d4\u02c2\u0001\u0000\u0000\u0000"
          + "\u02d4\u02c5\u0001\u0000\u0000\u0000\u02d4\u02cb\u0001\u0000\u0000\u0000"
          + "\u02d4\u02d1\u0001\u0000\u0000\u0000\u02d5\u00ab\u0001\u0000\u0000\u0000"
          + "\u02d6\u02de\u0003\u00b2Y\u0000\u02d7\u02de\u0003\u00aeW\u0000\u02d8\u02de"
          + "\u00055\u0000\u0000\u02d9\u02de\u00056\u0000\u0000\u02da\u02de\u00057"
          + "\u0000\u0000\u02db\u02de\u00058\u0000\u0000\u02dc\u02de\u00059\u0000\u0000"
          + "\u02dd\u02d6\u0001\u0000\u0000\u0000\u02dd\u02d7\u0001\u0000\u0000\u0000"
          + "\u02dd\u02d8\u0001\u0000\u0000\u0000\u02dd\u02d9\u0001\u0000\u0000\u0000"
          + "\u02dd\u02da\u0001\u0000\u0000\u0000\u02dd\u02db\u0001\u0000\u0000\u0000"
          + "\u02dd\u02dc\u0001\u0000\u0000\u0000\u02de\u00ad\u0001\u0000\u0000\u0000"
          + "\u02df\u02e0\u0005\u0019\u0000\u0000\u02e0\u02e3\u0003\u00b0X\u0000\u02e1"
          + "\u02e3\u0003\u00b0X\u0000\u02e2\u02df\u0001\u0000\u0000\u0000\u02e2\u02e1"
          + "\u0001\u0000\u0000\u0000\u02e3\u00af\u0001\u0000\u0000\u0000\u02e4\u02e5"
          + "\u0007\u0005\u0000\u0000\u02e5\u00b1\u0001\u0000\u0000\u0000\u02e6\u02e7"
          + "\u0005<\u0000\u0000\u02e7\u02ea\u0003\u00b4Z\u0000\u02e8\u02ea\u0003\u00b4"
          + "Z\u0000\u02e9\u02e6\u0001\u0000\u0000\u0000\u02e9\u02e8\u0001\u0000\u0000"
          + "\u0000\u02ea\u00b3\u0001\u0000\u0000\u0000\u02eb\u02ef\u0005=\u0000\u0000"
          + "\u02ec\u02ed\u0005>\u0000\u0000\u02ed\u02ef\u0003\u00b6[\u0000\u02ee\u02eb"
          + "\u0001\u0000\u0000\u0000\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ef\u00b5"
          + "\u0001\u0000\u0000\u0000\u02f0\u02f3\u0005>\u0000\u0000\u02f1\u02f3\u0001"
          + "\u0000\u0000\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000\u02f2\u02f1\u0001"
          + "\u0000\u0000\u0000\u02f3\u00b7\u0001\u0000\u0000\u0000\u02f4\u02f5\u0007"
          + "\u0006\u0000\u0000\u02f5\u00b9\u0001\u0000\u0000\u0000\u02f6\u02f7\u0005"
          + "B\u0000\u0000\u02f7\u02f8\u0005,\u0000\u0000\u02f8\u02f9\u0003\u009eO"
          + "\u0000\u02f9\u02fa\u0005-\u0000\u0000\u02fa\u00bb\u0001\u0000\u0000\u0000"
          + "\u02fb\u02fc\u0005C\u0000\u0000\u02fc\u02fd\u0005,\u0000\u0000\u02fd\u02fe"
          + "\u0003\u00b8\\\u0000\u02fe\u02ff\u0005)\u0000\u0000\u02ff\u0300\u0003"
          + "\u00a0P\u0000\u0300\u0301\u0005-\u0000\u0000\u0301\u00bd\u0001\u0000\u0000"
          + "\u0000\u0302\u0305\u0005D\u0000\u0000\u0303\u0305\u0001\u0000\u0000\u0000"
          + "\u0304\u0302\u0001\u0000\u0000\u0000\u0304\u0303\u0001\u0000\u0000\u0000"
          + "\u0305\u00bf\u0001\u0000\u0000\u0000\u0306\u0307\u0007\u0007\u0000\u0000"
          + "\u0307\u00c1\u0001\u0000\u0000\u0000\u0308\u0309\u0005$\u0000\u0000\u0309"
          + "\u030a\u0003\u00c6c\u0000\u030a\u030b\u0003\u00c4b\u0000\u030b\u030c\u0005"
          + "%\u0000\u0000\u030c\u030f\u0001\u0000\u0000\u0000\u030d\u030f\u0001\u0000"
          + "\u0000\u0000\u030e\u0308\u0001\u0000\u0000\u0000\u030e\u030d\u0001\u0000"
          + "\u0000\u0000\u030f\u00c3\u0001\u0000\u0000\u0000\u0310\u0311\u0005)\u0000"
          + "\u0000\u0311\u0312\u0003\u00c6c\u0000\u0312\u0313\u0003\u00c4b\u0000\u0313"
          + "\u0316\u0001\u0000\u0000\u0000\u0314\u0316\u0001\u0000\u0000\u0000\u0315"
          + "\u0310\u0001\u0000\u0000\u0000\u0315\u0314\u0001\u0000\u0000\u0000\u0316"
          + "\u00c5\u0001\u0000\u0000\u0000\u0317\u031f\u0003\u00d0h\u0000\u0318\u031f"
          + "\u0003\u00d2i\u0000\u0319\u031f\u0003\u00d8l\u0000\u031a\u031f\u0003\u00d4"
          + "j\u0000\u031b\u031f\u0003\u00d6k\u0000\u031c\u031f\u0003\u00dam\u0000"
          + "\u031d\u031f\u0003\u00dcn\u0000\u031e\u0317\u0001\u0000\u0000\u0000\u031e"
          + "\u0318\u0001\u0000\u0000\u0000\u031e\u0319\u0001\u0000\u0000\u0000\u031e"
          + "\u031a\u0001\u0000\u0000\u0000\u031e\u031b\u0001\u0000\u0000\u0000\u031e"
          + "\u031c\u0001\u0000\u0000\u0000\u031e\u031d\u0001\u0000\u0000\u0000\u031f"
          + "\u00c7\u0001\u0000\u0000\u0000\u0320\u034e\u0005R\u0000\u0000\u0321\u034e"
          + "\u0005S\u0000\u0000\u0322\u034e\u0005T\u0000\u0000\u0323\u034e\u0005U"
          + "\u0000\u0000\u0324\u034e\u0005X\u0000\u0000\u0325\u034e\u0005P\u0000\u0000"
          + "\u0326\u034e\u0005!\u0000\u0000\u0327\u034e\u0005Q\u0000\u0000\u0328\u034e"
          + "\u0005+\u0000\u0000\u0329\u034e\u0005\u001d\u0000\u0000\u032a\u034e\u0005"
          + "\u001c\u0000\u0000\u032b\u034e\u0005,\u0000\u0000\u032c\u034e\u0005\u001e"
          + "\u0000\u0000\u032d\u034e\u0005-\u0000\u0000\u032e\u034e\u0005D\u0000\u0000"
          + "\u032f\u034e\u0005?\u0000\u0000\u0330\u034e\u0005@\u0000\u0000\u0331\u034e"
          + "\u00053\u0000\u0000\u0332\u034e\u0005\"\u0000\u0000\u0333\u034e\u0005"
          + "#\u0000\u0000\u0334\u034e\u00054\u0000\u0000\u0335\u034e\u0005B\u0000"
          + "\u0000\u0336\u034e\u0005A\u0000\u0000\u0337\u034e\u0005.\u0000\u0000\u0338"
          + "\u034e\u00059\u0000\u0000\u0339\u034e\u00056\u0000\u0000\u033a\u034e\u0005"
          + "7\u0000\u0000\u033b\u034e\u0005;\u0000\u0000\u033c\u034e\u0005 \u0000"
          + "\u0000\u033d\u034e\u0005:\u0000\u0000\u033e\u034e\u0005>\u0000\u0000\u033f"
          + "\u034e\u0005&\u0000\u0000\u0340\u034e\u00051\u0000\u0000\u0341\u034e\u0005"
          + "8\u0000\u0000\u0342\u034e\u0005/\u0000\u0000\u0343\u034e\u0005*\u0000"
          + "\u0000\u0344\u034e\u0005C\u0000\u0000\u0345\u034e\u00050\u0000\u0000\u0346"
          + "\u034e\u0005=\u0000\u0000\u0347\u034e\u00052\u0000\u0000\u0348\u034e\u0005"
          + "\u001f\u0000\u0000\u0349\u034e\u0005<\u0000\u0000\u034a\u034e\u00055\u0000"
          + "\u0000\u034b\u034e\u0003\u0006\u0003\u0000\u034c\u034e\u0003\u00c0`\u0000"
          + "\u034d\u0320\u0001\u0000\u0000\u0000\u034d\u0321\u0001\u0000\u0000\u0000"
          + "\u034d\u0322\u0001\u0000\u0000\u0000\u034d\u0323\u0001\u0000\u0000\u0000"
          + "\u034d\u0324\u0001\u0000\u0000\u0000\u034d\u0325\u0001\u0000\u0000\u0000"
          + "\u034d\u0326\u0001\u0000\u0000\u0000\u034d\u0327\u0001\u0000\u0000\u0000"
          + "\u034d\u0328\u0001\u0000\u0000\u0000\u034d\u0329\u0001\u0000\u0000\u0000"
          + "\u034d\u032a\u0001\u0000\u0000\u0000\u034d\u032b\u0001\u0000\u0000\u0000"
          + "\u034d\u032c\u0001\u0000\u0000\u0000\u034d\u032d\u0001\u0000\u0000\u0000"
          + "\u034d\u032e\u0001\u0000\u0000\u0000\u034d\u032f\u0001\u0000\u0000\u0000"
          + "\u034d\u0330\u0001\u0000\u0000\u0000\u034d\u0331\u0001\u0000\u0000\u0000"
          + "\u034d\u0332\u0001\u0000\u0000\u0000\u034d\u0333\u0001\u0000\u0000\u0000"
          + "\u034d\u0334\u0001\u0000\u0000\u0000\u034d\u0335\u0001\u0000\u0000\u0000"
          + "\u034d\u0336\u0001\u0000\u0000\u0000\u034d\u0337\u0001\u0000\u0000\u0000"
          + "\u034d\u0338\u0001\u0000\u0000\u0000\u034d\u0339\u0001\u0000\u0000\u0000"
          + "\u034d\u033a\u0001\u0000\u0000\u0000\u034d\u033b\u0001\u0000\u0000\u0000"
          + "\u034d\u033c\u0001\u0000\u0000\u0000\u034d\u033d\u0001\u0000\u0000\u0000"
          + "\u034d\u033e\u0001\u0000\u0000\u0000\u034d\u033f\u0001\u0000\u0000\u0000"
          + "\u034d\u0340\u0001\u0000\u0000\u0000\u034d\u0341\u0001\u0000\u0000\u0000"
          + "\u034d\u0342\u0001\u0000\u0000\u0000\u034d\u0343\u0001\u0000\u0000\u0000"
          + "\u034d\u0344\u0001\u0000\u0000\u0000\u034d\u0345\u0001\u0000\u0000\u0000"
          + "\u034d\u0346\u0001\u0000\u0000\u0000\u034d\u0347\u0001\u0000\u0000\u0000"
          + "\u034d\u0348\u0001\u0000\u0000\u0000\u034d\u0349\u0001\u0000\u0000\u0000"
          + "\u034d\u034a\u0001\u0000\u0000\u0000\u034d\u034b\u0001\u0000\u0000\u0000"
          + "\u034d\u034c\u0001\u0000\u0000\u0000\u034e\u00c9\u0001\u0000\u0000\u0000"
          + "\u034f\u0352\u0003\u00c8d\u0000\u0350\u0352\u0005)\u0000\u0000\u0351\u034f"
          + "\u0001\u0000\u0000\u0000\u0351\u0350\u0001\u0000\u0000\u0000\u0352\u00cb"
          + "\u0001\u0000\u0000\u0000\u0353\u0354\u0005T\u0000\u0000\u0354\u0355\u0003"
          + "\u00ceg\u0000\u0355\u00cd\u0001\u0000\u0000\u0000\u0356\u0357\u0005)\u0000"
          + "\u0000\u0357\u0358\u0005T\u0000\u0000\u0358\u035b\u0003\u00ceg\u0000\u0359"
          + "\u035b\u0001\u0000\u0000\u0000\u035a\u0356\u0001\u0000\u0000\u0000\u035a"
          + "\u0359\u0001\u0000\u0000\u0000\u035b\u00cf\u0001\u0000\u0000\u0000\u035c"
          + "\u035d\u0005T\u0000\u0000\u035d\u00d1\u0001\u0000\u0000\u0000\u035e\u035f"
          + "\u0005T\u0000\u0000\u035f\u0360\u0005\'\u0000\u0000\u0360\u0361\u0003"
          + "Z-\u0000\u0361\u0362\u0005(\u0000\u0000\u0362\u00d3\u0001\u0000\u0000"
          + "\u0000\u0363\u0364\u0005T\u0000\u0000\u0364\u0365\u0005\u001e\u0000\u0000"
          + "\u0365\u0366\u0005T\u0000\u0000\u0366\u00d5\u0001\u0000\u0000\u0000\u0367"
          + "\u0368\u0005T\u0000\u0000\u0368\u0369\u0005\u001e\u0000\u0000\u0369\u036a"
          + "\u0005\'\u0000\u0000\u036a\u036b\u0003\u00ccf\u0000\u036b\u036c\u0005"
          + "(\u0000\u0000\u036c\u00d7\u0001\u0000\u0000\u0000\u036d\u036e\u0005T\u0000"
          + "\u0000\u036e\u036f\u0005\u001e\u0000\u0000\u036f\u0370\u0005T\u0000\u0000"
          + "\u0370\u0371\u0005\'\u0000\u0000\u0371\u0372\u0003Z-\u0000\u0372\u0373"
          + "\u0005(\u0000\u0000\u0373\u00d9\u0001\u0000\u0000\u0000\u0374\u0375\u0005"
          + "T\u0000\u0000\u0375\u0376\u0005\u001e\u0000\u0000\u0376\u0377\u0005U\u0000"
          + "\u0000\u0377\u00db\u0001\u0000\u0000\u0000\u0378\u0379\u0005T\u0000\u0000"
          + "\u0379\u037a\u0005\u001e\u0000\u0000\u037a\u037b\u0005\'\u0000\u0000\u037b"
          + "\u037c\u0003\u00deo\u0000\u037c\u037d\u0005(\u0000\u0000\u037d\u00dd\u0001"
          + "\u0000\u0000\u0000\u037e\u037f\u0005U\u0000\u0000\u037f\u0380\u0003\u00e0"
          + "p\u0000\u0380\u00df\u0001\u0000\u0000\u0000\u0381\u0382\u0005)\u0000\u0000"
          + "\u0382\u0383\u0005U\u0000\u0000\u0383\u0386\u0003\u00e0p\u0000\u0384\u0386"
          + "\u0001\u0000\u0000\u0000\u0385\u0381\u0001\u0000\u0000\u0000\u0385\u0384"
          + "\u0001\u0000\u0000\u0000\u0386\u00e1\u0001\u0000\u0000\u0000;\u00ea\u00f3"
          + "\u00fb\u00ff\u010f\u0113\u0120\u0124\u012b\u0138\u013d\u014b\u0153\u0162"
          + "\u0169\u016d\u0179\u0181\u0189\u0197\u019d\u01a6\u01aa\u01bc\u01c0\u01c8"
          + "\u01cf\u01dd\u01e1\u01e5\u01f5\u01fe\u020a\u021a\u023a\u0240\u024e\u025d"
          + "\u0269\u0278\u027d\u0290\u0298\u02a7\u02ae\u02d4\u02dd\u02e2\u02e9\u02ee"
          + "\u02f2\u0304\u030e\u0315\u031e\u034d\u0351\u035a\u0385";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
