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
    FUNCTION<Node.insert_fix>

VTABLE<Node+>:
    NULL
    "Node+"
    FUNCTION<Node+.insert_fix>

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

FUNCTION<Node+.insert_fix>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 8)
    call _T4
    return

FUNCTION<Node.insert_fix>:
_L2:
    _T3 = *(_T1 + 16)
    _T4 = *(_T3 + 4)
    if (_T4 == 0) branch _L1
    _T6 = *(_T1 + 16)
    _T5 = _T6
    _T8 = *(_T6 + 16)
    _T7 = _T8
    _T10 = *(_T8 + 12)
    _T11 = (_T10 == _T6)
    _T9 = _T11
    if (_T11 == 0) branch _L3
    _T13 = *(_T7 + 12)
    _T12 = _T13
    branch _L4
_L3:
    _T14 = *(_T7 + 20)
    _T12 = _T14
_L4:
    _T15 = *(_T12 + 4)
    if (_T15 == 0) branch _L5
    _T16 = 0
    *(_T5 + 4) = _T16
    branch _L6
_L5:
    _T17 = *(_T5 + 12)
    _T18 = (_T17 == _T1)
    _T19 = (_T18 != _T9)
    if (_T19 == 0) branch _L7
    _T1 = _T5
_L7:
_L6:
    branch _L2
_L1:
    return

main:
    _T1 = 1
    _T3 = 2
    parm _T3
    call _PrintInt
    parm _T1
    call _PrintInt
    return

