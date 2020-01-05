VTABLE<Array$>:
    NULL
    "Array$"
    FUNCTION<Array$.Array$getLength>

VTABLE<Complex>:
    NULL
    "Complex"
    FUNCTION<Complex.abs2>

VTABLE<Complex+>:
    NULL
    "Complex+"
    FUNCTION<Complex+.abs2>
    FUNCTION<Complex+.add>
    FUNCTION<Complex+.make>
    FUNCTION<Complex+.mul>
    FUNCTION<Complex+.sub>

VTABLE<LambdaCaller$>:
    NULL
    "LambdaCaller$"

VTABLE<Main>:
    VTABLE<Complex>
    "Main"
    FUNCTION<Complex.abs2>

VTABLE<Main+>:
    NULL
    "Main+"
    FUNCTION<Complex+.abs2>

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<Main.new>:
    _T0 = 12
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Complex.new>:
    _T0 = 12
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Complex>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Complex+.make>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Complex.make>
    return _T3

FUNCTION<Complex.make>:
    _T3 = call FUNCTION<Complex.new>
    _T2 = _T3
    _T4 = 32768
    _T5 = 0
    _T6 = (_T4 == _T5)
    if (_T6 == 0) branch _L1
    _T7 = "Decaf runtime error: Division by zero error\n"
    parm _T7
    call _PrintString
    call _Halt
_L1:
    _T8 = (_T0 % _T4)
    *(_T2 + 8) = _T8
    _T9 = 32768
    _T10 = 0
    _T11 = (_T9 == _T10)
    if (_T11 == 0) branch _L2
    _T12 = "Decaf runtime error: Division by zero error\n"
    parm _T12
    call _PrintString
    call _Halt
_L2:
    _T13 = (_T1 % _T9)
    *(_T2 + 4) = _T13
    return _T2

FUNCTION<Complex+.add>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Complex.add>
    return _T3

FUNCTION<Complex.add>:
    _T2 = 4
    parm _T2
    _T3 = call _Alloc
    _T4 = 16
    _T5 = VTABLE<Complex+>
    _T6 = (_T5 + _T4)
    _T7 = *(_T6 + 0)
    *(_T3 + 0) = _T7
    _T8 = *(_T0 + 8)
    _T9 = *(_T1 + 8)
    _T10 = (_T8 + _T9)
    _T11 = *(_T0 + 4)
    _T12 = *(_T1 + 4)
    _T13 = (_T11 + _T12)
    _T14 = *(_T3 + 0)
    parm _T3
    parm _T10
    parm _T13
    _T15 = call _T14
    return _T15

FUNCTION<Complex+.sub>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Complex.sub>
    return _T3

FUNCTION<Complex.sub>:
    _T2 = 4
    parm _T2
    _T3 = call _Alloc
    _T4 = 16
    _T5 = VTABLE<Complex+>
    _T6 = (_T5 + _T4)
    _T7 = *(_T6 + 0)
    *(_T3 + 0) = _T7
    _T8 = *(_T0 + 8)
    _T9 = *(_T1 + 8)
    _T10 = (_T8 - _T9)
    _T11 = *(_T0 + 4)
    _T12 = *(_T1 + 4)
    _T13 = (_T11 - _T12)
    _T14 = *(_T3 + 0)
    parm _T3
    parm _T10
    parm _T13
    _T15 = call _T14
    return _T15

FUNCTION<Complex+.mul>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Complex.mul>
    return _T3

FUNCTION<Complex.mul>:
    _T2 = 4
    parm _T2
    _T3 = call _Alloc
    _T4 = 16
    _T5 = VTABLE<Complex+>
    _T6 = (_T5 + _T4)
    _T7 = *(_T6 + 0)
    *(_T3 + 0) = _T7
    _T8 = *(_T0 + 8)
    _T9 = *(_T1 + 8)
    _T10 = (_T8 * _T9)
    _T11 = *(_T0 + 4)
    _T12 = *(_T1 + 4)
    _T13 = (_T11 * _T12)
    _T14 = (_T10 - _T13)
    _T15 = 4096
    _T16 = 0
    _T17 = (_T15 == _T16)
    if (_T17 == 0) branch _L3
    _T18 = "Decaf runtime error: Division by zero error\n"
    parm _T18
    call _PrintString
    call _Halt
_L3:
    _T19 = (_T14 / _T15)
    _T20 = *(_T0 + 8)
    _T21 = *(_T1 + 4)
    _T22 = (_T20 * _T21)
    _T23 = *(_T0 + 4)
    _T24 = *(_T1 + 8)
    _T25 = (_T23 * _T24)
    _T26 = (_T22 + _T25)
    _T27 = 4096
    _T28 = 0
    _T29 = (_T27 == _T28)
    if (_T29 == 0) branch _L4
    _T30 = "Decaf runtime error: Division by zero error\n"
    parm _T30
    call _PrintString
    call _Halt
_L4:
    _T31 = (_T26 / _T27)
    _T32 = *(_T3 + 0)
    parm _T3
    parm _T19
    parm _T31
    _T33 = call _T32
    return _T33

FUNCTION<Complex+.abs2>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    _T4 = call _T3
    return _T4

FUNCTION<Complex.abs2>:
    _T1 = *(_T0 + 8)
    _T2 = *(_T0 + 8)
    _T3 = (_T1 * _T2)
    _T4 = *(_T0 + 4)
    _T5 = *(_T0 + 4)
    _T6 = (_T4 * _T5)
    _T7 = (_T3 + _T6)
    return _T7

main:
    _T1 = 51
    _T0 = _T1
    _T3 = 4096
    _T2 = _T3
    _T5 = 2
    _T6 = - _T5
    _T7 = (_T6 * _T3)
    _T4 = _T7
    _T9 = 4
    _T10 = (_T9 * _T3)
    _T11 = 1
    _T12 = (_T1 - _T11)
    _T13 = 0
    _T14 = (_T12 == _T13)
    if (_T14 == 0) branch _L5
    _T15 = "Decaf runtime error: Division by zero error\n"
    parm _T15
    call _PrintString
    call _Halt
_L5:
    _T16 = (_T10 / _T12)
    _T8 = _T16
    _T18 = 0
    _T19 = (_T0 < _T18)
    if (_T19 == 0) branch _L6
    _T20 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T20
    call _PrintString
    call _Halt
_L6:
    _T21 = 1
    _T22 = (_T0 + _T21)
    _T23 = 4
    _T24 = (_T22 * _T23)
    parm _T24
    _T25 = call _Alloc
    *(_T25 + 0) = _T0
    _T26 = (_T25 + _T24)
    _T26 = (_T26 - _T23)
_L8:
    _T27 = (_T26 != _T25)
    if (_T27 == 0) branch _L7
    *(_T26 + 0) = _T18
    _T26 = (_T26 - _T23)
    branch _L8
_L7:
    _T28 = (_T25 + _T23)
    _T17 = _T28
    _T30 = 0
    _T31 = (_T0 < _T30)
    if (_T31 == 0) branch _L9
    _T32 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T32
    call _PrintString
    call _Halt
_L9:
    _T33 = 1
    _T34 = (_T0 + _T33)
    _T35 = 4
    _T36 = (_T34 * _T35)
    parm _T36
    _T37 = call _Alloc
    *(_T37 + 0) = _T0
    _T38 = (_T37 + _T36)
    _T38 = (_T38 - _T35)
_L11:
    _T39 = (_T38 != _T37)
    if (_T39 == 0) branch _L10
    *(_T38 + 0) = _T30
    _T38 = (_T38 - _T35)
    branch _L11
_L10:
    _T40 = (_T37 + _T35)
    _T29 = _T40
    _T42 = 0
    _T41 = _T42
_L13:
    _T43 = (_T41 < _T0)
    if (_T43 == 0) branch _L12
    _T44 = *(_T17 - 4)
    _T45 = 0
    _T46 = (_T41 < _T45)
    _T47 = (_T41 >= _T44)
    _T48 = (_T46 || _T47)
    if (_T48 == 0) branch _L14
    _T49 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T49
    call _PrintString
    call _Halt
_L14:
    _T50 = 4
    _T51 = (_T41 * _T50)
    _T52 = (_T17 + _T51)
    _T53 = 0
    _T54 = (_T0 < _T53)
    if (_T54 == 0) branch _L15
    _T55 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T55
    call _PrintString
    call _Halt
_L15:
    _T56 = 1
    _T57 = (_T0 + _T56)
    _T58 = 4
    _T59 = (_T57 * _T58)
    parm _T59
    _T60 = call _Alloc
    *(_T60 + 0) = _T0
    _T61 = (_T60 + _T59)
    _T61 = (_T61 - _T58)
_L17:
    _T62 = (_T61 != _T60)
    if (_T62 == 0) branch _L16
    *(_T61 + 0) = _T53
    _T61 = (_T61 - _T58)
    branch _L17
_L16:
    _T63 = (_T60 + _T58)
    *(_T52 + 0) = _T63
    _T64 = *(_T29 - 4)
    _T65 = 0
    _T66 = (_T41 < _T65)
    _T67 = (_T41 >= _T64)
    _T68 = (_T66 || _T67)
    if (_T68 == 0) branch _L18
    _T69 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T69
    call _PrintString
    call _Halt
_L18:
    _T70 = 4
    _T71 = (_T41 * _T70)
    _T72 = (_T29 + _T71)
    _T73 = 0
    _T74 = (_T0 < _T73)
    if (_T74 == 0) branch _L19
    _T75 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T75
    call _PrintString
    call _Halt
_L19:
    _T76 = 1
    _T77 = (_T0 + _T76)
    _T78 = 4
    _T79 = (_T77 * _T78)
    parm _T79
    _T80 = call _Alloc
    *(_T80 + 0) = _T0
    _T81 = (_T80 + _T79)
    _T81 = (_T81 - _T78)
_L21:
    _T82 = (_T81 != _T80)
    if (_T82 == 0) branch _L20
    *(_T81 + 0) = _T73
    _T81 = (_T81 - _T78)
    branch _L21
_L20:
    _T83 = (_T80 + _T78)
    *(_T72 + 0) = _T83
    _T85 = 0
    _T84 = _T85
_L23:
    _T86 = (_T84 < _T0)
    if (_T86 == 0) branch _L22
    _T87 = *(_T17 - 4)
    _T88 = 0
    _T89 = (_T41 < _T88)
    _T90 = (_T41 >= _T87)
    _T91 = (_T89 || _T90)
    if (_T91 == 0) branch _L24
    _T92 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T92
    call _PrintString
    call _Halt
_L24:
    _T93 = 4
    _T94 = (_T41 * _T93)
    _T95 = (_T17 + _T94)
    _T96 = *(_T95 + 0)
    _T97 = *(_T96 - 4)
    _T98 = 0
    _T99 = (_T84 < _T98)
    _T100 = (_T84 >= _T97)
    _T101 = (_T99 || _T100)
    if (_T101 == 0) branch _L25
    _T102 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T102
    call _PrintString
    call _Halt
_L25:
    _T103 = 4
    _T104 = (_T84 * _T103)
    _T105 = (_T96 + _T104)
    _T106 = 4
    parm _T106
    _T107 = call _Alloc
    _T108 = 16
    _T109 = VTABLE<Complex+>
    _T110 = (_T109 + _T108)
    _T111 = *(_T110 + 0)
    *(_T107 + 0) = _T111
    _T112 = (_T84 * _T8)
    _T113 = (_T4 + _T112)
    _T114 = (_T41 * _T8)
    _T115 = (_T4 + _T114)
    _T116 = *(_T107 + 0)
    parm _T107
    parm _T113
    parm _T115
    _T117 = call _T116
    *(_T105 + 0) = _T117
    _T118 = *(_T29 - 4)
    _T119 = 0
    _T120 = (_T41 < _T119)
    _T121 = (_T41 >= _T118)
    _T122 = (_T120 || _T121)
    if (_T122 == 0) branch _L26
    _T123 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T123
    call _PrintString
    call _Halt
_L26:
    _T124 = 4
    _T125 = (_T41 * _T124)
    _T126 = (_T29 + _T125)
    _T127 = *(_T126 + 0)
    _T128 = *(_T127 - 4)
    _T129 = 0
    _T130 = (_T84 < _T129)
    _T131 = (_T84 >= _T128)
    _T132 = (_T130 || _T131)
    if (_T132 == 0) branch _L27
    _T133 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T133
    call _PrintString
    call _Halt
_L27:
    _T134 = 4
    _T135 = (_T84 * _T134)
    _T136 = (_T127 + _T135)
    _T137 = call FUNCTION<Complex.new>
    *(_T136 + 0) = _T137
    _T138 = 1
    _T139 = (_T84 + _T138)
    _T84 = _T139
    branch _L23
_L22:
    _T140 = 1
    _T141 = (_T41 + _T140)
    _T41 = _T141
    branch _L13
_L12:
    _T143 = 0
    _T142 = _T143
_L29:
    _T144 = 20
    _T145 = (_T142 < _T144)
    if (_T145 == 0) branch _L28
    _T147 = 0
    _T146 = _T147
_L31:
    _T148 = (_T146 < _T0)
    if (_T148 == 0) branch _L30
    _T150 = 0
    _T149 = _T150
_L33:
    _T151 = (_T149 < _T0)
    if (_T151 == 0) branch _L32
    _T153 = *(_T29 - 4)
    _T154 = 0
    _T155 = (_T146 < _T154)
    _T156 = (_T146 >= _T153)
    _T157 = (_T155 || _T156)
    if (_T157 == 0) branch _L34
    _T158 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T158
    call _PrintString
    call _Halt
_L34:
    _T159 = 4
    _T160 = (_T146 * _T159)
    _T161 = (_T29 + _T160)
    _T162 = *(_T161 + 0)
    _T163 = *(_T162 - 4)
    _T164 = 0
    _T165 = (_T149 < _T164)
    _T166 = (_T149 >= _T163)
    _T167 = (_T165 || _T166)
    if (_T167 == 0) branch _L35
    _T168 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T168
    call _PrintString
    call _Halt
_L35:
    _T169 = 4
    _T170 = (_T149 * _T169)
    _T171 = (_T162 + _T170)
    _T172 = *(_T171 + 0)
    _T152 = _T172
    _T173 = 8
    parm _T173
    _T174 = call _Alloc
    _T175 = 8
    _T176 = VTABLE<Complex+>
    _T177 = (_T176 + _T175)
    _T178 = *(_T177 + 0)
    *(_T174 + 0) = _T178
    *(_T174 + 4) = _T172
    _T179 = *(_T174 + 0)
    parm _T174
    _T180 = call _T179
    _T181 = 4
    _T182 = (_T181 * _T2)
    _T183 = (_T182 * _T2)
    _T184 = (_T180 < _T183)
    if (_T184 == 0) branch _L36
    _T185 = *(_T29 - 4)
    _T186 = 0
    _T187 = (_T146 < _T186)
    _T188 = (_T146 >= _T185)
    _T189 = (_T187 || _T188)
    if (_T189 == 0) branch _L37
    _T190 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T190
    call _PrintString
    call _Halt
_L37:
    _T191 = 4
    _T192 = (_T146 * _T191)
    _T193 = (_T29 + _T192)
    _T194 = *(_T193 + 0)
    _T195 = *(_T194 - 4)
    _T196 = 0
    _T197 = (_T149 < _T196)
    _T198 = (_T149 >= _T195)
    _T199 = (_T197 || _T198)
    if (_T199 == 0) branch _L38
    _T200 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T200
    call _PrintString
    call _Halt
_L38:
    _T201 = 4
    _T202 = (_T149 * _T201)
    _T203 = (_T194 + _T202)
    _T204 = 4
    parm _T204
    _T205 = call _Alloc
    _T206 = 12
    _T207 = VTABLE<Complex+>
    _T208 = (_T207 + _T206)
    _T209 = *(_T208 + 0)
    *(_T205 + 0) = _T209
    _T210 = 4
    parm _T210
    _T211 = call _Alloc
    _T212 = 20
    _T213 = VTABLE<Complex+>
    _T214 = (_T213 + _T212)
    _T215 = *(_T214 + 0)
    *(_T211 + 0) = _T215
    _T216 = *(_T211 + 0)
    parm _T211
    parm _T152
    parm _T152
    _T217 = call _T216
    _T218 = *(_T17 - 4)
    _T219 = 0
    _T220 = (_T146 < _T219)
    _T221 = (_T146 >= _T218)
    _T222 = (_T220 || _T221)
    if (_T222 == 0) branch _L39
    _T223 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T223
    call _PrintString
    call _Halt
_L39:
    _T224 = 4
    _T225 = (_T146 * _T224)
    _T226 = (_T17 + _T225)
    _T227 = *(_T226 + 0)
    _T228 = *(_T227 - 4)
    _T229 = 0
    _T230 = (_T149 < _T229)
    _T231 = (_T149 >= _T228)
    _T232 = (_T230 || _T231)
    if (_T232 == 0) branch _L40
    _T233 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T233
    call _PrintString
    call _Halt
_L40:
    _T234 = 4
    _T235 = (_T149 * _T234)
    _T236 = (_T227 + _T235)
    _T237 = *(_T236 + 0)
    _T238 = *(_T205 + 0)
    parm _T205
    parm _T217
    parm _T237
    _T239 = call _T238
    *(_T203 + 0) = _T239
_L36:
    _T240 = 1
    _T241 = (_T149 + _T240)
    _T149 = _T241
    branch _L33
_L32:
    _T242 = 1
    _T243 = (_T146 + _T242)
    _T146 = _T243
    branch _L31
_L30:
    _T244 = 1
    _T245 = (_T142 + _T244)
    _T142 = _T245
    branch _L29
_L28:
    _T247 = 0
    _T246 = _T247
_L42:
    _T248 = (_T246 < _T0)
    if (_T248 == 0) branch _L41
    _T250 = 0
    _T249 = _T250
_L44:
    _T251 = (_T249 < _T0)
    if (_T251 == 0) branch _L43
    _T252 = *(_T29 - 4)
    _T253 = 0
    _T254 = (_T246 < _T253)
    _T255 = (_T246 >= _T252)
    _T256 = (_T254 || _T255)
    if (_T256 == 0) branch _L45
    _T257 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T257
    call _PrintString
    call _Halt
_L45:
    _T258 = 4
    _T259 = (_T246 * _T258)
    _T260 = (_T29 + _T259)
    _T261 = *(_T260 + 0)
    _T262 = *(_T261 - 4)
    _T263 = 0
    _T264 = (_T249 < _T263)
    _T265 = (_T249 >= _T262)
    _T266 = (_T264 || _T265)
    if (_T266 == 0) branch _L46
    _T267 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T267
    call _PrintString
    call _Halt
_L46:
    _T268 = 4
    _T269 = (_T249 * _T268)
    _T270 = (_T261 + _T269)
    _T271 = *(_T270 + 0)
    _T272 = 8
    parm _T272
    _T273 = call _Alloc
    _T274 = 8
    _T275 = VTABLE<Complex+>
    _T276 = (_T275 + _T274)
    _T277 = *(_T276 + 0)
    *(_T273 + 0) = _T277
    *(_T273 + 4) = _T271
    _T278 = *(_T273 + 0)
    parm _T273
    _T279 = call _T278
    _T280 = 4
    _T281 = (_T280 * _T2)
    _T282 = (_T281 * _T2)
    _T283 = (_T279 < _T282)
    if (_T283 == 0) branch _L47
    _T284 = "**"
    parm _T284
    call _PrintString
    branch _L48
_L47:
    _T285 = "  "
    parm _T285
    call _PrintString
_L48:
    _T286 = 1
    _T287 = (_T249 + _T286)
    _T249 = _T287
    branch _L44
_L43:
    _T288 = "\n"
    parm _T288
    call _PrintString
    _T289 = 1
    _T290 = (_T246 + _T289)
    _T246 = _T290
    branch _L42
_L41:
    return

