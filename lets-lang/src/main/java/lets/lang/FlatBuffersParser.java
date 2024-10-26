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
public class FlatBuffersParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int ATTRIBUTE = 1,
      ENUM = 2,
      FILE_EXTENSION = 3,
      FILE_IDENTIFIER = 4,
      INCLUDE = 5,
      NATIVE_INCLUDE = 6,
      NAMESPACE = 7,
      ROOT_TYPE = 8,
      RPC_SERVICE = 9,
      STRUCT = 10,
      TABLE = 11,
      UNION = 12,
      SEMI = 13,
      EQ = 14,
      LP = 15,
      RP = 16,
      LB = 17,
      RB = 18,
      LC = 19,
      RC = 20,
      DOT = 21,
      COMMA = 22,
      COLON = 23,
      PLUS = 24,
      MINUS = 25,
      STRING_CONSTANT = 26,
      BASE_TYPE_NAME = 27,
      INTEGER_CONSTANT = 28,
      IDENT = 29,
      HEX_INTEGER_CONSTANT = 30,
      FLOAT_CONSTANT = 31,
      BLOCK_COMMENT = 32,
      COMMENT = 33,
      WS = 34;
  public static final int RULE_schema = 0,
      RULE_include_ = 1,
      RULE_namespace_decl = 2,
      RULE_attribute_decl = 3,
      RULE_type_decl = 4,
      RULE_enum_decl = 5,
      RULE_union_decl = 6,
      RULE_root_decl = 7,
      RULE_field_decl = 8,
      RULE_rpc_decl = 9,
      RULE_rpc_method = 10,
      RULE_type_ = 11,
      RULE_enumval_decl = 12,
      RULE_commasep_enumval_decl = 13,
      RULE_unionval_with_opt_alias = 14,
      RULE_commasep_unionval_with_opt_alias = 15,
      RULE_ident_with_opt_single_value = 16,
      RULE_commasep_ident_with_opt_single_value = 17,
      RULE_metadata = 18,
      RULE_scalar = 19,
      RULE_object_ = 20,
      RULE_ident_with_value = 21,
      RULE_commasep_ident_with_value = 22,
      RULE_single_value = 23,
      RULE_value = 24,
      RULE_commasep_value = 25,
      RULE_file_extension_decl = 26,
      RULE_file_identifier_decl = 27,
      RULE_ns_ident = 28,
      RULE_integer_const = 29,
      RULE_identifier = 30,
      RULE_keywords = 31;

  private static String[] makeRuleNames() {
    return new String[] {
      "schema",
      "include_",
      "namespace_decl",
      "attribute_decl",
      "type_decl",
      "enum_decl",
      "union_decl",
      "root_decl",
      "field_decl",
      "rpc_decl",
      "rpc_method",
      "type_",
      "enumval_decl",
      "commasep_enumval_decl",
      "unionval_with_opt_alias",
      "commasep_unionval_with_opt_alias",
      "ident_with_opt_single_value",
      "commasep_ident_with_opt_single_value",
      "metadata",
      "scalar",
      "object_",
      "ident_with_value",
      "commasep_ident_with_value",
      "single_value",
      "value",
      "commasep_value",
      "file_extension_decl",
      "file_identifier_decl",
      "ns_ident",
      "integer_const",
      "identifier",
      "keywords"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'attribute'",
      "'enum'",
      "'file_extension'",
      "'file_identifier'",
      "'include'",
      "'native_include'",
      "'namespace'",
      "'root_type'",
      "'rpc_service'",
      "'struct'",
      "'table'",
      "'union'",
      "';'",
      "'='",
      "'('",
      "')'",
      "'['",
      "']'",
      "'{'",
      "'}'",
      "'.'",
      "','",
      "':'",
      "'+'",
      "'-'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "ATTRIBUTE",
      "ENUM",
      "FILE_EXTENSION",
      "FILE_IDENTIFIER",
      "INCLUDE",
      "NATIVE_INCLUDE",
      "NAMESPACE",
      "ROOT_TYPE",
      "RPC_SERVICE",
      "STRUCT",
      "TABLE",
      "UNION",
      "SEMI",
      "EQ",
      "LP",
      "RP",
      "LB",
      "RB",
      "LC",
      "RC",
      "DOT",
      "COMMA",
      "COLON",
      "PLUS",
      "MINUS",
      "STRING_CONSTANT",
      "BASE_TYPE_NAME",
      "INTEGER_CONSTANT",
      "IDENT",
      "HEX_INTEGER_CONSTANT",
      "FLOAT_CONSTANT",
      "BLOCK_COMMENT",
      "COMMENT",
      "WS"
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
    return "FlatBuffers.g4";
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

  public FlatBuffersParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SchemaContext extends ParserRuleContext {
    public TerminalNode EOF() {
      return getToken(FlatBuffersParser.EOF, 0);
    }

    public List<Include_Context> include_() {
      return getRuleContexts(Include_Context.class);
    }

    public Include_Context include_(int i) {
      return getRuleContext(Include_Context.class, i);
    }

    public List<Namespace_declContext> namespace_decl() {
      return getRuleContexts(Namespace_declContext.class);
    }

    public Namespace_declContext namespace_decl(int i) {
      return getRuleContext(Namespace_declContext.class, i);
    }

    public List<Type_declContext> type_decl() {
      return getRuleContexts(Type_declContext.class);
    }

    public Type_declContext type_decl(int i) {
      return getRuleContext(Type_declContext.class, i);
    }

    public List<Enum_declContext> enum_decl() {
      return getRuleContexts(Enum_declContext.class);
    }

    public Enum_declContext enum_decl(int i) {
      return getRuleContext(Enum_declContext.class, i);
    }

    public List<Union_declContext> union_decl() {
      return getRuleContexts(Union_declContext.class);
    }

    public Union_declContext union_decl(int i) {
      return getRuleContext(Union_declContext.class, i);
    }

    public List<Root_declContext> root_decl() {
      return getRuleContexts(Root_declContext.class);
    }

    public Root_declContext root_decl(int i) {
      return getRuleContext(Root_declContext.class, i);
    }

    public List<File_extension_declContext> file_extension_decl() {
      return getRuleContexts(File_extension_declContext.class);
    }

    public File_extension_declContext file_extension_decl(int i) {
      return getRuleContext(File_extension_declContext.class, i);
    }

    public List<File_identifier_declContext> file_identifier_decl() {
      return getRuleContexts(File_identifier_declContext.class);
    }

    public File_identifier_declContext file_identifier_decl(int i) {
      return getRuleContext(File_identifier_declContext.class, i);
    }

    public List<Attribute_declContext> attribute_decl() {
      return getRuleContexts(Attribute_declContext.class);
    }

    public Attribute_declContext attribute_decl(int i) {
      return getRuleContext(Attribute_declContext.class, i);
    }

    public List<Rpc_declContext> rpc_decl() {
      return getRuleContexts(Rpc_declContext.class);
    }

    public Rpc_declContext rpc_decl(int i) {
      return getRuleContext(Rpc_declContext.class, i);
    }

    public List<Object_Context> object_() {
      return getRuleContexts(Object_Context.class);
    }

    public Object_Context object_(int i) {
      return getRuleContext(Object_Context.class, i);
    }

    public SchemaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_schema;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterSchema(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitSchema(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitSchema(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SchemaContext schema() throws RecognitionException {
    SchemaContext _localctx = new SchemaContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_schema);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(67);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == INCLUDE || _la == NATIVE_INCLUDE) {
          {
            {
              setState(64);
              include_();
            }
          }
          setState(69);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(82);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 532382L) != 0)) {
          {
            setState(80);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case NAMESPACE:
                {
                  setState(70);
                  namespace_decl();
                }
                break;
              case STRUCT:
              case TABLE:
                {
                  setState(71);
                  type_decl();
                }
                break;
              case ENUM:
                {
                  setState(72);
                  enum_decl();
                }
                break;
              case UNION:
                {
                  setState(73);
                  union_decl();
                }
                break;
              case ROOT_TYPE:
                {
                  setState(74);
                  root_decl();
                }
                break;
              case FILE_EXTENSION:
                {
                  setState(75);
                  file_extension_decl();
                }
                break;
              case FILE_IDENTIFIER:
                {
                  setState(76);
                  file_identifier_decl();
                }
                break;
              case ATTRIBUTE:
                {
                  setState(77);
                  attribute_decl();
                }
                break;
              case RPC_SERVICE:
                {
                  setState(78);
                  rpc_decl();
                }
                break;
              case LC:
                {
                  setState(79);
                  object_();
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          setState(84);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(85);
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
  public static class Include_Context extends ParserRuleContext {
    public TerminalNode STRING_CONSTANT() {
      return getToken(FlatBuffersParser.STRING_CONSTANT, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public TerminalNode INCLUDE() {
      return getToken(FlatBuffersParser.INCLUDE, 0);
    }

    public TerminalNode NATIVE_INCLUDE() {
      return getToken(FlatBuffersParser.NATIVE_INCLUDE, 0);
    }

    public Include_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_include_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterInclude_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitInclude_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitInclude_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Include_Context include_() throws RecognitionException {
    Include_Context _localctx = new Include_Context(_ctx, getState());
    enterRule(_localctx, 2, RULE_include_);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(87);
        _la = _input.LA(1);
        if (!(_la == INCLUDE || _la == NATIVE_INCLUDE)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(88);
        match(STRING_CONSTANT);
        setState(89);
        match(SEMI);
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
  public static class Namespace_declContext extends ParserRuleContext {
    public TerminalNode NAMESPACE() {
      return getToken(FlatBuffersParser.NAMESPACE, 0);
    }

    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public List<TerminalNode> DOT() {
      return getTokens(FlatBuffersParser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(FlatBuffersParser.DOT, i);
    }

    public Namespace_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_namespace_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterNamespace_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitNamespace_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitNamespace_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Namespace_declContext namespace_decl() throws RecognitionException {
    Namespace_declContext _localctx = new Namespace_declContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_namespace_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(91);
        match(NAMESPACE);
        setState(92);
        identifier();
        setState(97);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == DOT) {
          {
            {
              setState(93);
              match(DOT);
              setState(94);
              identifier();
            }
          }
          setState(99);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(100);
        match(SEMI);
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
  public static class Attribute_declContext extends ParserRuleContext {
    public TerminalNode ATTRIBUTE() {
      return getToken(FlatBuffersParser.ATTRIBUTE, 0);
    }

    public TerminalNode STRING_CONSTANT() {
      return getToken(FlatBuffersParser.STRING_CONSTANT, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public Attribute_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_attribute_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterAttribute_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitAttribute_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitAttribute_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Attribute_declContext attribute_decl() throws RecognitionException {
    Attribute_declContext _localctx = new Attribute_declContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_attribute_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(102);
        match(ATTRIBUTE);
        setState(103);
        match(STRING_CONSTANT);
        setState(104);
        match(SEMI);
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
  public static class Type_declContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public MetadataContext metadata() {
      return getRuleContext(MetadataContext.class, 0);
    }

    public TerminalNode LC() {
      return getToken(FlatBuffersParser.LC, 0);
    }

    public TerminalNode RC() {
      return getToken(FlatBuffersParser.RC, 0);
    }

    public TerminalNode TABLE() {
      return getToken(FlatBuffersParser.TABLE, 0);
    }

    public TerminalNode STRUCT() {
      return getToken(FlatBuffersParser.STRUCT, 0);
    }

    public List<Field_declContext> field_decl() {
      return getRuleContexts(Field_declContext.class);
    }

    public Field_declContext field_decl(int i) {
      return getRuleContext(Field_declContext.class, i);
    }

    public Type_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_type_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterType_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitType_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitType_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Type_declContext type_decl() throws RecognitionException {
    Type_declContext _localctx = new Type_declContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_type_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(106);
        _la = _input.LA(1);
        if (!(_la == STRUCT || _la == TABLE)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(107);
        identifier();
        setState(108);
        metadata();
        setState(109);
        match(LC);
        setState(113);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536879102L) != 0)) {
          {
            {
              setState(110);
              field_decl();
            }
          }
          setState(115);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(116);
        match(RC);
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
  public static class Enum_declContext extends ParserRuleContext {
    public TerminalNode ENUM() {
      return getToken(FlatBuffersParser.ENUM, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public MetadataContext metadata() {
      return getRuleContext(MetadataContext.class, 0);
    }

    public TerminalNode LC() {
      return getToken(FlatBuffersParser.LC, 0);
    }

    public Commasep_enumval_declContext commasep_enumval_decl() {
      return getRuleContext(Commasep_enumval_declContext.class, 0);
    }

    public TerminalNode RC() {
      return getToken(FlatBuffersParser.RC, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public Enum_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enum_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterEnum_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitEnum_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitEnum_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Enum_declContext enum_decl() throws RecognitionException {
    Enum_declContext _localctx = new Enum_declContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_enum_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(118);
        match(ENUM);
        setState(119);
        identifier();
        setState(122);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COLON) {
          {
            setState(120);
            match(COLON);
            setState(121);
            type_();
          }
        }

        setState(124);
        metadata();
        setState(125);
        match(LC);
        setState(126);
        commasep_enumval_decl();
        setState(127);
        match(RC);
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
  public static class Union_declContext extends ParserRuleContext {
    public TerminalNode UNION() {
      return getToken(FlatBuffersParser.UNION, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public MetadataContext metadata() {
      return getRuleContext(MetadataContext.class, 0);
    }

    public TerminalNode LC() {
      return getToken(FlatBuffersParser.LC, 0);
    }

    public Commasep_unionval_with_opt_aliasContext commasep_unionval_with_opt_alias() {
      return getRuleContext(Commasep_unionval_with_opt_aliasContext.class, 0);
    }

    public TerminalNode RC() {
      return getToken(FlatBuffersParser.RC, 0);
    }

    public Union_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_union_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterUnion_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitUnion_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitUnion_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Union_declContext union_decl() throws RecognitionException {
    Union_declContext _localctx = new Union_declContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_union_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(129);
        match(UNION);
        setState(130);
        identifier();
        setState(131);
        metadata();
        setState(132);
        match(LC);
        setState(133);
        commasep_unionval_with_opt_alias();
        setState(134);
        match(RC);
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
  public static class Root_declContext extends ParserRuleContext {
    public TerminalNode ROOT_TYPE() {
      return getToken(FlatBuffersParser.ROOT_TYPE, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public Root_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_root_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterRoot_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitRoot_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitRoot_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Root_declContext root_decl() throws RecognitionException {
    Root_declContext _localctx = new Root_declContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_root_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(136);
        match(ROOT_TYPE);
        setState(137);
        identifier();
        setState(138);
        match(SEMI);
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
  public static class Field_declContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public MetadataContext metadata() {
      return getRuleContext(MetadataContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public TerminalNode EQ() {
      return getToken(FlatBuffersParser.EQ, 0);
    }

    public ScalarContext scalar() {
      return getRuleContext(ScalarContext.class, 0);
    }

    public Field_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_field_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterField_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitField_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitField_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Field_declContext field_decl() throws RecognitionException {
    Field_declContext _localctx = new Field_declContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_field_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(140);
        identifier();
        setState(141);
        match(COLON);
        setState(142);
        type_();
        setState(145);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EQ) {
          {
            setState(143);
            match(EQ);
            setState(144);
            scalar();
          }
        }

        setState(147);
        metadata();
        setState(148);
        match(SEMI);
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
  public static class Rpc_declContext extends ParserRuleContext {
    public TerminalNode RPC_SERVICE() {
      return getToken(FlatBuffersParser.RPC_SERVICE, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode LC() {
      return getToken(FlatBuffersParser.LC, 0);
    }

    public TerminalNode RC() {
      return getToken(FlatBuffersParser.RC, 0);
    }

    public List<Rpc_methodContext> rpc_method() {
      return getRuleContexts(Rpc_methodContext.class);
    }

    public Rpc_methodContext rpc_method(int i) {
      return getRuleContext(Rpc_methodContext.class, i);
    }

    public Rpc_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rpc_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterRpc_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitRpc_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitRpc_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Rpc_declContext rpc_decl() throws RecognitionException {
    Rpc_declContext _localctx = new Rpc_declContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_rpc_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(150);
        match(RPC_SERVICE);
        setState(151);
        identifier();
        setState(152);
        match(LC);
        setState(154);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(153);
              rpc_method();
            }
          }
          setState(156);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536879102L) != 0));
        setState(158);
        match(RC);
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
  public static class Rpc_methodContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public TerminalNode LP() {
      return getToken(FlatBuffersParser.LP, 0);
    }

    public TerminalNode RP() {
      return getToken(FlatBuffersParser.RP, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public MetadataContext metadata() {
      return getRuleContext(MetadataContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public Rpc_methodContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rpc_method;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterRpc_method(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitRpc_method(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitRpc_method(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Rpc_methodContext rpc_method() throws RecognitionException {
    Rpc_methodContext _localctx = new Rpc_methodContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_rpc_method);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(160);
        identifier();
        setState(161);
        match(LP);
        setState(162);
        identifier();
        setState(163);
        match(RP);
        setState(164);
        match(COLON);
        setState(165);
        identifier();
        setState(166);
        metadata();
        setState(167);
        match(SEMI);
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
    public TerminalNode LB() {
      return getToken(FlatBuffersParser.LB, 0);
    }

    public Type_Context type_() {
      return getRuleContext(Type_Context.class, 0);
    }

    public TerminalNode RB() {
      return getToken(FlatBuffersParser.RB, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public Integer_constContext integer_const() {
      return getRuleContext(Integer_constContext.class, 0);
    }

    public TerminalNode BASE_TYPE_NAME() {
      return getToken(FlatBuffersParser.BASE_TYPE_NAME, 0);
    }

    public Ns_identContext ns_ident() {
      return getRuleContext(Ns_identContext.class, 0);
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
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterType_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener) ((FlatBuffersListener) listener).exitType_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitType_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Type_Context type_() throws RecognitionException {
    Type_Context _localctx = new Type_Context(_ctx, getState());
    enterRule(_localctx, 22, RULE_type_);
    int _la;
    try {
      setState(179);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LB:
          enterOuterAlt(_localctx, 1);
          {
            setState(169);
            match(LB);
            setState(170);
            type_();
            setState(173);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == COLON) {
              {
                setState(171);
                match(COLON);
                setState(172);
                integer_const();
              }
            }

            setState(175);
            match(RB);
          }
          break;
        case BASE_TYPE_NAME:
          enterOuterAlt(_localctx, 2);
          {
            setState(177);
            match(BASE_TYPE_NAME);
          }
          break;
        case ATTRIBUTE:
        case ENUM:
        case FILE_EXTENSION:
        case FILE_IDENTIFIER:
        case INCLUDE:
        case NATIVE_INCLUDE:
        case NAMESPACE:
        case ROOT_TYPE:
        case RPC_SERVICE:
        case STRUCT:
        case TABLE:
        case UNION:
        case IDENT:
          enterOuterAlt(_localctx, 3);
          {
            setState(178);
            ns_ident();
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
  public static class Enumval_declContext extends ParserRuleContext {
    public Ns_identContext ns_ident() {
      return getRuleContext(Ns_identContext.class, 0);
    }

    public TerminalNode EQ() {
      return getToken(FlatBuffersParser.EQ, 0);
    }

    public Integer_constContext integer_const() {
      return getRuleContext(Integer_constContext.class, 0);
    }

    public Enumval_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumval_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterEnumval_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitEnumval_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitEnumval_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Enumval_declContext enumval_decl() throws RecognitionException {
    Enumval_declContext _localctx = new Enumval_declContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_enumval_decl);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(181);
        ns_ident();
        setState(184);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EQ) {
          {
            setState(182);
            match(EQ);
            setState(183);
            integer_const();
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
  public static class Commasep_enumval_declContext extends ParserRuleContext {
    public List<Enumval_declContext> enumval_decl() {
      return getRuleContexts(Enumval_declContext.class);
    }

    public Enumval_declContext enumval_decl(int i) {
      return getRuleContext(Enumval_declContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(FlatBuffersParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(FlatBuffersParser.COMMA, i);
    }

    public Commasep_enumval_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_commasep_enumval_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterCommasep_enumval_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitCommasep_enumval_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitCommasep_enumval_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Commasep_enumval_declContext commasep_enumval_decl() throws RecognitionException {
    Commasep_enumval_declContext _localctx = new Commasep_enumval_declContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_commasep_enumval_decl);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(186);
        enumval_decl();
        setState(191);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(187);
                match(COMMA);
                setState(188);
                enumval_decl();
              }
            }
          }
          setState(193);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
        }
        setState(195);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(194);
            match(COMMA);
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
  public static class Unionval_with_opt_aliasContext extends ParserRuleContext {
    public List<Ns_identContext> ns_ident() {
      return getRuleContexts(Ns_identContext.class);
    }

    public Ns_identContext ns_ident(int i) {
      return getRuleContext(Ns_identContext.class, i);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public TerminalNode EQ() {
      return getToken(FlatBuffersParser.EQ, 0);
    }

    public Integer_constContext integer_const() {
      return getRuleContext(Integer_constContext.class, 0);
    }

    public Unionval_with_opt_aliasContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionval_with_opt_alias;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterUnionval_with_opt_alias(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitUnionval_with_opt_alias(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitUnionval_with_opt_alias(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Unionval_with_opt_aliasContext unionval_with_opt_alias()
      throws RecognitionException {
    Unionval_with_opt_aliasContext _localctx = new Unionval_with_opt_aliasContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_unionval_with_opt_alias);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(197);
        ns_ident();
        setState(200);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COLON) {
          {
            setState(198);
            match(COLON);
            setState(199);
            ns_ident();
          }
        }

        setState(204);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EQ) {
          {
            setState(202);
            match(EQ);
            setState(203);
            integer_const();
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
  public static class Commasep_unionval_with_opt_aliasContext extends ParserRuleContext {
    public List<Unionval_with_opt_aliasContext> unionval_with_opt_alias() {
      return getRuleContexts(Unionval_with_opt_aliasContext.class);
    }

    public Unionval_with_opt_aliasContext unionval_with_opt_alias(int i) {
      return getRuleContext(Unionval_with_opt_aliasContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(FlatBuffersParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(FlatBuffersParser.COMMA, i);
    }

    public Commasep_unionval_with_opt_aliasContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_commasep_unionval_with_opt_alias;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterCommasep_unionval_with_opt_alias(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitCommasep_unionval_with_opt_alias(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor)
            .visitCommasep_unionval_with_opt_alias(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Commasep_unionval_with_opt_aliasContext commasep_unionval_with_opt_alias()
      throws RecognitionException {
    Commasep_unionval_with_opt_aliasContext _localctx =
        new Commasep_unionval_with_opt_aliasContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_commasep_unionval_with_opt_alias);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(206);
        unionval_with_opt_alias();
        setState(211);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(207);
                match(COMMA);
                setState(208);
                unionval_with_opt_alias();
              }
            }
          }
          setState(213);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
        }
        setState(215);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(214);
            match(COMMA);
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
  public static class Ident_with_opt_single_valueContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public Single_valueContext single_value() {
      return getRuleContext(Single_valueContext.class, 0);
    }

    public Ident_with_opt_single_valueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ident_with_opt_single_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterIdent_with_opt_single_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitIdent_with_opt_single_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitIdent_with_opt_single_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Ident_with_opt_single_valueContext ident_with_opt_single_value()
      throws RecognitionException {
    Ident_with_opt_single_valueContext _localctx =
        new Ident_with_opt_single_valueContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_ident_with_opt_single_value);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(217);
        identifier();
        setState(220);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COLON) {
          {
            setState(218);
            match(COLON);
            setState(219);
            single_value();
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
  public static class Commasep_ident_with_opt_single_valueContext extends ParserRuleContext {
    public List<Ident_with_opt_single_valueContext> ident_with_opt_single_value() {
      return getRuleContexts(Ident_with_opt_single_valueContext.class);
    }

    public Ident_with_opt_single_valueContext ident_with_opt_single_value(int i) {
      return getRuleContext(Ident_with_opt_single_valueContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(FlatBuffersParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(FlatBuffersParser.COMMA, i);
    }

    public Commasep_ident_with_opt_single_valueContext(
        ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_commasep_ident_with_opt_single_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterCommasep_ident_with_opt_single_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitCommasep_ident_with_opt_single_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor)
            .visitCommasep_ident_with_opt_single_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Commasep_ident_with_opt_single_valueContext commasep_ident_with_opt_single_value()
      throws RecognitionException {
    Commasep_ident_with_opt_single_valueContext _localctx =
        new Commasep_ident_with_opt_single_valueContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_commasep_ident_with_opt_single_value);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(222);
        ident_with_opt_single_value();
        setState(227);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(223);
              match(COMMA);
              setState(224);
              ident_with_opt_single_value();
            }
          }
          setState(229);
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
  public static class MetadataContext extends ParserRuleContext {
    public TerminalNode LP() {
      return getToken(FlatBuffersParser.LP, 0);
    }

    public Commasep_ident_with_opt_single_valueContext commasep_ident_with_opt_single_value() {
      return getRuleContext(Commasep_ident_with_opt_single_valueContext.class, 0);
    }

    public TerminalNode RP() {
      return getToken(FlatBuffersParser.RP, 0);
    }

    public MetadataContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_metadata;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterMetadata(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitMetadata(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitMetadata(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MetadataContext metadata() throws RecognitionException {
    MetadataContext _localctx = new MetadataContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_metadata);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(234);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LP) {
          {
            setState(230);
            match(LP);
            setState(231);
            commasep_ident_with_opt_single_value();
            setState(232);
            match(RP);
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
  public static class ScalarContext extends ParserRuleContext {
    public TerminalNode INTEGER_CONSTANT() {
      return getToken(FlatBuffersParser.INTEGER_CONSTANT, 0);
    }

    public TerminalNode HEX_INTEGER_CONSTANT() {
      return getToken(FlatBuffersParser.HEX_INTEGER_CONSTANT, 0);
    }

    public TerminalNode FLOAT_CONSTANT() {
      return getToken(FlatBuffersParser.FLOAT_CONSTANT, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ScalarContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_scalar;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterScalar(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitScalar(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitScalar(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ScalarContext scalar() throws RecognitionException {
    ScalarContext _localctx = new ScalarContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_scalar);
    try {
      setState(240);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case INTEGER_CONSTANT:
          enterOuterAlt(_localctx, 1);
          {
            setState(236);
            match(INTEGER_CONSTANT);
          }
          break;
        case HEX_INTEGER_CONSTANT:
          enterOuterAlt(_localctx, 2);
          {
            setState(237);
            match(HEX_INTEGER_CONSTANT);
          }
          break;
        case FLOAT_CONSTANT:
          enterOuterAlt(_localctx, 3);
          {
            setState(238);
            match(FLOAT_CONSTANT);
          }
          break;
        case ATTRIBUTE:
        case ENUM:
        case FILE_EXTENSION:
        case FILE_IDENTIFIER:
        case INCLUDE:
        case NATIVE_INCLUDE:
        case NAMESPACE:
        case ROOT_TYPE:
        case RPC_SERVICE:
        case STRUCT:
        case TABLE:
        case UNION:
        case IDENT:
          enterOuterAlt(_localctx, 4);
          {
            setState(239);
            identifier();
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
  public static class Object_Context extends ParserRuleContext {
    public TerminalNode LC() {
      return getToken(FlatBuffersParser.LC, 0);
    }

    public Commasep_ident_with_valueContext commasep_ident_with_value() {
      return getRuleContext(Commasep_ident_with_valueContext.class, 0);
    }

    public TerminalNode RC() {
      return getToken(FlatBuffersParser.RC, 0);
    }

    public Object_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_object_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterObject_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitObject_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitObject_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Object_Context object_() throws RecognitionException {
    Object_Context _localctx = new Object_Context(_ctx, getState());
    enterRule(_localctx, 40, RULE_object_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(242);
        match(LC);
        setState(243);
        commasep_ident_with_value();
        setState(244);
        match(RC);
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
  public static class Ident_with_valueContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(FlatBuffersParser.COLON, 0);
    }

    public ValueContext value() {
      return getRuleContext(ValueContext.class, 0);
    }

    public Ident_with_valueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ident_with_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterIdent_with_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitIdent_with_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitIdent_with_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Ident_with_valueContext ident_with_value() throws RecognitionException {
    Ident_with_valueContext _localctx = new Ident_with_valueContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_ident_with_value);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(246);
        identifier();
        setState(247);
        match(COLON);
        setState(248);
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
  public static class Commasep_ident_with_valueContext extends ParserRuleContext {
    public List<Ident_with_valueContext> ident_with_value() {
      return getRuleContexts(Ident_with_valueContext.class);
    }

    public Ident_with_valueContext ident_with_value(int i) {
      return getRuleContext(Ident_with_valueContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(FlatBuffersParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(FlatBuffersParser.COMMA, i);
    }

    public Commasep_ident_with_valueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_commasep_ident_with_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterCommasep_ident_with_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitCommasep_ident_with_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitCommasep_ident_with_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Commasep_ident_with_valueContext commasep_ident_with_value()
      throws RecognitionException {
    Commasep_ident_with_valueContext _localctx =
        new Commasep_ident_with_valueContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_commasep_ident_with_value);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(250);
        ident_with_value();
        setState(255);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(251);
                match(COMMA);
                setState(252);
                ident_with_value();
              }
            }
          }
          setState(257);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 21, _ctx);
        }
        setState(259);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(258);
            match(COMMA);
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
  public static class Single_valueContext extends ParserRuleContext {
    public ScalarContext scalar() {
      return getRuleContext(ScalarContext.class, 0);
    }

    public TerminalNode STRING_CONSTANT() {
      return getToken(FlatBuffersParser.STRING_CONSTANT, 0);
    }

    public Single_valueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_single_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterSingle_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitSingle_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitSingle_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Single_valueContext single_value() throws RecognitionException {
    Single_valueContext _localctx = new Single_valueContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_single_value);
    try {
      setState(263);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ATTRIBUTE:
        case ENUM:
        case FILE_EXTENSION:
        case FILE_IDENTIFIER:
        case INCLUDE:
        case NATIVE_INCLUDE:
        case NAMESPACE:
        case ROOT_TYPE:
        case RPC_SERVICE:
        case STRUCT:
        case TABLE:
        case UNION:
        case INTEGER_CONSTANT:
        case IDENT:
        case HEX_INTEGER_CONSTANT:
        case FLOAT_CONSTANT:
          enterOuterAlt(_localctx, 1);
          {
            setState(261);
            scalar();
          }
          break;
        case STRING_CONSTANT:
          enterOuterAlt(_localctx, 2);
          {
            setState(262);
            match(STRING_CONSTANT);
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
  public static class ValueContext extends ParserRuleContext {
    public Single_valueContext single_value() {
      return getRuleContext(Single_valueContext.class, 0);
    }

    public Object_Context object_() {
      return getRuleContext(Object_Context.class, 0);
    }

    public TerminalNode LB() {
      return getToken(FlatBuffersParser.LB, 0);
    }

    public Commasep_valueContext commasep_value() {
      return getRuleContext(Commasep_valueContext.class, 0);
    }

    public TerminalNode RB() {
      return getToken(FlatBuffersParser.RB, 0);
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
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener) ((FlatBuffersListener) listener).exitValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ValueContext value() throws RecognitionException {
    ValueContext _localctx = new ValueContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_value);
    try {
      setState(271);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ATTRIBUTE:
        case ENUM:
        case FILE_EXTENSION:
        case FILE_IDENTIFIER:
        case INCLUDE:
        case NATIVE_INCLUDE:
        case NAMESPACE:
        case ROOT_TYPE:
        case RPC_SERVICE:
        case STRUCT:
        case TABLE:
        case UNION:
        case STRING_CONSTANT:
        case INTEGER_CONSTANT:
        case IDENT:
        case HEX_INTEGER_CONSTANT:
        case FLOAT_CONSTANT:
          enterOuterAlt(_localctx, 1);
          {
            setState(265);
            single_value();
          }
          break;
        case LC:
          enterOuterAlt(_localctx, 2);
          {
            setState(266);
            object_();
          }
          break;
        case LB:
          enterOuterAlt(_localctx, 3);
          {
            setState(267);
            match(LB);
            setState(268);
            commasep_value();
            setState(269);
            match(RB);
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
  public static class Commasep_valueContext extends ParserRuleContext {
    public List<ValueContext> value() {
      return getRuleContexts(ValueContext.class);
    }

    public ValueContext value(int i) {
      return getRuleContext(ValueContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(FlatBuffersParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(FlatBuffersParser.COMMA, i);
    }

    public Commasep_valueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_commasep_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterCommasep_value(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitCommasep_value(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitCommasep_value(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Commasep_valueContext commasep_value() throws RecognitionException {
    Commasep_valueContext _localctx = new Commasep_valueContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_commasep_value);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(273);
        value();
        setState(278);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(274);
                match(COMMA);
                setState(275);
                value();
              }
            }
          }
          setState(280);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
        }
        setState(282);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(281);
            match(COMMA);
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
  public static class File_extension_declContext extends ParserRuleContext {
    public TerminalNode FILE_EXTENSION() {
      return getToken(FlatBuffersParser.FILE_EXTENSION, 0);
    }

    public TerminalNode STRING_CONSTANT() {
      return getToken(FlatBuffersParser.STRING_CONSTANT, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public File_extension_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_file_extension_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterFile_extension_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitFile_extension_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitFile_extension_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final File_extension_declContext file_extension_decl() throws RecognitionException {
    File_extension_declContext _localctx = new File_extension_declContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_file_extension_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(284);
        match(FILE_EXTENSION);
        setState(285);
        match(STRING_CONSTANT);
        setState(286);
        match(SEMI);
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
  public static class File_identifier_declContext extends ParserRuleContext {
    public TerminalNode FILE_IDENTIFIER() {
      return getToken(FlatBuffersParser.FILE_IDENTIFIER, 0);
    }

    public TerminalNode STRING_CONSTANT() {
      return getToken(FlatBuffersParser.STRING_CONSTANT, 0);
    }

    public TerminalNode SEMI() {
      return getToken(FlatBuffersParser.SEMI, 0);
    }

    public File_identifier_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_file_identifier_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterFile_identifier_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitFile_identifier_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitFile_identifier_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final File_identifier_declContext file_identifier_decl() throws RecognitionException {
    File_identifier_declContext _localctx = new File_identifier_declContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_file_identifier_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(288);
        match(FILE_IDENTIFIER);
        setState(289);
        match(STRING_CONSTANT);
        setState(290);
        match(SEMI);
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
  public static class Ns_identContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> DOT() {
      return getTokens(FlatBuffersParser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(FlatBuffersParser.DOT, i);
    }

    public Ns_identContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ns_ident;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterNs_ident(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitNs_ident(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitNs_ident(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Ns_identContext ns_ident() throws RecognitionException {
    Ns_identContext _localctx = new Ns_identContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_ns_ident);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(292);
        identifier();
        setState(297);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == DOT) {
          {
            {
              setState(293);
              match(DOT);
              setState(294);
              identifier();
            }
          }
          setState(299);
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
  public static class Integer_constContext extends ParserRuleContext {
    public TerminalNode INTEGER_CONSTANT() {
      return getToken(FlatBuffersParser.INTEGER_CONSTANT, 0);
    }

    public TerminalNode HEX_INTEGER_CONSTANT() {
      return getToken(FlatBuffersParser.HEX_INTEGER_CONSTANT, 0);
    }

    public Integer_constContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_integer_const;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterInteger_const(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitInteger_const(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitInteger_const(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Integer_constContext integer_const() throws RecognitionException {
    Integer_constContext _localctx = new Integer_constContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_integer_const);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(300);
        _la = _input.LA(1);
        if (!(_la == INTEGER_CONSTANT || _la == HEX_INTEGER_CONSTANT)) {
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
  public static class IdentifierContext extends ParserRuleContext {
    public TerminalNode IDENT() {
      return getToken(FlatBuffersParser.IDENT, 0);
    }

    public KeywordsContext keywords() {
      return getRuleContext(KeywordsContext.class, 0);
    }

    public IdentifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_identifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitIdentifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitIdentifier(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdentifierContext identifier() throws RecognitionException {
    IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_identifier);
    try {
      setState(304);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case IDENT:
          enterOuterAlt(_localctx, 1);
          {
            setState(302);
            match(IDENT);
          }
          break;
        case ATTRIBUTE:
        case ENUM:
        case FILE_EXTENSION:
        case FILE_IDENTIFIER:
        case INCLUDE:
        case NATIVE_INCLUDE:
        case NAMESPACE:
        case ROOT_TYPE:
        case RPC_SERVICE:
        case STRUCT:
        case TABLE:
        case UNION:
          enterOuterAlt(_localctx, 2);
          {
            setState(303);
            keywords();
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
  public static class KeywordsContext extends ParserRuleContext {
    public TerminalNode ATTRIBUTE() {
      return getToken(FlatBuffersParser.ATTRIBUTE, 0);
    }

    public TerminalNode ENUM() {
      return getToken(FlatBuffersParser.ENUM, 0);
    }

    public TerminalNode FILE_EXTENSION() {
      return getToken(FlatBuffersParser.FILE_EXTENSION, 0);
    }

    public TerminalNode FILE_IDENTIFIER() {
      return getToken(FlatBuffersParser.FILE_IDENTIFIER, 0);
    }

    public TerminalNode INCLUDE() {
      return getToken(FlatBuffersParser.INCLUDE, 0);
    }

    public TerminalNode NATIVE_INCLUDE() {
      return getToken(FlatBuffersParser.NATIVE_INCLUDE, 0);
    }

    public TerminalNode NAMESPACE() {
      return getToken(FlatBuffersParser.NAMESPACE, 0);
    }

    public TerminalNode ROOT_TYPE() {
      return getToken(FlatBuffersParser.ROOT_TYPE, 0);
    }

    public TerminalNode RPC_SERVICE() {
      return getToken(FlatBuffersParser.RPC_SERVICE, 0);
    }

    public TerminalNode STRUCT() {
      return getToken(FlatBuffersParser.STRUCT, 0);
    }

    public TerminalNode TABLE() {
      return getToken(FlatBuffersParser.TABLE, 0);
    }

    public TerminalNode UNION() {
      return getToken(FlatBuffersParser.UNION, 0);
    }

    public KeywordsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keywords;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).enterKeywords(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof FlatBuffersListener)
        ((FlatBuffersListener) listener).exitKeywords(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof FlatBuffersVisitor)
        return ((FlatBuffersVisitor<? extends T>) visitor).visitKeywords(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeywordsContext keywords() throws RecognitionException {
    KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_keywords);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(306);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 8190L) != 0))) {
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

  public static final String _serializedATN =
      "\u0004\u0001\"\u0135\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0002\u001f\u0007\u001f\u0001\u0000\u0005\u0000B\b\u0000\n\u0000\f\u0000"
          + "E\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"
          + "Q\b\u0000\n\u0000\f\u0000T\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0002\u0005\u0002`\b\u0002\n\u0002\f\u0002c\t\u0002\u0001\u0002"
          + "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004p\b\u0004"
          + "\n\u0004\f\u0004s\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0003\u0005{\b\u0005\u0001\u0005\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"
          + "\b\u0092\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004"
          + "\t\u009b\b\t\u000b\t\f\t\u009c\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"
          + "\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0003\u000b\u00ae\b\u000b\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0003\u000b\u00b4\b\u000b\u0001\f\u0001\f\u0001"
          + "\f\u0003\f\u00b9\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00be\b\r\n\r\f\r"
          + "\u00c1\t\r\u0001\r\u0003\r\u00c4\b\r\u0001\u000e\u0001\u000e\u0001\u000e"
          + "\u0003\u000e\u00c9\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cd\b"
          + "\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00d2\b\u000f\n"
          + "\u000f\f\u000f\u00d5\t\u000f\u0001\u000f\u0003\u000f\u00d8\b\u000f\u0001"
          + "\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00dd\b\u0010\u0001\u0011\u0001"
          + "\u0011\u0001\u0011\u0005\u0011\u00e2\b\u0011\n\u0011\f\u0011\u00e5\t\u0011"
          + "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00eb\b\u0012"
          + "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00f1\b\u0013"
          + "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"
          + "\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"
          + "\u00fe\b\u0016\n\u0016\f\u0016\u0101\t\u0016\u0001\u0016\u0003\u0016\u0104"
          + "\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0108\b\u0017\u0001\u0018"
          + "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"
          + "\u0110\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0115\b"
          + "\u0019\n\u0019\f\u0019\u0118\t\u0019\u0001\u0019\u0003\u0019\u011b\b\u0019"
          + "\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"
          + "\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c"
          + "\u0128\b\u001c\n\u001c\f\u001c\u012b\t\u001c\u0001\u001d\u0001\u001d\u0001"
          + "\u001e\u0001\u001e\u0003\u001e\u0131\b\u001e\u0001\u001f\u0001\u001f\u0001"
          + "\u001f\u0000\u0000 \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"
          + "\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0004\u0001\u0000"
          + "\u0005\u0006\u0001\u0000\n\u000b\u0002\u0000\u001c\u001c\u001e\u001e\u0001"
          + "\u0000\u0001\f\u013d\u0000C\u0001\u0000\u0000\u0000\u0002W\u0001\u0000"
          + "\u0000\u0000\u0004[\u0001\u0000\u0000\u0000\u0006f\u0001\u0000\u0000\u0000"
          + "\bj\u0001\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\f\u0081\u0001\u0000"
          + "\u0000\u0000\u000e\u0088\u0001\u0000\u0000\u0000\u0010\u008c\u0001\u0000"
          + "\u0000\u0000\u0012\u0096\u0001\u0000\u0000\u0000\u0014\u00a0\u0001\u0000"
          + "\u0000\u0000\u0016\u00b3\u0001\u0000\u0000\u0000\u0018\u00b5\u0001\u0000"
          + "\u0000\u0000\u001a\u00ba\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000"
          + "\u0000\u0000\u001e\u00ce\u0001\u0000\u0000\u0000 \u00d9\u0001\u0000\u0000"
          + "\u0000\"\u00de\u0001\u0000\u0000\u0000$\u00ea\u0001\u0000\u0000\u0000"
          + "&\u00f0\u0001\u0000\u0000\u0000(\u00f2\u0001\u0000\u0000\u0000*\u00f6"
          + "\u0001\u0000\u0000\u0000,\u00fa\u0001\u0000\u0000\u0000.\u0107\u0001\u0000"
          + "\u0000\u00000\u010f\u0001\u0000\u0000\u00002\u0111\u0001\u0000\u0000\u0000"
          + "4\u011c\u0001\u0000\u0000\u00006\u0120\u0001\u0000\u0000\u00008\u0124"
          + "\u0001\u0000\u0000\u0000:\u012c\u0001\u0000\u0000\u0000<\u0130\u0001\u0000"
          + "\u0000\u0000>\u0132\u0001\u0000\u0000\u0000@B\u0003\u0002\u0001\u0000"
          + "A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"
          + "\u0000CD\u0001\u0000\u0000\u0000DR\u0001\u0000\u0000\u0000EC\u0001\u0000"
          + "\u0000\u0000FQ\u0003\u0004\u0002\u0000GQ\u0003\b\u0004\u0000HQ\u0003\n"
          + "\u0005\u0000IQ\u0003\f\u0006\u0000JQ\u0003\u000e\u0007\u0000KQ\u00034"
          + "\u001a\u0000LQ\u00036\u001b\u0000MQ\u0003\u0006\u0003\u0000NQ\u0003\u0012"
          + "\t\u0000OQ\u0003(\u0014\u0000PF\u0001\u0000\u0000\u0000PG\u0001\u0000"
          + "\u0000\u0000PH\u0001\u0000\u0000\u0000PI\u0001\u0000\u0000\u0000PJ\u0001"
          + "\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000PL\u0001\u0000\u0000\u0000"
          + "PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000"
          + "\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"
          + "\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005"
          + "\u0000\u0000\u0001V\u0001\u0001\u0000\u0000\u0000WX\u0007\u0000\u0000"
          + "\u0000XY\u0005\u001a\u0000\u0000YZ\u0005\r\u0000\u0000Z\u0003\u0001\u0000"
          + "\u0000\u0000[\\\u0005\u0007\u0000\u0000\\a\u0003<\u001e\u0000]^\u0005"
          + "\u0015\u0000\u0000^`\u0003<\u001e\u0000_]\u0001\u0000\u0000\u0000`c\u0001"
          + "\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"
          + "bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005\r\u0000\u0000"
          + "e\u0005\u0001\u0000\u0000\u0000fg\u0005\u0001\u0000\u0000gh\u0005\u001a"
          + "\u0000\u0000hi\u0005\r\u0000\u0000i\u0007\u0001\u0000\u0000\u0000jk\u0007"
          + "\u0001\u0000\u0000kl\u0003<\u001e\u0000lm\u0003$\u0012\u0000mq\u0005\u0013"
          + "\u0000\u0000np\u0003\u0010\b\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000"
          + "\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001"
          + "\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0014\u0000\u0000"
          + "u\t\u0001\u0000\u0000\u0000vw\u0005\u0002\u0000\u0000wz\u0003<\u001e\u0000"
          + "xy\u0005\u0017\u0000\u0000y{\u0003\u0016\u000b\u0000zx\u0001\u0000\u0000"
          + "\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0003$\u0012"
          + "\u0000}~\u0005\u0013\u0000\u0000~\u007f\u0003\u001a\r\u0000\u007f\u0080"
          + "\u0005\u0014\u0000\u0000\u0080\u000b\u0001\u0000\u0000\u0000\u0081\u0082"
          + "\u0005\f\u0000\u0000\u0082\u0083\u0003<\u001e\u0000\u0083\u0084\u0003"
          + "$\u0012\u0000\u0084\u0085\u0005\u0013\u0000\u0000\u0085\u0086\u0003\u001e"
          + "\u000f\u0000\u0086\u0087\u0005\u0014\u0000\u0000\u0087\r\u0001\u0000\u0000"
          + "\u0000\u0088\u0089\u0005\b\u0000\u0000\u0089\u008a\u0003<\u001e\u0000"
          + "\u008a\u008b\u0005\r\u0000\u0000\u008b\u000f\u0001\u0000\u0000\u0000\u008c"
          + "\u008d\u0003<\u001e\u0000\u008d\u008e\u0005\u0017\u0000\u0000\u008e\u0091"
          + "\u0003\u0016\u000b\u0000\u008f\u0090\u0005\u000e\u0000\u0000\u0090\u0092"
          + "\u0003&\u0013\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001"
          + "\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0003"
          + "$\u0012\u0000\u0094\u0095\u0005\r\u0000\u0000\u0095\u0011\u0001\u0000"
          + "\u0000\u0000\u0096\u0097\u0005\t\u0000\u0000\u0097\u0098\u0003<\u001e"
          + "\u0000\u0098\u009a\u0005\u0013\u0000\u0000\u0099\u009b\u0003\u0014\n\u0000"
          + "\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"
          + "\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"
          + "\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0014\u0000\u0000"
          + "\u009f\u0013\u0001\u0000\u0000\u0000\u00a0\u00a1\u0003<\u001e\u0000\u00a1"
          + "\u00a2\u0005\u000f\u0000\u0000\u00a2\u00a3\u0003<\u001e\u0000\u00a3\u00a4"
          + "\u0005\u0010\u0000\u0000\u00a4\u00a5\u0005\u0017\u0000\u0000\u00a5\u00a6"
          + "\u0003<\u001e\u0000\u00a6\u00a7\u0003$\u0012\u0000\u00a7\u00a8\u0005\r"
          + "\u0000\u0000\u00a8\u0015\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0011"
          + "\u0000\u0000\u00aa\u00ad\u0003\u0016\u000b\u0000\u00ab\u00ac\u0005\u0017"
          + "\u0000\u0000\u00ac\u00ae\u0003:\u001d\u0000\u00ad\u00ab\u0001\u0000\u0000"
          + "\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"
          + "\u0000\u00af\u00b0\u0005\u0012\u0000\u0000\u00b0\u00b4\u0001\u0000\u0000"
          + "\u0000\u00b1\u00b4\u0005\u001b\u0000\u0000\u00b2\u00b4\u00038\u001c\u0000"
          + "\u00b3\u00a9\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000"
          + "\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u0017\u0001\u0000\u0000\u0000"
          + "\u00b5\u00b8\u00038\u001c\u0000\u00b6\u00b7\u0005\u000e\u0000\u0000\u00b7"
          + "\u00b9\u0003:\u001d\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9"
          + "\u0001\u0000\u0000\u0000\u00b9\u0019\u0001\u0000\u0000\u0000\u00ba\u00bf"
          + "\u0003\u0018\f\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00be\u0003"
          + "\u0018\f\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"
          + "\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"
          + "\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"
          + "\u0000\u0000\u00c2\u00c4\u0005\u0016\u0000\u0000\u00c3\u00c2\u0001\u0000"
          + "\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u001b\u0001\u0000"
          + "\u0000\u0000\u00c5\u00c8\u00038\u001c\u0000\u00c6\u00c7\u0005\u0017\u0000"
          + "\u0000\u00c7\u00c9\u00038\u001c\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000"
          + "\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000"
          + "\u00ca\u00cb\u0005\u000e\u0000\u0000\u00cb\u00cd\u0003:\u001d\u0000\u00cc"
          + "\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"
          + "\u001d\u0001\u0000\u0000\u0000\u00ce\u00d3\u0003\u001c\u000e\u0000\u00cf"
          + "\u00d0\u0005\u0016\u0000\u0000\u00d0\u00d2\u0003\u001c\u000e\u0000\u00d1"
          + "\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3"
          + "\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4"
          + "\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6"
          + "\u00d8\u0005\u0016\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d7"
          + "\u00d8\u0001\u0000\u0000\u0000\u00d8\u001f\u0001\u0000\u0000\u0000\u00d9"
          + "\u00dc\u0003<\u001e\u0000\u00da\u00db\u0005\u0017\u0000\u0000\u00db\u00dd"
          + "\u0003.\u0017\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001"
          + "\u0000\u0000\u0000\u00dd!\u0001\u0000\u0000\u0000\u00de\u00e3\u0003 \u0010"
          + "\u0000\u00df\u00e0\u0005\u0016\u0000\u0000\u00e0\u00e2\u0003 \u0010\u0000"
          + "\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"
          + "\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"
          + "\u00e4#\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6"
          + "\u00e7\u0005\u000f\u0000\u0000\u00e7\u00e8\u0003\"\u0011\u0000\u00e8\u00e9"
          + "\u0005\u0010\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e6"
          + "\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb%\u0001"
          + "\u0000\u0000\u0000\u00ec\u00f1\u0005\u001c\u0000\u0000\u00ed\u00f1\u0005"
          + "\u001e\u0000\u0000\u00ee\u00f1\u0005\u001f\u0000\u0000\u00ef\u00f1\u0003"
          + "<\u001e\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000\u00f0\u00ed\u0001\u0000"
          + "\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001\u0000"
          + "\u0000\u0000\u00f1\'\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0013\u0000"
          + "\u0000\u00f3\u00f4\u0003,\u0016\u0000\u00f4\u00f5\u0005\u0014\u0000\u0000"
          + "\u00f5)\u0001\u0000\u0000\u0000\u00f6\u00f7\u0003<\u001e\u0000\u00f7\u00f8"
          + "\u0005\u0017\u0000\u0000\u00f8\u00f9\u00030\u0018\u0000\u00f9+\u0001\u0000"
          + "\u0000\u0000\u00fa\u00ff\u0003*\u0015\u0000\u00fb\u00fc\u0005\u0016\u0000"
          + "\u0000\u00fc\u00fe\u0003*\u0015\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000"
          + "\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000"
          + "\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000"
          + "\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0104\u0005\u0016\u0000\u0000"
          + "\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"
          + "\u0104-\u0001\u0000\u0000\u0000\u0105\u0108\u0003&\u0013\u0000\u0106\u0108"
          + "\u0005\u001a\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0106"
          + "\u0001\u0000\u0000\u0000\u0108/\u0001\u0000\u0000\u0000\u0109\u0110\u0003"
          + ".\u0017\u0000\u010a\u0110\u0003(\u0014\u0000\u010b\u010c\u0005\u0011\u0000"
          + "\u0000\u010c\u010d\u00032\u0019\u0000\u010d\u010e\u0005\u0012\u0000\u0000"
          + "\u010e\u0110\u0001\u0000\u0000\u0000\u010f\u0109\u0001\u0000\u0000\u0000"
          + "\u010f\u010a\u0001\u0000\u0000\u0000\u010f\u010b\u0001\u0000\u0000\u0000"
          + "\u01101\u0001\u0000\u0000\u0000\u0111\u0116\u00030\u0018\u0000\u0112\u0113"
          + "\u0005\u0016\u0000\u0000\u0113\u0115\u00030\u0018\u0000\u0114\u0112\u0001"
          + "\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114\u0001"
          + "\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u011a\u0001"
          + "\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011b\u0005"
          + "\u0016\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001"
          + "\u0000\u0000\u0000\u011b3\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u0003"
          + "\u0000\u0000\u011d\u011e\u0005\u001a\u0000\u0000\u011e\u011f\u0005\r\u0000"
          + "\u0000\u011f5\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0004\u0000\u0000"
          + "\u0121\u0122\u0005\u001a\u0000\u0000\u0122\u0123\u0005\r\u0000\u0000\u0123"
          + "7\u0001\u0000\u0000\u0000\u0124\u0129\u0003<\u001e\u0000\u0125\u0126\u0005"
          + "\u0015\u0000\u0000\u0126\u0128\u0003<\u001e\u0000\u0127\u0125\u0001\u0000"
          + "\u0000\u0000\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000"
          + "\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a9\u0001\u0000\u0000"
          + "\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u012d\u0007\u0002\u0000"
          + "\u0000\u012d;\u0001\u0000\u0000\u0000\u012e\u0131\u0005\u001d\u0000\u0000"
          + "\u012f\u0131\u0003>\u001f\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130"
          + "\u012f\u0001\u0000\u0000\u0000\u0131=\u0001\u0000\u0000\u0000\u0132\u0133"
          + "\u0007\u0003\u0000\u0000\u0133?\u0001\u0000\u0000\u0000\u001dCPRaqz\u0091"
          + "\u009c\u00ad\u00b3\u00b8\u00bf\u00c3\u00c8\u00cc\u00d3\u00d7\u00dc\u00e3"
          + "\u00ea\u00f0\u00ff\u0103\u0107\u010f\u0116\u011a\u0129\u0130";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
