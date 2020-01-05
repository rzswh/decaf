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

main:
    _T1 = 2
    _T3 = 3
    _T5 = 1
    _T7 = "Hello THU"
    parm _T1
    call _PrintInt
    _T8 = "\n"
    parm _T8
    call _PrintString
    parm _T3
    call _PrintInt
    _T9 = "\n"
    parm _T9
    call _PrintString
    _T10 = (_T1 + _T3)
    parm _T10
    call _PrintInt
    _T11 = "\n"
    parm _T11
    call _PrintString
    _T12 = (_T1 * _T3)
    parm _T12
    call _PrintInt
    _T13 = "\n"
    parm _T13
    call _PrintString
    parm _T5
    call _PrintBool
    _T14 = "\n"
    parm _T14
    call _PrintString
    parm _T7
    call _PrintString
    _T15 = "\n"
    parm _T15
    call _PrintString
    return

