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

VTABLE<Queue>:
    NULL
    "Queue"
    FUNCTION<Queue.DeQueue>
    FUNCTION<Queue.EnQueue>
    FUNCTION<Queue.Init>

VTABLE<Queue+>:
    NULL
    "Queue+"
    FUNCTION<Queue+.DeQueue>
    FUNCTION<Queue+.EnQueue>
    FUNCTION<Queue+.Init>

VTABLE<QueueItem>:
    NULL
    "QueueItem"
    FUNCTION<QueueItem.GetData>
    FUNCTION<QueueItem.GetNext>
    FUNCTION<QueueItem.GetPrev>
    FUNCTION<QueueItem.Init>
    FUNCTION<QueueItem.SetNext>
    FUNCTION<QueueItem.SetPrev>

VTABLE<QueueItem+>:
    NULL
    "QueueItem+"
    FUNCTION<QueueItem+.GetData>
    FUNCTION<QueueItem+.GetNext>
    FUNCTION<QueueItem+.GetPrev>
    FUNCTION<QueueItem+.Init>
    FUNCTION<QueueItem+.SetNext>
    FUNCTION<QueueItem+.SetPrev>

FUNCTION<Array$.Array$getLength>:
    _T1 = *(_T0 + 4)
    _T2 = *(_T1 - 4)
    return _T2

FUNCTION<QueueItem.new>:
    _T0 = 16
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<QueueItem>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Queue.new>:
    _T0 = 12
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Queue>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<Main.new>:
    _T0 = 4
    parm _T0
    _T1 = call _Alloc
    _T2 = VTABLE<Main>
    *(_T1 + 0) = _T2
    return _T1

FUNCTION<QueueItem+.Init>:
    _T4 = *(_T0 + 4)
    parm _T4
    parm _T1
    parm _T2
    parm _T3
    _T5 = *(_T4 + 0)
    _T6 = *(_T5 + 20)
    call _T6
    return

FUNCTION<QueueItem.Init>:
    *(_T0 + 4) = _T1
    *(_T0 + 8) = _T2
    *(_T2 + 12) = _T0
    *(_T0 + 12) = _T3
    *(_T3 + 8) = _T0
    return

FUNCTION<QueueItem+.GetData>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    _T4 = call _T3
    return _T4

FUNCTION<QueueItem.GetData>:
    _T1 = *(_T0 + 4)
    return _T1

FUNCTION<QueueItem+.GetNext>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 12)
    _T4 = call _T3
    return _T4

FUNCTION<QueueItem.GetNext>:
    _T1 = *(_T0 + 8)
    return _T1

FUNCTION<QueueItem+.GetPrev>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 16)
    _T4 = call _T3
    return _T4

FUNCTION<QueueItem.GetPrev>:
    _T1 = *(_T0 + 12)
    return _T1

FUNCTION<QueueItem+.SetNext>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 24)
    call _T4
    return

FUNCTION<QueueItem.SetNext>:
    *(_T0 + 8) = _T1
    return

FUNCTION<QueueItem+.SetPrev>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 28)
    call _T4
    return

FUNCTION<QueueItem.SetPrev>:
    *(_T0 + 12) = _T1
    return

FUNCTION<Queue+.Init>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 16)
    call _T3
    return

FUNCTION<Queue.Init>:
    _T1 = call FUNCTION<QueueItem.new>
    *(_T0 + 4) = _T1
    _T2 = *(_T0 + 4)
    _T3 = 8
    parm _T3
    _T4 = call _Alloc
    _T5 = 20
    _T6 = VTABLE<QueueItem+>
    _T7 = (_T6 + _T5)
    _T8 = *(_T7 + 0)
    *(_T4 + 0) = _T8
    *(_T4 + 4) = _T2
    _T9 = 0
    _T10 = *(_T0 + 4)
    _T11 = *(_T0 + 4)
    _T12 = *(_T4 + 0)
    parm _T4
    parm _T9
    parm _T10
    parm _T11
    call _T12
    return

FUNCTION<Queue+.EnQueue>:
    _T2 = *(_T0 + 4)
    parm _T2
    parm _T1
    _T3 = *(_T2 + 0)
    _T4 = *(_T3 + 12)
    call _T4
    return

FUNCTION<Queue.EnQueue>:
    _T3 = call FUNCTION<QueueItem.new>
    _T4 = 8
    parm _T4
    _T5 = call _Alloc
    _T6 = 20
    _T7 = VTABLE<QueueItem+>
    _T8 = (_T7 + _T6)
    _T9 = *(_T8 + 0)
    *(_T5 + 0) = _T9
    *(_T5 + 4) = _T3
    _T10 = *(_T0 + 4)
    _T11 = 8
    parm _T11
    _T12 = call _Alloc
    _T13 = 12
    _T14 = VTABLE<QueueItem+>
    _T15 = (_T14 + _T13)
    _T16 = *(_T15 + 0)
    *(_T12 + 0) = _T16
    *(_T12 + 4) = _T10
    _T17 = *(_T12 + 0)
    parm _T12
    _T18 = call _T17
    _T19 = *(_T0 + 4)
    _T20 = *(_T5 + 0)
    parm _T5
    parm _T1
    parm _T18
    parm _T19
    call _T20
    return

FUNCTION<Queue+.DeQueue>:
    _T1 = *(_T0 + 4)
    parm _T1
    _T2 = *(_T1 + 0)
    _T3 = *(_T2 + 8)
    _T4 = call _T3
    return _T4

FUNCTION<Queue.DeQueue>:
    _T2 = *(_T0 + 4)
    _T3 = 8
    parm _T3
    _T4 = call _Alloc
    _T5 = 16
    _T6 = VTABLE<QueueItem+>
    _T7 = (_T6 + _T5)
    _T8 = *(_T7 + 0)
    *(_T4 + 0) = _T8
    *(_T4 + 4) = _T2
    _T9 = *(_T4 + 0)
    parm _T4
    _T10 = call _T9
    _T11 = *(_T0 + 4)
    _T12 = (_T10 == _T11)
    if (_T12 == 0) branch _L1
    _T13 = "Queue Is Empty"
    parm _T13
    call _PrintString
    _T14 = 0
    return _T14
    branch _L2
_L1:
    _T16 = *(_T0 + 4)
    _T17 = 8
    parm _T17
    _T18 = call _Alloc
    _T19 = 16
    _T20 = VTABLE<QueueItem+>
    _T21 = (_T20 + _T19)
    _T22 = *(_T21 + 0)
    *(_T18 + 0) = _T22
    *(_T18 + 4) = _T16
    _T23 = *(_T18 + 0)
    parm _T18
    _T24 = call _T23
    _T25 = 8
    parm _T25
    _T26 = call _Alloc
    _T27 = 8
    _T28 = VTABLE<QueueItem+>
    _T29 = (_T28 + _T27)
    _T30 = *(_T29 + 0)
    *(_T26 + 0) = _T30
    *(_T26 + 4) = _T24
    _T31 = *(_T26 + 0)
    parm _T26
    _T32 = call _T31
    _T1 = _T32
    _T33 = 8
    parm _T33
    _T34 = call _Alloc
    _T35 = 16
    _T36 = VTABLE<QueueItem+>
    _T37 = (_T36 + _T35)
    _T38 = *(_T37 + 0)
    *(_T34 + 0) = _T38
    *(_T34 + 4) = _T24
    _T39 = *(_T34 + 0)
    parm _T34
    _T40 = call _T39
    _T41 = 8
    parm _T41
    _T42 = call _Alloc
    _T43 = 24
    _T44 = VTABLE<QueueItem+>
    _T45 = (_T44 + _T43)
    _T46 = *(_T45 + 0)
    *(_T42 + 0) = _T46
    *(_T42 + 4) = _T40
    _T47 = 8
    parm _T47
    _T48 = call _Alloc
    _T49 = 12
    _T50 = VTABLE<QueueItem+>
    _T51 = (_T50 + _T49)
    _T52 = *(_T51 + 0)
    *(_T48 + 0) = _T52
    *(_T48 + 4) = _T24
    _T53 = *(_T48 + 0)
    parm _T48
    _T54 = call _T53
    _T55 = *(_T42 + 0)
    parm _T42
    parm _T54
    call _T55
    _T56 = 8
    parm _T56
    _T57 = call _Alloc
    _T58 = 12
    _T59 = VTABLE<QueueItem+>
    _T60 = (_T59 + _T58)
    _T61 = *(_T60 + 0)
    *(_T57 + 0) = _T61
    *(_T57 + 4) = _T24
    _T62 = *(_T57 + 0)
    parm _T57
    _T63 = call _T62
    _T64 = 8
    parm _T64
    _T65 = call _Alloc
    _T66 = 28
    _T67 = VTABLE<QueueItem+>
    _T68 = (_T67 + _T66)
    _T69 = *(_T68 + 0)
    *(_T65 + 0) = _T69
    *(_T65 + 4) = _T63
    _T70 = 8
    parm _T70
    _T71 = call _Alloc
    _T72 = 16
    _T73 = VTABLE<QueueItem+>
    _T74 = (_T73 + _T72)
    _T75 = *(_T74 + 0)
    *(_T71 + 0) = _T75
    *(_T71 + 4) = _T24
    _T76 = *(_T71 + 0)
    parm _T71
    _T77 = call _T76
    _T78 = *(_T65 + 0)
    parm _T65
    parm _T77
    call _T78
_L2:
    return _T1

main:
    _T2 = call FUNCTION<Queue.new>
    _T0 = _T2
    _T3 = 8
    parm _T3
    _T4 = call _Alloc
    _T5 = 16
    _T6 = VTABLE<Queue+>
    _T7 = (_T6 + _T5)
    _T8 = *(_T7 + 0)
    *(_T4 + 0) = _T8
    *(_T4 + 4) = _T2
    _T9 = *(_T4 + 0)
    parm _T4
    call _T9
    _T10 = 0
    _T1 = _T10
_L4:
    _T11 = 10
    _T12 = (_T1 < _T11)
    if (_T12 == 0) branch _L3
    _T13 = 8
    parm _T13
    _T14 = call _Alloc
    _T15 = 12
    _T16 = VTABLE<Queue+>
    _T17 = (_T16 + _T15)
    _T18 = *(_T17 + 0)
    *(_T14 + 0) = _T18
    *(_T14 + 4) = _T0
    _T19 = *(_T14 + 0)
    parm _T14
    parm _T1
    call _T19
    _T20 = 1
    _T21 = (_T1 + _T20)
    _T1 = _T21
    branch _L4
_L3:
    _T22 = 0
    _T1 = _T22
_L6:
    _T23 = 4
    _T24 = (_T1 < _T23)
    if (_T24 == 0) branch _L5
    _T25 = 8
    parm _T25
    _T26 = call _Alloc
    _T27 = 8
    _T28 = VTABLE<Queue+>
    _T29 = (_T28 + _T27)
    _T30 = *(_T29 + 0)
    *(_T26 + 0) = _T30
    *(_T26 + 4) = _T0
    _T31 = *(_T26 + 0)
    parm _T26
    _T32 = call _T31
    parm _T32
    call _PrintInt
    _T33 = " "
    parm _T33
    call _PrintString
    _T34 = 1
    _T35 = (_T1 + _T34)
    _T1 = _T35
    branch _L6
_L5:
    _T36 = "\n"
    parm _T36
    call _PrintString
    _T37 = 0
    _T1 = _T37
_L8:
    _T38 = 10
    _T39 = (_T1 < _T38)
    if (_T39 == 0) branch _L7
    _T40 = 8
    parm _T40
    _T41 = call _Alloc
    _T42 = 12
    _T43 = VTABLE<Queue+>
    _T44 = (_T43 + _T42)
    _T45 = *(_T44 + 0)
    *(_T41 + 0) = _T45
    *(_T41 + 4) = _T0
    _T46 = *(_T41 + 0)
    parm _T41
    parm _T1
    call _T46
    _T47 = 1
    _T48 = (_T1 + _T47)
    _T1 = _T48
    branch _L8
_L7:
    _T49 = 0
    _T1 = _T49
_L10:
    _T50 = 17
    _T51 = (_T1 < _T50)
    if (_T51 == 0) branch _L9
    _T52 = 8
    parm _T52
    _T53 = call _Alloc
    _T54 = 8
    _T55 = VTABLE<Queue+>
    _T56 = (_T55 + _T54)
    _T57 = *(_T56 + 0)
    *(_T53 + 0) = _T57
    *(_T53 + 4) = _T0
    _T58 = *(_T53 + 0)
    parm _T53
    _T59 = call _T58
    parm _T59
    call _PrintInt
    _T60 = " "
    parm _T60
    call _PrintString
    _T61 = 1
    _T62 = (_T1 + _T61)
    _T1 = _T62
    branch _L10
_L9:
    _T63 = "\n"
    parm _T63
    call _PrintString
    return

