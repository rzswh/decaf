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
    FUNCTION<Main.call1>

VTABLE<Main+>:
    NULL
    "Main+"
    FUNCTION<Main+.call1>
    FUNCTION<Main+.call2>

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

FUNCTION<Main+.call1>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    _T4 = call _T3
    return _T4

FUNCTION<Main.call1>:
    _T1 = 1
    return _T1

FUNCTION<Main+.call2>:
    _T1 = call FUNCTION<Main.call2>
    return _T1

FUNCTION<Main.call2>:
    _T0 = 2
    return _T0

main:
    _T1 = call FUNCTION<Main.new>
    _T0 = _T1
    _T3 = 8
    parm _T3
    _T4 = call _Alloc
    _T5 = 8
    _T6 = VTABLE<Main+>
    _T7 = (_T6 + _T5)
    _T8 = *(_T7 + 0)
    *(_T4 + 0) = _T8
    *(_T4 + 4) = _T0
    _T9 = *(_T4 + 0)
    parm _T4
    _T10 = call _T9
    _T12 = 4
    parm _T12
    _T13 = call _Alloc
    _T14 = 12
    _T15 = VTABLE<Main+>
    _T16 = (_T15 + _T14)
    _T17 = *(_T16 + 0)
    *(_T13 + 0) = _T17
    _T18 = *(_T13 + 0)
    parm _T13
    _T19 = call _T18
    _T21 = 10
    _T22 = 0
    _T23 = (_T21 < _T22)
    if (_T23 == 0) branch _L1
    _T24 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T24
    call _PrintString
    call _Halt
_L1:
    _T25 = 1
    _T26 = (_T21 + _T25)
    _T27 = 4
    _T28 = (_T26 * _T27)
    parm _T28
    _T29 = call _Alloc
    *(_T29 + 0) = _T21
    _T30 = (_T29 + _T28)
    _T30 = (_T30 - _T27)
_L3:
    _T31 = (_T30 != _T29)
    if (_T31 == 0) branch _L2
    *(_T30 + 0) = _T22
    _T30 = (_T30 - _T27)
    branch _L3
_L2:
    _T32 = (_T29 + _T27)
    _T20 = _T32
    _T34 = 0
    _T35 = *(_T20 - 4)
    _T36 = 0
    _T37 = (_T34 < _T36)
    _T38 = (_T34 >= _T35)
    _T39 = (_T37 || _T38)
    if (_T39 == 0) branch _L4
    _T40 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T40
    call _PrintString
    call _Halt
_L4:
    return

