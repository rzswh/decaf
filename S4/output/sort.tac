VTABLE<Array$>:
    NULL
    "Array$"
    FUNCTION<Array$.Array$getLength>

VTABLE<LambdaCaller$>:
    NULL
    "LambdaCaller$"

VTABLE<Main>:
    NULL
    "Main"

VTABLE<Main+>:
    NULL
    "Main+"

VTABLE<MergeSort>:
    NULL
    "MergeSort"

VTABLE<MergeSort+>:
    NULL
    "MergeSort+"
    FUNCTION<MergeSort+.sort>
    FUNCTION<MergeSort+.sort_impl>

VTABLE<QuickSort>:
    NULL
    "QuickSort"

VTABLE<QuickSort+>:
    NULL
    "QuickSort+"
    FUNCTION<QuickSort+.sort>

VTABLE<Rng>:
    NULL
    "Rng"
    FUNCTION<Rng.next>

VTABLE<Rng+>:
    NULL
    "Rng+"
    FUNCTION<Rng+.next>
    FUNCTION<Rng+.make>

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<QuickSort.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<QuickSort>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Rng.new>:
    _T0 = 8
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Rng>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<MergeSort.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<MergeSort>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Main.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

main:
    _T1 = 4
    parm _T1
    _T2 = call _Alloc
    _T3 = 12
    _T4 = VTABLE<Rng+>
    _T5 = (_T4 + _T3)
    _T6 = *(_T5 + 0)
    *(_T2 + 0) = _T6
    _T7 = 19260817
    _T8 = *(_T2 + 0)
    parm _T2
    parm _T7
    _T9 = call _T8
    _T0 = _T9
    _T11 = 500
    _T12 = 0
    _T13 = (_T11 < _T12)
    if (_T13 == 0) branch _L1
    _T14 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T14
    call _PrintString
    call _Halt
_L1:
    _T15 = 1
    _T16 = (_T11 + _T15)
    _T17 = 4
    _T18 = (_T16 * _T17)
    parm _T18
    _T19 = call _Alloc
    *(_T19 + 0) = _T11
    _T20 = (_T19 + _T18)
    _T20 = (_T20 - _T17)
_L3:
    _T21 = (_T20 != _T19)
    if (_T21 == 0) branch _L2
    *(_T20 + 0) = _T12
    _T20 = (_T20 - _T17)
    branch _L3
_L2:
    _T22 = (_T19 + _T17)
    _T10 = _T22
    _T24 = 500
    _T25 = 0
    _T26 = (_T24 < _T25)
    if (_T26 == 0) branch _L4
    _T27 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T27
    call _PrintString
    call _Halt
_L4:
    _T28 = 1
    _T29 = (_T24 + _T28)
    _T30 = 4
    _T31 = (_T29 * _T30)
    parm _T31
    _T32 = call _Alloc
    *(_T32 + 0) = _T24
    _T33 = (_T32 + _T31)
    _T33 = (_T33 - _T30)
_L6:
    _T34 = (_T33 != _T32)
    if (_T34 == 0) branch _L5
    *(_T33 + 0) = _T25
    _T33 = (_T33 - _T30)
    branch _L6
_L5:
    _T35 = (_T32 + _T30)
    _T23 = _T35
    _T37 = 0
    _T36 = _T37
_L8:
    _T38 = 8
    parm _T38
    _T39 = call _Alloc
    _T40 = 8
    _T41 = VTABLE<Array$>
    _T42 = (_T41 + _T40)
    _T43 = *(_T42 + 0)
    *(_T39 + 0) = _T43
    *(_T39 + 4) = _T10
    _T44 = *(_T39 + 0)
    parm _T39
    _T45 = call _T44
    _T46 = (_T36 < _T45)
    if (_T46 == 0) branch _L7
    _T47 = *(_T10 - 4)
    _T48 = 0
    _T49 = (_T36 < _T48)
    _T50 = (_T36 >= _T47)
    _T51 = (_T49 || _T50)
    if (_T51 == 0) branch _L9
    _T52 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T52
    call _PrintString
    call _Halt
_L9:
    _T53 = 4
    _T54 = (_T36 * _T53)
    _T55 = (_T10 + _T54)
    _T56 = 8
    parm _T56
    _T57 = call _Alloc
    _T58 = 8
    _T59 = VTABLE<Rng+>
    _T60 = (_T59 + _T58)
    _T61 = *(_T60 + 0)
    *(_T57 + 0) = _T61
    *(_T57 + 4) = _T0
    _T62 = *(_T57 + 0)
    parm _T57
    _T63 = call _T62
    _T64 = 500
    _T65 = 0
    _T66 = (_T64 == _T65)
    if (_T66 == 0) branch _L10
    _T67 = "Decaf runtime error: Division by zero error\n"
    parm _T67
    call _PrintString
    call _Halt
_L10:
    _T68 = (_T63 % _T64)
    *(_T55 + 0) = _T68
    _T69 = *(_T23 - 4)
    _T70 = 0
    _T71 = (_T36 < _T70)
    _T72 = (_T36 >= _T69)
    _T73 = (_T71 || _T72)
    if (_T73 == 0) branch _L11
    _T74 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T74
    call _PrintString
    call _Halt
_L11:
    _T75 = 4
    _T76 = (_T36 * _T75)
    _T77 = (_T23 + _T76)
    _T78 = *(_T10 - 4)
    _T79 = 0
    _T80 = (_T36 < _T79)
    _T81 = (_T36 >= _T78)
    _T82 = (_T80 || _T81)
    if (_T82 == 0) branch _L12
    _T83 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T83
    call _PrintString
    call _Halt
_L12:
    _T84 = 4
    _T85 = (_T36 * _T84)
    _T86 = (_T10 + _T85)
    _T87 = *(_T86 + 0)
    *(_T77 + 0) = _T87
    _T88 = 1
    _T89 = (_T36 + _T88)
    _T36 = _T89
    branch _L8
_L7:
    _T90 = 4
    parm _T90
    _T91 = call _Alloc
    _T92 = 8
    _T93 = VTABLE<QuickSort+>
    _T94 = (_T93 + _T92)
    _T95 = *(_T94 + 0)
    *(_T91 + 0) = _T95
    _T96 = 0
    _T97 = 8
    parm _T97
    _T98 = call _Alloc
    _T99 = 8
    _T100 = VTABLE<Array$>
    _T101 = (_T100 + _T99)
    _T102 = *(_T101 + 0)
    *(_T98 + 0) = _T102
    *(_T98 + 4) = _T10
    _T103 = *(_T98 + 0)
    parm _T98
    _T104 = call _T103
    _T105 = 1
    _T106 = (_T104 - _T105)
    _T107 = *(_T91 + 0)
    parm _T91
    parm _T10
    parm _T96
    parm _T106
    call _T107
    _T109 = 0
    _T108 = _T109
_L14:
    _T110 = 8
    parm _T110
    _T111 = call _Alloc
    _T112 = 8
    _T113 = VTABLE<Array$>
    _T114 = (_T113 + _T112)
    _T115 = *(_T114 + 0)
    *(_T111 + 0) = _T115
    *(_T111 + 4) = _T10
    _T116 = *(_T111 + 0)
    parm _T111
    _T117 = call _T116
    _T118 = (_T108 < _T117)
    if (_T118 == 0) branch _L13
    _T119 = *(_T10 - 4)
    _T120 = 0
    _T121 = (_T108 < _T120)
    _T122 = (_T108 >= _T119)
    _T123 = (_T121 || _T122)
    if (_T123 == 0) branch _L15
    _T124 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T124
    call _PrintString
    call _Halt
_L15:
    _T125 = 4
    _T126 = (_T108 * _T125)
    _T127 = (_T10 + _T126)
    _T128 = *(_T127 + 0)
    parm _T128
    call _PrintInt
    _T129 = " "
    parm _T129
    call _PrintString
    _T130 = 1
    _T131 = (_T108 + _T130)
    _T108 = _T131
    branch _L14
_L13:
    _T132 = "\n"
    parm _T132
    call _PrintString
    _T133 = 4
    parm _T133
    _T134 = call _Alloc
    _T135 = 8
    _T136 = VTABLE<MergeSort+>
    _T137 = (_T136 + _T135)
    _T138 = *(_T137 + 0)
    *(_T134 + 0) = _T138
    _T139 = *(_T134 + 0)
    parm _T134
    parm _T23
    call _T139
    _T141 = 0
    _T140 = _T141
_L17:
    _T142 = 8
    parm _T142
    _T143 = call _Alloc
    _T144 = 8
    _T145 = VTABLE<Array$>
    _T146 = (_T145 + _T144)
    _T147 = *(_T146 + 0)
    *(_T143 + 0) = _T147
    *(_T143 + 4) = _T23
    _T148 = *(_T143 + 0)
    parm _T143
    _T149 = call _T148
    _T150 = (_T140 < _T149)
    if (_T150 == 0) branch _L16
    _T151 = *(_T23 - 4)
    _T152 = 0
    _T153 = (_T140 < _T152)
    _T154 = (_T140 >= _T151)
    _T155 = (_T153 || _T154)
    if (_T155 == 0) branch _L18
    _T156 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T156
    call _PrintString
    call _Halt
_L18:
    _T157 = 4
    _T158 = (_T140 * _T157)
    _T159 = (_T23 + _T158)
    _T160 = *(_T159 + 0)
    parm _T160
    call _PrintInt
    _T161 = " "
    parm _T161
    call _PrintString
    _T162 = 1
    _T163 = (_T140 + _T162)
    _T140 = _T163
    branch _L17
_L16:
    _T164 = "\n"
    parm _T164
    call _PrintString
    return

FUNCTION<Rng+.make>:
    parm _T1
    _T2 = call FUNCTION<Rng.make>
    return _T2

FUNCTION<Rng.make>:
    _T2 = call FUNCTION<Rng.new>
    *(_T2 + 4) = _T0
    return _T2

FUNCTION<Rng+.next>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    _T4 = call _T3
    return _T4

FUNCTION<Rng.next>:
    _T1 = 15625
    _T2 = *(_T0 + 4)
    _T3 = 10000
    _T4 = 0
    _T5 = (_T3 == _T4)
    if (_T5 == 0) branch _L19
    _T6 = "Decaf runtime error: Division by zero error\n"
    parm _T6
    call _PrintString
    call _Halt
_L19:
    _T7 = (_T2 % _T3)
    _T8 = (_T1 * _T7)
    _T9 = 22221
    _T10 = (_T8 + _T9)
    _T11 = 65536
    _T12 = 0
    _T13 = (_T11 == _T12)
    if (_T13 == 0) branch _L20
    _T14 = "Decaf runtime error: Division by zero error\n"
    parm _T14
    call _PrintString
    call _Halt
_L20:
    _T15 = (_T10 % _T11)
    *(_T0 + 4) = _T15
    _T16 = *(_T0 + 4)
    return _T16

FUNCTION<QuickSort+.sort>:
    parm _T1
    parm _T2
    parm _T3
    call FUNCTION<QuickSort.sort>
    return

FUNCTION<QuickSort.sort>:
    _T3 = _T1
    _T4 = _T2
    _T6 = (_T2 - _T1)
    _T7 = 2
    _T8 = 0
    _T9 = (_T7 == _T8)
    if (_T9 == 0) branch _L21
    _T10 = "Decaf runtime error: Division by zero error\n"
    parm _T10
    call _PrintString
    call _Halt
_L21:
    _T11 = (_T6 / _T7)
    _T12 = (_T1 + _T11)
    _T13 = *(_T0 - 4)
    _T14 = 0
    _T15 = (_T12 < _T14)
    _T16 = (_T12 >= _T13)
    _T17 = (_T15 || _T16)
    if (_T17 == 0) branch _L22
    _T18 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T18
    call _PrintString
    call _Halt
_L22:
    _T19 = 4
    _T20 = (_T12 * _T19)
    _T21 = (_T0 + _T20)
    _T22 = *(_T21 + 0)
    _T5 = _T22
_L24:
    _T23 = (_T3 <= _T4)
    if (_T23 == 0) branch _L23
_L26:
    _T24 = *(_T0 - 4)
    _T25 = 0
    _T26 = (_T3 < _T25)
    _T27 = (_T3 >= _T24)
    _T28 = (_T26 || _T27)
    if (_T28 == 0) branch _L27
    _T29 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T29
    call _PrintString
    call _Halt
_L27:
    _T30 = 4
    _T31 = (_T3 * _T30)
    _T32 = (_T0 + _T31)
    _T33 = *(_T32 + 0)
    _T34 = (_T33 < _T5)
    if (_T34 == 0) branch _L25
    _T35 = 1
    _T36 = (_T3 + _T35)
    _T3 = _T36
    branch _L26
_L25:
_L29:
    _T37 = *(_T0 - 4)
    _T38 = 0
    _T39 = (_T4 < _T38)
    _T40 = (_T4 >= _T37)
    _T41 = (_T39 || _T40)
    if (_T41 == 0) branch _L30
    _T42 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T42
    call _PrintString
    call _Halt
_L30:
    _T43 = 4
    _T44 = (_T4 * _T43)
    _T45 = (_T0 + _T44)
    _T46 = *(_T45 + 0)
    _T47 = (_T46 > _T5)
    if (_T47 == 0) branch _L28
    _T48 = 1
    _T49 = (_T4 - _T48)
    _T4 = _T49
    branch _L29
_L28:
    _T50 = (_T3 <= _T4)
    if (_T50 == 0) branch _L31
    _T52 = *(_T0 - 4)
    _T53 = 0
    _T54 = (_T3 < _T53)
    _T55 = (_T3 >= _T52)
    _T56 = (_T54 || _T55)
    if (_T56 == 0) branch _L32
    _T57 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T57
    call _PrintString
    call _Halt
_L32:
    _T58 = 4
    _T59 = (_T3 * _T58)
    _T60 = (_T0 + _T59)
    _T61 = *(_T60 + 0)
    _T51 = _T61
    _T62 = *(_T0 - 4)
    _T63 = 0
    _T64 = (_T3 < _T63)
    _T65 = (_T3 >= _T62)
    _T66 = (_T64 || _T65)
    if (_T66 == 0) branch _L33
    _T67 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T67
    call _PrintString
    call _Halt
_L33:
    _T68 = 4
    _T69 = (_T3 * _T68)
    _T70 = (_T0 + _T69)
    _T71 = *(_T0 - 4)
    _T72 = 0
    _T73 = (_T4 < _T72)
    _T74 = (_T4 >= _T71)
    _T75 = (_T73 || _T74)
    if (_T75 == 0) branch _L34
    _T76 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T76
    call _PrintString
    call _Halt
_L34:
    _T77 = 4
    _T78 = (_T4 * _T77)
    _T79 = (_T0 + _T78)
    _T80 = *(_T79 + 0)
    *(_T70 + 0) = _T80
    _T81 = *(_T0 - 4)
    _T82 = 0
    _T83 = (_T4 < _T82)
    _T84 = (_T4 >= _T81)
    _T85 = (_T83 || _T84)
    if (_T85 == 0) branch _L35
    _T86 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T86
    call _PrintString
    call _Halt
_L35:
    _T87 = 4
    _T88 = (_T4 * _T87)
    _T89 = (_T0 + _T88)
    *(_T89 + 0) = _T51
    _T90 = 1
    _T91 = (_T3 + _T90)
    _T3 = _T91
    _T92 = 1
    _T93 = (_T4 - _T92)
    _T4 = _T93
_L31:
    branch _L24
_L23:
    _T94 = (_T1 < _T4)
    if (_T94 == 0) branch _L36
    _T95 = 4
    parm _T95
    _T96 = call _Alloc
    _T97 = 8
    _T98 = VTABLE<QuickSort+>
    _T99 = (_T98 + _T97)
    _T100 = *(_T99 + 0)
    *(_T96 + 0) = _T100
    _T101 = *(_T96 + 0)
    parm _T96
    parm _T0
    parm _T1
    parm _T4
    call _T101
_L36:
    _T102 = (_T3 < _T2)
    if (_T102 == 0) branch _L37
    _T103 = 4
    parm _T103
    _T104 = call _Alloc
    _T105 = 8
    _T106 = VTABLE<QuickSort+>
    _T107 = (_T106 + _T105)
    _T108 = *(_T107 + 0)
    *(_T104 + 0) = _T108
    _T109 = *(_T104 + 0)
    parm _T104
    parm _T0
    parm _T3
    parm _T2
    call _T109
_L37:
    return

FUNCTION<MergeSort+.sort>:
    parm _T1
    call FUNCTION<MergeSort.sort>
    return

FUNCTION<MergeSort.sort>:
    _T1 = 4
    parm _T1
    _T2 = call _Alloc
    _T3 = 12
    _T4 = VTABLE<MergeSort+>
    _T5 = (_T4 + _T3)
    _T6 = *(_T5 + 0)
    *(_T2 + 0) = _T6
    _T7 = 0
    _T8 = 8
    parm _T8
    _T9 = call _Alloc
    _T10 = 8
    _T11 = VTABLE<Array$>
    _T12 = (_T11 + _T10)
    _T13 = *(_T12 + 0)
    *(_T9 + 0) = _T13
    *(_T9 + 4) = _T0
    _T14 = *(_T9 + 0)
    parm _T9
    _T15 = call _T14
    _T16 = 8
    parm _T16
    _T17 = call _Alloc
    _T18 = 8
    _T19 = VTABLE<Array$>
    _T20 = (_T19 + _T18)
    _T21 = *(_T20 + 0)
    *(_T17 + 0) = _T21
    *(_T17 + 4) = _T0
    _T22 = *(_T17 + 0)
    parm _T17
    _T23 = call _T22
    _T24 = 0
    _T25 = (_T23 < _T24)
    if (_T25 == 0) branch _L38
    _T26 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T26
    call _PrintString
    call _Halt
_L38:
    _T27 = 1
    _T28 = (_T23 + _T27)
    _T29 = 4
    _T30 = (_T28 * _T29)
    parm _T30
    _T31 = call _Alloc
    *(_T31 + 0) = _T23
    _T32 = (_T31 + _T30)
    _T32 = (_T32 - _T29)
_L40:
    _T33 = (_T32 != _T31)
    if (_T33 == 0) branch _L39
    *(_T32 + 0) = _T24
    _T32 = (_T32 - _T29)
    branch _L40
_L39:
    _T34 = (_T31 + _T29)
    _T35 = *(_T2 + 0)
    parm _T2
    parm _T0
    parm _T7
    parm _T15
    parm _T34
    call _T35
    return

FUNCTION<MergeSort+.sort_impl>:
    parm _T1
    parm _T2
    parm _T3
    parm _T4
    call FUNCTION<MergeSort.sort_impl>
    return

FUNCTION<MergeSort.sort_impl>:
    _T4 = 1
    _T5 = (_T1 + _T4)
    _T6 = (_T5 < _T2)
    if (_T6 == 0) branch _L41
    _T8 = (_T1 + _T2)
    _T9 = 2
    _T10 = 0
    _T11 = (_T9 == _T10)
    if (_T11 == 0) branch _L42
    _T12 = "Decaf runtime error: Division by zero error\n"
    parm _T12
    call _PrintString
    call _Halt
_L42:
    _T13 = (_T8 / _T9)
    _T7 = _T13
    _T14 = 4
    parm _T14
    _T15 = call _Alloc
    _T16 = 12
    _T17 = VTABLE<MergeSort+>
    _T18 = (_T17 + _T16)
    _T19 = *(_T18 + 0)
    *(_T15 + 0) = _T19
    _T20 = *(_T15 + 0)
    parm _T15
    parm _T0
    parm _T1
    parm _T13
    parm _T3
    call _T20
    _T21 = 4
    parm _T21
    _T22 = call _Alloc
    _T23 = 12
    _T24 = VTABLE<MergeSort+>
    _T25 = (_T24 + _T23)
    _T26 = *(_T25 + 0)
    *(_T22 + 0) = _T26
    _T27 = *(_T22 + 0)
    parm _T22
    parm _T0
    parm _T13
    parm _T2
    parm _T3
    call _T27
    _T28 = _T1
    _T29 = _T13
    _T31 = 0
    _T30 = _T31
_L44:
    _T32 = (_T28 < _T7)
    _T33 = (_T29 < _T2)
    _T34 = (_T32 && _T33)
    if (_T34 == 0) branch _L43
    _T35 = *(_T0 - 4)
    _T36 = 0
    _T37 = (_T29 < _T36)
    _T38 = (_T29 >= _T35)
    _T39 = (_T37 || _T38)
    if (_T39 == 0) branch _L45
    _T40 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T40
    call _PrintString
    call _Halt
_L45:
    _T41 = 4
    _T42 = (_T29 * _T41)
    _T43 = (_T0 + _T42)
    _T44 = *(_T43 + 0)
    _T45 = *(_T0 - 4)
    _T46 = 0
    _T47 = (_T28 < _T46)
    _T48 = (_T28 >= _T45)
    _T49 = (_T47 || _T48)
    if (_T49 == 0) branch _L46
    _T50 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T50
    call _PrintString
    call _Halt
_L46:
    _T51 = 4
    _T52 = (_T28 * _T51)
    _T53 = (_T0 + _T52)
    _T54 = *(_T53 + 0)
    _T55 = (_T44 < _T54)
    if (_T55 == 0) branch _L47
    _T56 = *(_T3 - 4)
    _T57 = 0
    _T58 = (_T30 < _T57)
    _T59 = (_T30 >= _T56)
    _T60 = (_T58 || _T59)
    if (_T60 == 0) branch _L49
    _T61 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T61
    call _PrintString
    call _Halt
_L49:
    _T62 = 4
    _T63 = (_T30 * _T62)
    _T64 = (_T3 + _T63)
    _T65 = *(_T0 - 4)
    _T66 = 0
    _T67 = (_T29 < _T66)
    _T68 = (_T29 >= _T65)
    _T69 = (_T67 || _T68)
    if (_T69 == 0) branch _L50
    _T70 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T70
    call _PrintString
    call _Halt
_L50:
    _T71 = 4
    _T72 = (_T29 * _T71)
    _T73 = (_T0 + _T72)
    _T74 = *(_T73 + 0)
    *(_T64 + 0) = _T74
    _T75 = 1
    _T76 = (_T29 + _T75)
    _T29 = _T76
    branch _L48
_L47:
    _T77 = *(_T3 - 4)
    _T78 = 0
    _T79 = (_T30 < _T78)
    _T80 = (_T30 >= _T77)
    _T81 = (_T79 || _T80)
    if (_T81 == 0) branch _L51
    _T82 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T82
    call _PrintString
    call _Halt
_L51:
    _T83 = 4
    _T84 = (_T30 * _T83)
    _T85 = (_T3 + _T84)
    _T86 = *(_T0 - 4)
    _T87 = 0
    _T88 = (_T28 < _T87)
    _T89 = (_T28 >= _T86)
    _T90 = (_T88 || _T89)
    if (_T90 == 0) branch _L52
    _T91 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T91
    call _PrintString
    call _Halt
_L52:
    _T92 = 4
    _T93 = (_T28 * _T92)
    _T94 = (_T0 + _T93)
    _T95 = *(_T94 + 0)
    *(_T85 + 0) = _T95
    _T96 = 1
    _T97 = (_T28 + _T96)
    _T28 = _T97
_L48:
    _T98 = 1
    _T99 = (_T30 + _T98)
    _T30 = _T99
    branch _L44
_L43:
_L54:
    _T100 = (_T28 < _T7)
    if (_T100 == 0) branch _L53
    _T101 = *(_T3 - 4)
    _T102 = 0
    _T103 = (_T30 < _T102)
    _T104 = (_T30 >= _T101)
    _T105 = (_T103 || _T104)
    if (_T105 == 0) branch _L55
    _T106 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T106
    call _PrintString
    call _Halt
_L55:
    _T107 = 4
    _T108 = (_T30 * _T107)
    _T109 = (_T3 + _T108)
    _T110 = *(_T0 - 4)
    _T111 = 0
    _T112 = (_T28 < _T111)
    _T113 = (_T28 >= _T110)
    _T114 = (_T112 || _T113)
    if (_T114 == 0) branch _L56
    _T115 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T115
    call _PrintString
    call _Halt
_L56:
    _T116 = 4
    _T117 = (_T28 * _T116)
    _T118 = (_T0 + _T117)
    _T119 = *(_T118 + 0)
    *(_T109 + 0) = _T119
    _T120 = 1
    _T121 = (_T30 + _T120)
    _T30 = _T121
    _T122 = 1
    _T123 = (_T28 + _T122)
    _T28 = _T123
    branch _L54
_L53:
    _T124 = 0
    _T28 = _T124
_L58:
    _T125 = (_T28 < _T30)
    if (_T125 == 0) branch _L57
    _T126 = (_T28 + _T1)
    _T127 = *(_T0 - 4)
    _T128 = 0
    _T129 = (_T126 < _T128)
    _T130 = (_T126 >= _T127)
    _T131 = (_T129 || _T130)
    if (_T131 == 0) branch _L59
    _T132 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T132
    call _PrintString
    call _Halt
_L59:
    _T133 = 4
    _T134 = (_T126 * _T133)
    _T135 = (_T0 + _T134)
    _T136 = *(_T3 - 4)
    _T137 = 0
    _T138 = (_T28 < _T137)
    _T139 = (_T28 >= _T136)
    _T140 = (_T138 || _T139)
    if (_T140 == 0) branch _L60
    _T141 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T141
    call _PrintString
    call _Halt
_L60:
    _T142 = 4
    _T143 = (_T28 * _T142)
    _T144 = (_T3 + _T143)
    _T145 = *(_T144 + 0)
    *(_T135 + 0) = _T145
    _T146 = 1
    _T147 = (_T28 + _T146)
    _T28 = _T147
    branch _L58
_L57:
_L41:
    return

