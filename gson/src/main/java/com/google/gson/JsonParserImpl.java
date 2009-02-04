/* Generated By:JavaCC: Do not edit this line. JsonParserImpl.java */
package com.google.gson;

@SuppressWarnings("all")
final class JsonParserImpl implements JsonParserImplConstants {

  final public JsonElement parse() throws ParseException {
  JsonElement json = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 25:
      json = JsonObject();
      break;
    case 29:
      json = JsonArray();
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case BOOLEAN:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 31:
      json = JsonPrimitive();
      break;
    case NULL:
      json = JsonNull();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private JsonObject JsonObject() throws ParseException {
  JsonObject o = new JsonObject();
    jj_consume_token(25);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      Members(o);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(26);
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonNull JsonNull() throws ParseException {
  Token t;
    t = jj_consume_token(NULL);
               {if (true) return JsonNull.createJsonNull();}
    throw new Error("Missing return statement in function");
  }

  final private void Members(JsonObject o) throws ParseException {
    Pair(o);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 27:
      jj_consume_token(27);
      Members(o);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  final private void Pair(JsonObject o) throws ParseException {
  JsonPrimitive property;
  JsonElement value;
    property = JsonMemberName();
    jj_consume_token(28);
    value = JsonValue();
    o.add(property.getAsString(), value);
  }

  final private JsonPrimitive JsonMemberName() throws ParseException {
  Token t; JsonPrimitive value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                   {if (true) return new JsonPrimitive(t.image);}
      break;
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      value = JsonString();
                       {if (true) return value;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private JsonArray JsonArray() throws ParseException {
  JsonArray array = new JsonArray();
    jj_consume_token(29);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
    case NULL:
    case NAN:
    case INFINITY:
    case BOOLEAN:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 25:
    case 29:
    case 31:
      Elements(array);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(30);
    array.reverse();
    {if (true) return array;}
    throw new Error("Missing return statement in function");
  }

  final private void Elements(JsonArray array) throws ParseException {
  JsonElement element;
    element = JsonValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 27:
      jj_consume_token(27);
      Elements(array);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    array.add(element);
  }

  final private JsonElement JsonValue() throws ParseException {
  JsonElement o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      o = JsonString();
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case 31:
      o = JsonNumber();
      break;
    case 25:
      o = JsonObject();
      break;
    case 29:
      o = JsonArray();
      break;
    case BOOLEAN:
      o = JsonBoolean();
      break;
    case NULL:
      o = JsonNull();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonBoolean() throws ParseException {
  Token t;
    t = jj_consume_token(BOOLEAN);
    boolean value = Boolean.valueOf(t.image);
    {if (true) return new JsonPrimitive(value);}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonPrimitive() throws ParseException {
  JsonPrimitive value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      value = JsonString();
                          {if (true) return value;}
      break;
    case DIGITS:
    case NAN:
    case INFINITY:
    case 31:
      value = JsonNumber();
                          {if (true) return value;}
      break;
    case BOOLEAN:
      value = JsonBoolean();
                           {if (true) return value;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonNumber() throws ParseException {
  String intpart = null,
         fracpart = null,
         exppart = null;
  JsonPrimitive value;
    if (jj_2_1(2)) {
      value = JsonSpecialNumbers();
                                {if (true) return value;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGITS:
      case 31:
        intpart = JsonInt();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 32:
          fracpart = JsonFrac();
          break;
        default:
          jj_la1[8] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case E:
          exppart = JsonExp();
          break;
        default:
          jj_la1[9] = jj_gen;
          ;
        }
    Number n;
    if (exppart != null || fracpart != null) {
      fracpart = (fracpart == null) ? "" : fracpart;
      exppart = (exppart == null) ? "" : exppart;
      n = new java.math.BigDecimal(intpart + fracpart + exppart);
    } else {
      n = new java.math.BigInteger(intpart);
    }
    {if (true) return new JsonPrimitive(n);}
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonSpecialNumbers() throws ParseException {
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAN:
      jj_consume_token(NAN);
           {if (true) return new JsonPrimitive(Double.NaN);}
      break;
    case INFINITY:
    case 31:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 31:
        jj_consume_token(31);
         negative = true;
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      jj_consume_token(INFINITY);
                                        {if (true) return new JsonPrimitive(negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private String JsonInt() throws ParseException {
  String digits;
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
         negative = true;
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    digits = Digits();
    if(negative)
      {if (true) return "-" + digits;}
    {if (true) return digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonFrac() throws ParseException {
  String digits;
    jj_consume_token(32);
    digits = Digits();
    {if (true) return "." + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonExp() throws ParseException {
  Token t;
  String digits;
    t = jj_consume_token(E);
    digits = Digits();
    {if (true) return t.image + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String Digits() throws ParseException {
  Token t;
    t = jj_consume_token(DIGITS);
    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonString() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
      t = jj_consume_token(SINGLE_QUOTE_LITERAL);
      break;
    case DOUBLE_QUOTE_LITERAL:
      t = jj_consume_token(DOUBLE_QUOTE_LITERAL);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    String value = StringUnmarshaller.unmarshall(t.image);
    {if (true) return new JsonPrimitive(value);}
    throw new Error("Missing return statement in function");
  }

  final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  final private boolean jj_3R_4() {
    if (jj_scan_token(31)) return true;
    return false;
  }

  final private boolean jj_3R_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_4()) jj_scanpos = xsp;
    if (jj_scan_token(INFINITY)) return true;
    return false;
  }

  final private boolean jj_3_1() {
    if (jj_3R_1()) return true;
    return false;
  }

  final private boolean jj_3R_2() {
    if (jj_scan_token(NAN)) return true;
    return false;
  }

  final private boolean jj_3R_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_2()) {
    jj_scanpos = xsp;
    if (jj_3R_3()) return true;
    }
    return false;
  }

  public JsonParserImplTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xa20187c0,0x18800,0x8000000,0x18800,0xa20187c0,0x8000000,0xa20187c0,0x80018740,0x0,0x20,0x80000040,0x80000000,0x80000300,0x80000000,0x18000,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public JsonParserImpl(java.io.InputStream stream) {
     this(stream, null);
  }
  public JsonParserImpl(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JsonParserImplTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public JsonParserImpl(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JsonParserImplTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public JsonParserImpl(JsonParserImplTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(JsonParserImplTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[33];
    for (int i = 0; i < 33; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 33; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
