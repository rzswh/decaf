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

VTABLE<Stack>:
    NULL
    "Stack"
    FUNCTION<Stack.Init>
    FUNCTION<Stack.NumElems>
    FUNCTION<Stack.Pop>
    FUNCTION<Stack.Push>

VTABLE<Stack+>:
    NULL
    "Stack+"
    FUNCTION<Stack+.Init>
    FUNCTION<Stack+.NumElems>
    FUNCTION<Stack+.Pop>
    FUNCTION<Stack+.Push>
    FUNCTION<Stack+.main>

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<Main.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Stack.new>:
    _T0 = 12
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Stack>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Stack+.Init>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    call _T3
    return

FUNCTION<Stack.Init>:
    _T1 = 100
    _T2 = 0
    _T3 = (_T1 < _T2)
    if (_T3 == 0) branch _L1
    _T4 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T4
    call _PrintString
    call _Halt
_L1:
    _T5 = 1
    _T6 = (_T1 + _T5)
    _T7 = 4
    _T8 = (_T6 * _T7)
    parm _T8
    _T9 = call _Alloc
    *(_T9 + 0) = _T1
    _T10 = (_T9 + _T8)
    _T10 = (_T10 - _T7)
_L3:
    _T11 = (_T10 != _T9)
    if (_T11 == 0) branch _L2
    *(_T10 + 0) = _T2
    _T10 = (_T10 - _T7)
    branch _L3
_L2:
    _T12 = (_T9 + _T7)
    *(_T0 + 4) = _T12
    _T13 = 0
    *(_T0 + 8) = _T13
    _T14 = 8
    parm _T14
    _T15 = call _Alloc
    _T16 = 20
    _T17 = VTABLE<Stack+>
    _T18 = (_T17 + _T16)
    _T19 = *(_T18 + 0)
    *(_T15 + 0) = _T19
    *(_T15 + 4) = _T0
    _T20 = 3
    _T21 = *(_T15 + 0)
    parm _T15
    parm _T20
    call _T21
    return

FUNCTION<Stack+.Push>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 20)
    call _T4
    return

FUNCTION<Stack.Push>:
    _T2 = *(_T0 + 4)
    _T3 = *(_T0 + 8)
    _T4 = *(_T2 - 4)
    _T5 = 0
    _T6 = (_T3 < _T5)
    _T7 = (_T3 >= _T4)
    _T8 = (_T6 || _T7)
    if (_T8 == 0) branch _L4
    _T9 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T9
    call _PrintString
    call _Halt
_L4:
    _T10 = 4
    _T11 = (_T3 * _T10)
    _T12 = (_T2 + _T11)
    *(_T12 + 0) = _T1
    _T13 = *(_T0 + 8)
    _T14 = 1
    _T15 = (_T13 + _T14)
    *(_T0 + 8) = _T15
    return

FUNCTION<Stack+.Pop>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 16)
    _T4 = call _T3
    return _T4

FUNCTION<Stack.Pop>:
    _T2 = *(_T0 + 4)
    _T3 = *(_T0 + 8)
    _T4 = 1
    _T5 = (_T3 - _T4)
    _T6 = *(_T2 - 4)
    _T7 = 0
    _T8 = (_T5 < _T7)
    _T9 = (_T5 >= _T6)
    _T10 = (_T8 || _T9)
    if (_T10 == 0) branch _L5
    _T11 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T11
    call _PrintString
    call _Halt
_L5:
    _T12 = 4
    _T13 = (_T5 * _T12)
    _T14 = (_T2 + _T13)
    _T15 = *(_T14 + 0)
    _T16 = *(_T0 + 8)
    _T17 = 1
    _T18 = (_T16 - _T17)
    *(_T0 + 8) = _T18
    return _T15

FUNCTION<Stack+.NumElems>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 12)
    _T4 = call _T3
    return _T4

FUNCTION<Stack.NumElems>:
    _T1 = *(_T0 + 8)
    return _T1

FUNCTION<Stack+.main>:
    call FUNCTION<Stack.main>
    return

FUNCTION<Stack.main>:
    _T1 = call FUNCTION<Stack.new>
    _T2 = 8
    parm _T2
    _T3 = call _Alloc
    _T4 = 8
    _T5 = VTABLE<Stack+>
    _T6 = (_T5 + _T4)
    _T7 = *(_T6 + 0)
    *(_T3 + 0) = _T7
    *(_T3 + 4) = _T1
    _T8 = *(_T3 + 0)
    parm _T3
    call _T8
    _T9 = 8
    parm _T9
    _T10 = call _Alloc
    _T11 = 20
    _T12 = VTABLE<Stack+>
    _T13 = (_T12 + _T11)
    _T14 = *(_T13 + 0)
    *(_T10 + 0) = _T14
    *(_T10 + 4) = _T1
    _T15 = 3
    _T16 = *(_T10 + 0)
    parm _T10
    parm _T15
    call _T16
    _T17 = 8
    parm _T17
    _T18 = call _Alloc
    _T19 = 20
    _T20 = VTABLE<Stack+>
    _T21 = (_T20 + _T19)
    _T22 = *(_T21 + 0)
    *(_T18 + 0) = _T22
    *(_T18 + 4) = _T1
    _T23 = 7
    _T24 = *(_T18 + 0)
    parm _T18
    parm _T23
    call _T24
    _T25 = 8
    parm _T25
    _T26 = call _Alloc
    _T27 = 20
    _T28 = VTABLE<Stack+>
    _T29 = (_T28 + _T27)
    _T30 = *(_T29 + 0)
    *(_T26 + 0) = _T30
    *(_T26 + 4) = _T1
    _T31 = 4
    _T32 = *(_T26 + 0)
    parm _T26
    parm _T31
    call _T32
    _T33 = 8
    parm _T33
    _T34 = call _Alloc
    _T35 = 12
    _T36 = VTABLE<Stack+>
    _T37 = (_T36 + _T35)
    _T38 = *(_T37 + 0)
    *(_T34 + 0) = _T38
    *(_T34 + 4) = _T1
    _T39 = *(_T34 + 0)
    parm _T34
    _T40 = call _T39
    parm _T40
    call _PrintInt
    _T41 = " "
    parm _T41
    call _PrintString
    _T42 = 8
    parm _T42
    _T43 = call _Alloc
    _T44 = 16
    _T45 = VTABLE<Stack+>
    _T46 = (_T45 + _T44)
    _T47 = *(_T46 + 0)
    *(_T43 + 0) = _T47
    *(_T43 + 4) = _T1
    _T48 = *(_T43 + 0)
    parm _T43
    _T49 = call _T48
    parm _T49
    call _PrintInt
    _T50 = " "
    parm _T50
    call _PrintString
    _T51 = 8
    parm _T51
    _T52 = call _Alloc
    _T53 = 16
    _T54 = VTABLE<Stack+>
    _T55 = (_T54 + _T53)
    _T56 = *(_T55 + 0)
    *(_T52 + 0) = _T56
    *(_T52 + 4) = _T1
    _T57 = *(_T52 + 0)
    parm _T52
    _T58 = call _T57
    parm _T58
    call _PrintInt
    _T59 = " "
    parm _T59
    call _PrintString
    _T60 = 8
    parm _T60
    _T61 = call _Alloc
    _T62 = 16
    _T63 = VTABLE<Stack+>
    _T64 = (_T63 + _T62)
    _T65 = *(_T64 + 0)
    *(_T61 + 0) = _T65
    *(_T61 + 4) = _T1
    _T66 = *(_T61 + 0)
    parm _T61
    _T67 = call _T66
    parm _T67
    call _PrintInt
    _T68 = " "
    parm _T68
    call _PrintString
    _T69 = 8
    parm _T69
    _T70 = call _Alloc
    _T71 = 12
    _T72 = VTABLE<Stack+>
    _T73 = (_T72 + _T71)
    _T74 = *(_T73 + 0)
    *(_T70 + 0) = _T74
    *(_T70 + 4) = _T1
    _T75 = *(_T70 + 0)
    parm _T70
    _T76 = call _T75
    parm _T76
    call _PrintInt
    return

main:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = 24
    _T3 = VTABLE<Stack+>
    _T4 = (_T3 + _T2)
    _T5 = *(_T4 + 0)
    *(_T1 + 0) = _T5
    _T6 = *(_T1 + 0)
    parm _T1
    call _T6
    return

