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
    FUNCTION<Main+.f>

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

FUNCTION<Main+.f>:
    parm _T1
    _T2 = call FUNCTION<Main.f>
    return _T2

FUNCTION<Main.f>:
    _T4 = 1
    _T3 = _T4
    _T7 = 0
    _T8 = (_T0 == _T7)
    if (_T8 == 0) branch _L1
    branch _L2
_L1:
_L2:
    return _T3

main:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = 8
    _T3 = VTABLE<Main+>
    _T4 = (_T3 + _T2)
    _T5 = *(_T4 + 0)
    *(_T1 + 0) = _T5
    _T6 = 233
    _T7 = *(_T1 + 0)
    parm _T1
    parm _T6
    _T8 = call _T7
    parm _T8
    call _PrintInt
    return

