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
    FUNCTION<Node.delete_fix>

VTABLE<Node+>:
    NULL
    "Node+"
    FUNCTION<Node+.delete_fix>

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

FUNCTION<Main.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Node+.delete_fix>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 8)
    call _T4
    return

FUNCTION<Node.delete_fix>:
    _T3 = *(_T1 + 12)
    _T5 = *(_T1 + 20)
    _T4 = _T5
    _T8 = *(_T1 + 16)
    _T9 = *(_T8 + 12)
    _T10 = (_T9 == _T1)
    if (_T10 == 0) branch _L1
    _T4 = _T3
_L1:
    *(_T1 + 12) = _T3
    *(_T1 + 20) = _T4
    return

main:
    return

