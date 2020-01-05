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

VTABLE<Node>:
    NULL
    "Node"

VTABLE<Node+>:
    NULL
    "Node+"
    FUNCTION<Node+.make>

VTABLE<RBTree>:
    VTABLE<Node>
    "RBTree"
    FUNCTION<RBTree.delete>
    FUNCTION<RBTree.delete_fix>
    FUNCTION<RBTree.insert>
    FUNCTION<RBTree.insert_fix>
    FUNCTION<RBTree.print>
    FUNCTION<RBTree.print_impl>
    FUNCTION<RBTree.rotate>
    FUNCTION<RBTree.transplant>

VTABLE<RBTree+>:
    NULL
    "RBTree+"
    FUNCTION<RBTree+.delete>
    FUNCTION<RBTree+.delete_fix>
    FUNCTION<RBTree+.insert>
    FUNCTION<RBTree+.insert_fix>
    FUNCTION<RBTree+.print>
    FUNCTION<RBTree+.print_impl>
    FUNCTION<RBTree+.rotate>
    FUNCTION<RBTree+.transplant>
    FUNCTION<RBTree+.make1>

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

FUNCTION<Node.new>:
    _T0 = 24
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Node>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<RBTree.new>:
    _T0 = 32
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<RBTree>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Rng.new>:
    _T0 = 8
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Rng>
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
    _T11 = 4
    parm _T11
    _T12 = call _Alloc
    _T13 = 40
    _T14 = VTABLE<RBTree+>
    _T15 = (_T14 + _T13)
    _T16 = *(_T15 + 0)
    *(_T12 + 0) = _T16
    _T17 = *(_T12 + 0)
    parm _T12
    _T18 = call _T17
    _T10 = _T18
    _T20 = 0
    _T19 = _T20
_L2:
    _T21 = 5
    _T22 = (_T19 < _T21)
    if (_T22 == 0) branch _L1
    _T24 = 0
    _T23 = _T24
_L4:
    _T25 = 500
    _T26 = (_T23 < _T25)
    if (_T26 == 0) branch _L3
    _T27 = 8
    parm _T27
    _T28 = call _Alloc
    _T29 = 16
    _T30 = VTABLE<RBTree+>
    _T31 = (_T30 + _T29)
    _T32 = *(_T31 + 0)
    *(_T28 + 0) = _T32
    *(_T28 + 4) = _T10
    _T33 = 8
    parm _T33
    _T34 = call _Alloc
    _T35 = 8
    _T36 = VTABLE<Rng+>
    _T37 = (_T36 + _T35)
    _T38 = *(_T37 + 0)
    *(_T34 + 0) = _T38
    *(_T34 + 4) = _T0
    _T39 = *(_T34 + 0)
    parm _T34
    _T40 = call _T39
    _T41 = 500
    _T42 = 0
    _T43 = (_T41 == _T42)
    if (_T43 == 0) branch _L5
    _T44 = "Decaf runtime error: Division by zero error\n"
    parm _T44
    call _PrintString
    call _Halt
_L5:
    _T45 = (_T40 % _T41)
    _T46 = *(_T28 + 0)
    parm _T28
    parm _T45
    call _T46
    _T47 = 1
    _T48 = (_T23 + _T47)
    _T23 = _T48
    branch _L4
_L3:
    _T50 = 0
    _T49 = _T50
_L7:
    _T51 = 500
    _T52 = (_T49 < _T51)
    if (_T52 == 0) branch _L6
    _T53 = 8
    parm _T53
    _T54 = call _Alloc
    _T55 = 8
    _T56 = VTABLE<RBTree+>
    _T57 = (_T56 + _T55)
    _T58 = *(_T57 + 0)
    *(_T54 + 0) = _T58
    *(_T54 + 4) = _T10
    _T59 = 8
    parm _T59
    _T60 = call _Alloc
    _T61 = 8
    _T62 = VTABLE<Rng+>
    _T63 = (_T62 + _T61)
    _T64 = *(_T63 + 0)
    *(_T60 + 0) = _T64
    *(_T60 + 4) = _T0
    _T65 = *(_T60 + 0)
    parm _T60
    _T66 = call _T65
    _T67 = 500
    _T68 = 0
    _T69 = (_T67 == _T68)
    if (_T69 == 0) branch _L8
    _T70 = "Decaf runtime error: Division by zero error\n"
    parm _T70
    call _PrintString
    call _Halt
_L8:
    _T71 = (_T66 % _T67)
    _T72 = *(_T54 + 0)
    parm _T54
    parm _T71
    call _T72
    _T73 = 1
    _T74 = (_T49 + _T73)
    _T49 = _T74
    branch _L7
_L6:
    _T75 = 1
    _T76 = (_T19 + _T75)
    _T19 = _T76
    branch _L2
_L1:
    _T77 = 8
    parm _T77
    _T78 = call _Alloc
    _T79 = 24
    _T80 = VTABLE<RBTree+>
    _T81 = (_T80 + _T79)
    _T82 = *(_T81 + 0)
    *(_T78 + 0) = _T82
    *(_T78 + 4) = _T10
    _T83 = *(_T78 + 0)
    parm _T78
    call _T83
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
    if (_T5 == 0) branch _L9
    _T6 = "Decaf runtime error: Division by zero error\n"
    parm _T6
    call _PrintString
    call _Halt
_L9:
    _T7 = (_T2 % _T3)
    _T8 = (_T1 * _T7)
    _T9 = 22221
    _T10 = (_T8 + _T9)
    _T11 = 65536
    _T12 = 0
    _T13 = (_T11 == _T12)
    if (_T13 == 0) branch _L10
    _T14 = "Decaf runtime error: Division by zero error\n"
    parm _T14
    call _PrintString
    call _Halt
_L10:
    _T15 = (_T10 % _T11)
    *(_T0 + 4) = _T15
    _T16 = *(_T0 + 4)
    return _T16

FUNCTION<Node+.make>:
    parm _T1
    parm _T2
    parm _T3
    _T4 = call FUNCTION<Node.make>
    return _T4

FUNCTION<Node.make>:
    _T4 = call FUNCTION<Node.new>
    *(_T4 + 8) = _T2
    *(_T4 + 16) = _T0
    *(_T4 + 12) = _T1
    *(_T4 + 20) = _T1
    _T5 = 1
    *(_T4 + 4) = _T5
    return _T4

FUNCTION<RBTree+.make1>:
    _T1 = call FUNCTION<RBTree.make1>
    return _T1

FUNCTION<RBTree.make1>:
    _T1 = call FUNCTION<RBTree.new>
    _T3 = call FUNCTION<Node.new>
    *(_T3 + 16) = _T3
    *(_T3 + 12) = _T3
    *(_T3 + 20) = _T3
    *(_T1 + 28) = _T3
    *(_T1 + 24) = _T3
    return _T1

FUNCTION<RBTree+.transplant>:
    _T3 = *(_T0 + 4)
    parm _T3
    parm _T1
    parm _T2
    _T4 = *(_T3 + 0)
    _T5 = *(_T4 + 36)
    call _T5
    return

FUNCTION<RBTree.transplant>:
    _T4 = *(_T1 + 16)
    _T5 = *(_T0 + 24)
    _T6 = (_T4 == _T5)
    if (_T6 == 0) branch _L11
    *(_T0 + 28) = _T2
    branch _L12
_L11:
    _T7 = *(_T4 + 20)
    _T8 = (_T7 == _T1)
    if (_T8 == 0) branch _L13
    *(_T4 + 20) = _T2
    branch _L14
_L13:
    *(_T4 + 12) = _T2
_L14:
_L12:
    *(_T2 + 16) = _T4
    return

FUNCTION<RBTree+.rotate>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 32)
    call _T4
    return

FUNCTION<RBTree.rotate>:
    _T3 = *(_T1 + 16)
    _T5 = *(_T3 + 16)
    *(_T1 + 16) = _T5
    _T6 = *(_T0 + 24)
    _T7 = (_T5 == _T6)
    if (_T7 == 0) branch _L15
    *(_T0 + 28) = _T1
    branch _L16
_L15:
    _T8 = *(_T5 + 20)
    _T9 = (_T8 == _T3)
    if (_T9 == 0) branch _L17
    *(_T5 + 20) = _T1
    branch _L18
_L17:
    *(_T5 + 12) = _T1
_L18:
_L16:
    _T10 = *(_T3 + 12)
    _T11 = (_T10 == _T1)
    if (_T11 == 0) branch _L19
    _T12 = *(_T1 + 20)
    *(_T3 + 12) = _T12
    _T13 = *(_T1 + 20)
    *(_T13 + 16) = _T3
    *(_T1 + 20) = _T3
    branch _L20
_L19:
    _T14 = *(_T1 + 12)
    *(_T3 + 20) = _T14
    _T15 = *(_T1 + 12)
    *(_T15 + 16) = _T3
    *(_T1 + 12) = _T3
_L20:
    *(_T3 + 16) = _T1
    return

FUNCTION<RBTree+.insert_fix>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 20)
    call _T4
    return

FUNCTION<RBTree.insert_fix>:
_L22:
    _T3 = *(_T1 + 16)
    _T4 = *(_T3 + 4)
    if (_T4 == 0) branch _L21
    _T6 = *(_T1 + 16)
    _T5 = _T6
    _T8 = *(_T6 + 16)
    _T7 = _T8
    _T10 = *(_T8 + 12)
    _T11 = (_T10 == _T6)
    if (_T11 == 0) branch _L23
    _T13 = *(_T8 + 12)
    _T12 = _T13
    branch _L24
_L23:
    _T14 = *(_T8 + 20)
    _T12 = _T14
_L24:
    _T15 = *(_T12 + 4)
    if (_T15 == 0) branch _L25
    _T16 = 0
    *(_T6 + 4) = _T16
    _T17 = 0
    *(_T12 + 4) = _T17
    _T18 = 1
    *(_T8 + 4) = _T18
    _T1 = _T8
    branch _L26
_L25:
    _T19 = *(_T6 + 12)
    _T20 = (_T19 == _T1)
    _T21 = (_T20 != _T11)
    if (_T21 == 0) branch _L27
    _T22 = 8
    parm _T22
    _T23 = call _Alloc
    _T24 = 32
    _T25 = VTABLE<RBTree+>
    _T26 = (_T25 + _T24)
    _T27 = *(_T26 + 0)
    *(_T23 + 0) = _T27
    *(_T23 + 4) = _T0
    _T28 = *(_T23 + 0)
    parm _T23
    parm _T1
    call _T28
    _T29 = _T1
    _T1 = _T6
    _T5 = _T29
    _T30 = *(_T29 + 16)
    _T7 = _T30
_L27:
    _T31 = 0
    *(_T5 + 4) = _T31
    _T32 = 1
    *(_T7 + 4) = _T32
    _T33 = 8
    parm _T33
    _T34 = call _Alloc
    _T35 = 32
    _T36 = VTABLE<RBTree+>
    _T37 = (_T36 + _T35)
    _T38 = *(_T37 + 0)
    *(_T34 + 0) = _T38
    *(_T34 + 4) = _T0
    _T39 = *(_T34 + 0)
    parm _T34
    parm _T5
    call _T39
_L26:
    branch _L22
_L21:
    _T40 = *(_T0 + 28)
    _T41 = 0
    *(_T40 + 4) = _T41
    return

FUNCTION<RBTree+.insert>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 16)
    call _T4
    return

FUNCTION<RBTree.insert>:
    _T3 = *(_T0 + 28)
    _T2 = _T3
    _T5 = *(_T0 + 24)
    _T4 = _T5
_L29:
    _T6 = *(_T0 + 24)
    _T7 = (_T2 != _T6)
    if (_T7 == 0) branch _L28
    _T4 = _T2
    _T8 = *(_T2 + 8)
    _T9 = (_T8 == _T1)
    if (_T9 == 0) branch _L30
    return
    branch _L31
_L30:
    _T10 = *(_T2 + 8)
    _T11 = (_T10 < _T1)
    if (_T11 == 0) branch _L32
    _T12 = *(_T2 + 20)
    _T2 = _T12
    branch _L33
_L32:
    _T13 = *(_T2 + 12)
    _T2 = _T13
_L33:
_L31:
    branch _L29
_L28:
    _T15 = 4
    parm _T15
    _T16 = call _Alloc
    _T17 = 8
    _T18 = VTABLE<Node+>
    _T19 = (_T18 + _T17)
    _T20 = *(_T19 + 0)
    *(_T16 + 0) = _T20
    _T21 = *(_T0 + 24)
    _T22 = *(_T16 + 0)
    parm _T16
    parm _T4
    parm _T21
    parm _T1
    _T23 = call _T22
    _T24 = *(_T0 + 24)
    _T25 = (_T4 == _T24)
    if (_T25 == 0) branch _L34
    *(_T0 + 28) = _T23
    branch _L35
_L34:
    _T26 = *(_T4 + 8)
    _T27 = (_T26 < _T1)
    if (_T27 == 0) branch _L36
    *(_T4 + 20) = _T23
    branch _L37
_L36:
    *(_T4 + 12) = _T23
_L37:
_L35:
    _T28 = 8
    parm _T28
    _T29 = call _Alloc
    _T30 = 20
    _T31 = VTABLE<RBTree+>
    _T32 = (_T31 + _T30)
    _T33 = *(_T32 + 0)
    *(_T29 + 0) = _T33
    *(_T29 + 4) = _T0
    _T34 = *(_T29 + 0)
    parm _T29
    parm _T23
    call _T34
    return

FUNCTION<RBTree+.delete_fix>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 12)
    call _T4
    return

FUNCTION<RBTree.delete_fix>:
_L39:
    _T2 = *(_T0 + 28)
    _T3 = (_T1 != _T2)
    _T4 = *(_T1 + 4)
    _T5 = ! _T4
    _T6 = (_T3 && _T5)
    if (_T6 == 0) branch _L38
    _T8 = *(_T1 + 16)
    _T10 = *(_T8 + 12)
    _T11 = (_T10 == _T1)
    if (_T11 == 0) branch _L40
    _T13 = *(_T8 + 20)
    _T12 = _T13
    branch _L41
_L40:
    _T14 = *(_T8 + 12)
    _T12 = _T14
_L41:
    _T15 = *(_T12 + 4)
    if (_T15 == 0) branch _L42
    _T16 = 0
    *(_T12 + 4) = _T16
    _T17 = 1
    *(_T8 + 4) = _T17
    _T18 = 8
    parm _T18
    _T19 = call _Alloc
    _T20 = 32
    _T21 = VTABLE<RBTree+>
    _T22 = (_T21 + _T20)
    _T23 = *(_T22 + 0)
    *(_T19 + 0) = _T23
    *(_T19 + 4) = _T0
    _T24 = *(_T19 + 0)
    parm _T19
    parm _T12
    call _T24
    if (_T11 == 0) branch _L43
    _T25 = *(_T8 + 20)
    _T12 = _T25
    branch _L44
_L43:
    _T26 = *(_T8 + 12)
    _T12 = _T26
_L44:
_L42:
    _T28 = *(_T12 + 12)
    _T29 = *(_T28 + 4)
    _T30 = ! _T29
    _T32 = *(_T12 + 20)
    _T33 = *(_T32 + 4)
    _T34 = ! _T33
    _T35 = (_T30 && _T34)
    if (_T35 == 0) branch _L45
    _T36 = 0
    *(_T12 + 4) = _T36
    _T1 = _T8
    branch _L46
_L45:
    _T38 = *(_T12 + 20)
    _T40 = *(_T12 + 12)
    _T39 = _T40
    if (_T11 == 0) branch _L47
    _T39 = _T38
_L47:
    _T42 = *(_T39 + 4)
    _T43 = ! _T42
    if (_T43 == 0) branch _L48
    _T44 = 0
    *(_T38 + 4) = _T44
    _T45 = 1
    *(_T12 + 4) = _T45
    _T46 = 8
    parm _T46
    _T47 = call _Alloc
    _T48 = 32
    _T49 = VTABLE<RBTree+>
    _T50 = (_T49 + _T48)
    _T51 = *(_T50 + 0)
    *(_T47 + 0) = _T51
    *(_T47 + 4) = _T0
    _T52 = *(_T47 + 0)
    parm _T47
    parm _T38
    call _T52
    if (_T11 == 0) branch _L49
    _T53 = *(_T8 + 20)
    _T12 = _T53
    _T54 = *(_T53 + 20)
    _T39 = _T54
    branch _L50
_L49:
    _T55 = *(_T8 + 12)
    _T12 = _T55
    _T56 = *(_T55 + 12)
    _T39 = _T56
_L50:
_L48:
    _T57 = *(_T8 + 4)
    *(_T12 + 4) = _T57
    _T58 = 0
    *(_T8 + 4) = _T58
    _T59 = 0
    *(_T39 + 4) = _T59
    _T60 = 8
    parm _T60
    _T61 = call _Alloc
    _T62 = 32
    _T63 = VTABLE<RBTree+>
    _T64 = (_T63 + _T62)
    _T65 = *(_T64 + 0)
    *(_T61 + 0) = _T65
    *(_T61 + 4) = _T0
    _T66 = *(_T61 + 0)
    parm _T61
    parm _T12
    call _T66
    _T67 = *(_T0 + 28)
    _T1 = _T67
_L46:
    branch _L39
_L38:
    _T68 = 0
    *(_T1 + 4) = _T68
    return

FUNCTION<RBTree+.delete>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 8)
    call _T4
    return

FUNCTION<RBTree.delete>:
    _T3 = *(_T0 + 28)
    _T2 = _T3
_L52:
    _T4 = *(_T0 + 24)
    _T5 = (_T2 != _T4)
    if (_T5 == 0) branch _L51
    _T6 = *(_T2 + 8)
    _T7 = (_T6 == _T1)
    if (_T7 == 0) branch _L53
    branch _L51
    branch _L54
_L53:
    _T8 = *(_T2 + 8)
    _T9 = (_T8 < _T1)
    if (_T9 == 0) branch _L55
    _T10 = *(_T2 + 20)
    _T2 = _T10
    branch _L56
_L55:
    _T11 = *(_T2 + 12)
    _T2 = _T11
_L56:
_L54:
    branch _L52
_L51:
    _T15 = *(_T2 + 4)
    _T14 = _T15
    _T16 = *(_T2 + 12)
    _T17 = *(_T0 + 24)
    _T18 = (_T16 == _T17)
    if (_T18 == 0) branch _L57
    _T19 = *(_T2 + 20)
    _T13 = _T19
    _T20 = 8
    parm _T20
    _T21 = call _Alloc
    _T22 = 36
    _T23 = VTABLE<RBTree+>
    _T24 = (_T23 + _T22)
    _T25 = *(_T24 + 0)
    *(_T21 + 0) = _T25
    *(_T21 + 4) = _T0
    _T26 = *(_T21 + 0)
    parm _T21
    parm _T2
    parm _T19
    call _T26
    branch _L58
_L57:
    _T27 = *(_T2 + 20)
    _T28 = *(_T0 + 24)
    _T29 = (_T27 == _T28)
    if (_T29 == 0) branch _L59
    _T30 = *(_T2 + 12)
    _T13 = _T30
    _T31 = 8
    parm _T31
    _T32 = call _Alloc
    _T33 = 36
    _T34 = VTABLE<RBTree+>
    _T35 = (_T34 + _T33)
    _T36 = *(_T35 + 0)
    *(_T32 + 0) = _T36
    *(_T32 + 4) = _T0
    _T37 = *(_T32 + 0)
    parm _T32
    parm _T2
    parm _T30
    call _T37
    branch _L60
_L59:
    _T38 = *(_T2 + 20)
    _T12 = _T38
_L62:
    _T39 = *(_T12 + 12)
    _T40 = *(_T0 + 24)
    _T41 = (_T39 != _T40)
    if (_T41 == 0) branch _L61
    _T42 = *(_T12 + 12)
    _T12 = _T42
    branch _L62
_L61:
    _T43 = *(_T12 + 4)
    _T14 = _T43
    _T44 = *(_T12 + 20)
    _T13 = _T44
    _T45 = *(_T12 + 16)
    _T46 = (_T45 == _T2)
    if (_T46 == 0) branch _L63
    *(_T44 + 16) = _T12
    branch _L64
_L63:
    _T47 = 8
    parm _T47
    _T48 = call _Alloc
    _T49 = 36
    _T50 = VTABLE<RBTree+>
    _T51 = (_T50 + _T49)
    _T52 = *(_T51 + 0)
    *(_T48 + 0) = _T52
    *(_T48 + 4) = _T0
    _T53 = *(_T48 + 0)
    parm _T48
    parm _T12
    parm _T44
    call _T53
    _T54 = *(_T2 + 20)
    *(_T12 + 20) = _T54
    _T55 = *(_T12 + 20)
    *(_T55 + 16) = _T12
_L64:
    _T56 = 8
    parm _T56
    _T57 = call _Alloc
    _T58 = 36
    _T59 = VTABLE<RBTree+>
    _T60 = (_T59 + _T58)
    _T61 = *(_T60 + 0)
    *(_T57 + 0) = _T61
    *(_T57 + 4) = _T0
    _T62 = *(_T57 + 0)
    parm _T57
    parm _T2
    parm _T12
    call _T62
    _T63 = *(_T2 + 12)
    *(_T12 + 12) = _T63
    _T64 = *(_T12 + 12)
    *(_T64 + 16) = _T12
    _T65 = *(_T2 + 4)
    *(_T12 + 4) = _T65
_L60:
_L58:
    _T66 = ! _T14
    if (_T66 == 0) branch _L65
    _T67 = 8
    parm _T67
    _T68 = call _Alloc
    _T69 = 12
    _T70 = VTABLE<RBTree+>
    _T71 = (_T70 + _T69)
    _T72 = *(_T71 + 0)
    *(_T68 + 0) = _T72
    *(_T68 + 4) = _T0
    _T73 = *(_T68 + 0)
    parm _T68
    parm _T13
    call _T73
_L65:
    return

FUNCTION<RBTree+.print>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 24)
    call _T3
    return

FUNCTION<RBTree.print>:
    _T1 = 8
    parm _T1
    _T2 = call _Alloc
    _T3 = 28
    _T4 = VTABLE<RBTree+>
    _T5 = (_T4 + _T3)
    _T6 = *(_T5 + 0)
    *(_T2 + 0) = _T6
    *(_T2 + 4) = _T0
    _T7 = *(_T0 + 28)
    _T8 = *(_T2 + 0)
    parm _T2
    parm _T7
    call _T8
    return

FUNCTION<RBTree+.print_impl>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 28)
    call _T4
    return

FUNCTION<RBTree.print_impl>:
    _T2 = *(_T0 + 24)
    _T3 = (_T1 == _T2)
    if (_T3 == 0) branch _L66
    return
    branch _L67
_L66:
    _T4 = 8
    parm _T4
    _T5 = call _Alloc
    _T6 = 28
    _T7 = VTABLE<RBTree+>
    _T8 = (_T7 + _T6)
    _T9 = *(_T8 + 0)
    *(_T5 + 0) = _T9
    *(_T5 + 4) = _T0
    _T10 = *(_T1 + 12)
    _T11 = *(_T5 + 0)
    parm _T5
    parm _T10
    call _T11
    _T12 = *(_T1 + 8)
    parm _T12
    call _PrintInt
    _T13 = " "
    parm _T13
    call _PrintString
    _T14 = 8
    parm _T14
    _T15 = call _Alloc
    _T16 = 28
    _T17 = VTABLE<RBTree+>
    _T18 = (_T17 + _T16)
    _T19 = *(_T18 + 0)
    *(_T15 + 0) = _T19
    *(_T15 + 4) = _T0
    _T20 = *(_T1 + 20)
    _T21 = *(_T15 + 0)
    parm _T15
    parm _T20
    call _T21
_L67:
    return

