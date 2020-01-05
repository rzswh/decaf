VTABLE<Array$>:
    NULL
    "Array$"
    FUNCTION<Array$.Array$getLength>

VTABLE<Fibonacci>:
    NULL
    "Fibonacci"
    FUNCTION<Fibonacci.get>

VTABLE<Fibonacci+>:
    NULL
    "Fibonacci+"
    FUNCTION<Fibonacci+.get>

VTABLE<LambdaCaller$>:
    NULL
    "LambdaCaller$"

VTABLE<Main>:
    NULL
    "Main"

VTABLE<Main+>:
    NULL
    "Main+"

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<Fibonacci.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Fibonacci>
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
    _T1 = 0
    _T0 = _T1
    _T3 = call FUNCTION<Fibonacci.new>
    _T2 = _T3
_L2:
    _T4 = 10
    _T5 = (_T0 < _T4)
    if (_T5 == 0) branch _L1
    _T6 = 8
    parm _T6
    _T7 = call _Alloc
    _T8 = 8
    _T9 = VTABLE<Fibonacci+>
    _T10 = (_T9 + _T8)
    _T11 = *(_T10 + 0)
    *(_T7 + 0) = _T11
    *(_T7 + 4) = _T2
    _T12 = *(_T7 + 0)
    parm _T7
    parm _T0
    _T13 = call _T12
    parm _T13
    call _PrintInt
    _T14 = "\n"
    parm _T14
    call _PrintString
    _T15 = 1
    _T16 = (_T0 + _T15)
    _T0 = _T16
    branch _L2
_L1:
    return

FUNCTION<Fibonacci+.get>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 8)
    _T5 = call _T4
    return _T5

FUNCTION<Fibonacci.get>:
    _T2 = 2
    _T3 = (_T1 < _T2)
    if (_T3 == 0) branch _L3
    _T4 = 1
    return _T4
_L3:
    _T5 = 8
    parm _T5
    _T6 = call _Alloc
    _T7 = 8
    _T8 = VTABLE<Fibonacci+>
    _T9 = (_T8 + _T7)
    _T10 = *(_T9 + 0)
    *(_T6 + 0) = _T10
    *(_T6 + 4) = _T0
    _T11 = 1
    _T12 = (_T1 - _T11)
    _T13 = *(_T6 + 0)
    parm _T6
    parm _T12
    _T14 = call _T13
    _T15 = 8
    parm _T15
    _T16 = call _Alloc
    _T17 = 8
    _T18 = VTABLE<Fibonacci+>
    _T19 = (_T18 + _T17)
    _T20 = *(_T19 + 0)
    *(_T16 + 0) = _T20
    *(_T16 + 4) = _T0
    _T21 = 2
    _T22 = (_T1 - _T21)
    _T23 = *(_T16 + 0)
    parm _T16
    parm _T22
    _T24 = call _T23
    _T25 = (_T14 + _T24)
    return _T25

