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

VTABLE<Maths>:
    NULL
    "Maths"

VTABLE<Maths+>:
    NULL
    "Maths+"
    FUNCTION<Maths+.abs>
    FUNCTION<Maths+.log>
    FUNCTION<Maths+.max>
    FUNCTION<Maths+.min>
    FUNCTION<Maths+.pow>

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<Maths.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Maths>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Main.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Maths+.abs>:
    parm _T1
    _T2 = call FUNCTION<Maths.abs>
    return _T2

FUNCTION<Maths.abs>:
    _T1 = 0
    _T2 = (_T0 >= _T1)
    if (_T2 == 0) branch _L1
    return _T0
    branch _L2
_L1:
    _T3 = - _T0
    return _T3
_L2:
    return

FUNCTION<Maths+.pow>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Maths.pow>
    return _T3

FUNCTION<Maths.pow>:
    _T3 = 1
    _T2 = _T3
    _T5 = 0
    _T4 = _T5
_L4:
    _T6 = (_T4 < _T1)
    if (_T6 == 0) branch _L3
    _T7 = (_T2 * _T0)
    _T2 = _T7
    _T8 = 1
    _T9 = (_T4 + _T8)
    _T4 = _T9
    branch _L4
_L3:
    return _T2

FUNCTION<Maths+.log>:
    parm _T1
    _T2 = call FUNCTION<Maths.log>
    return _T2

FUNCTION<Maths.log>:
    _T1 = 1
    _T2 = (_T0 < _T1)
    if (_T2 == 0) branch _L5
    _T3 = 1
    _T4 = - _T3
    return _T4
_L5:
    _T6 = 0
    _T5 = _T6
_L7:
    _T7 = 1
    _T8 = (_T0 > _T7)
    if (_T8 == 0) branch _L6
    _T9 = 1
    _T10 = (_T5 + _T9)
    _T5 = _T10
    _T11 = 2
    _T12 = 0
    _T13 = (_T11 == _T12)
    if (_T13 == 0) branch _L8
    _T14 = "Decaf runtime error: Division by zero error\n"
    parm _T14
    call _PrintString
    call _Halt
_L8:
    _T15 = (_T0 / _T11)
    _T0 = _T15
    branch _L7
_L6:
    return _T5

FUNCTION<Maths+.max>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Maths.max>
    return _T3

FUNCTION<Maths.max>:
    _T2 = (_T0 > _T1)
    if (_T2 == 0) branch _L9
    return _T0
    branch _L10
_L9:
    return _T1
_L10:
    return

FUNCTION<Maths+.min>:
    parm _T1
    parm _T2
    _T3 = call FUNCTION<Maths.min>
    return _T3

FUNCTION<Maths.min>:
    _T2 = (_T0 < _T1)
    if (_T2 == 0) branch _L11
    return _T0
    branch _L12
_L11:
    return _T1
_L12:
    return

main:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = 8
    _T3 = VTABLE<Maths+>
    _T4 = (_T3 + _T2)
    _T5 = *(_T4 + 0)
    *(_T1 + 0) = _T5
    _T6 = 1
    _T7 = - _T6
    _T8 = *(_T1 + 0)
    parm _T1
    parm _T7
    _T9 = call _T8
    parm _T9
    call _PrintInt
    _T10 = "\n"
    parm _T10
    call _PrintString
    _T11 = 4
    parm _T11
    _T12 = call _Alloc
    _T13 = 24
    _T14 = VTABLE<Maths+>
    _T15 = (_T14 + _T13)
    _T16 = *(_T15 + 0)
    *(_T12 + 0) = _T16
    _T17 = 2
    _T18 = 3
    _T19 = *(_T12 + 0)
    parm _T12
    parm _T17
    parm _T18
    _T20 = call _T19
    parm _T20
    call _PrintInt
    _T21 = "\n"
    parm _T21
    call _PrintString
    _T22 = 4
    parm _T22
    _T23 = call _Alloc
    _T24 = 12
    _T25 = VTABLE<Maths+>
    _T26 = (_T25 + _T24)
    _T27 = *(_T26 + 0)
    *(_T23 + 0) = _T27
    _T28 = 16
    _T29 = *(_T23 + 0)
    parm _T23
    parm _T28
    _T30 = call _T29
    parm _T30
    call _PrintInt
    _T31 = "\n"
    parm _T31
    call _PrintString
    _T32 = 4
    parm _T32
    _T33 = call _Alloc
    _T34 = 16
    _T35 = VTABLE<Maths+>
    _T36 = (_T35 + _T34)
    _T37 = *(_T36 + 0)
    *(_T33 + 0) = _T37
    _T38 = 1
    _T39 = 2
    _T40 = *(_T33 + 0)
    parm _T33
    parm _T38
    parm _T39
    _T41 = call _T40
    parm _T41
    call _PrintInt
    _T42 = "\n"
    parm _T42
    call _PrintString
    _T43 = 4
    parm _T43
    _T44 = call _Alloc
    _T45 = 20
    _T46 = VTABLE<Maths+>
    _T47 = (_T46 + _T45)
    _T48 = *(_T47 + 0)
    *(_T44 + 0) = _T48
    _T49 = 1
    _T50 = 2
    _T51 = *(_T44 + 0)
    parm _T44
    parm _T49
    parm _T50
    _T52 = call _T51
    parm _T52
    call _PrintInt
    _T53 = "\n"
    parm _T53
    call _PrintString
    return

