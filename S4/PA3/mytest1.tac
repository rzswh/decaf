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
    _T1 = call FUNCTION<Main.f>
    return _T1

FUNCTION<Main.f>:
    _T1 = 0
    _T0 = _T1
    _T3 = 1
    _T2 = _T3
    _T5 = (_T0 + _T2)
    _T4 = _T5
    return _T2

main:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = 8
    _T3 = VTABLE<Main+>
    _T4 = (_T3 + _T2)
    _T5 = *(_T4 + 0)
    *(_T1 + 0) = _T5
    _T6 = *(_T1 + 0)
    parm _T1
    _T7 = call _T6
    parm _T7
    call _PrintInt
    return

