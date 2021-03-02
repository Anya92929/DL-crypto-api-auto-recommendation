package com.SocketMobile.ScanAPICore;

import com.SocketMobile.ScanAPI.SktScanErrors;

public class SktList {
    private Node m_Head = null;
    private Node m_Tail = null;
    private int m_nCount = 0;

    public static class Position {
        /* access modifiers changed from: private */
        public Node _current;

        Position(Node node) {
            this._current = node;
        }

        public Position() {
            this._current = null;
        }

        public boolean IsValid() {
            return this._current != null;
        }

        public Position Copy() {
            return new Position(this._current);
        }

        public Object GetNext() {
            Object data = this._current.Data;
            this._current = this._current.Next;
            return data;
        }

        public Object GetPrev() {
            Object data = this._current.Data;
            this._current = this._current.Previous;
            return data;
        }

        public Object Get() {
            return this._current.Data;
        }
    }

    protected class Node {
        Object Data;
        Node Next;
        Node Previous;

        public Node(Object Data2) {
            this.Data = Data2;
        }

        public Node(Object Data2, Node nextnode, Node Previousnode) {
            this.Data = Data2;
            this.Next = nextnode;
            this.Previous = Previousnode;
        }
    }

    public long AddHead(Object pData) {
        long result = 0;
        Node New = new Node(pData);
        if (New == null) {
            result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            if (this.m_Head != null) {
                this.m_Head.Previous = New;
            }
            New.Next = this.m_Head;
            New.Previous = null;
            this.m_Head = New;
            if (this.m_Tail == null) {
                this.m_Tail = New;
            }
            this.m_nCount++;
        }
        return result;
    }

    public long AddTail(Object Data) {
        long result = 0;
        Node New = new Node(Data);
        if (New == null) {
            result = -2;
        }
        if (SktScanErrors.SKTSUCCESS(result)) {
            if (this.m_Tail != null) {
                this.m_Tail.Next = New;
            }
            New.Previous = this.m_Tail;
            New.Next = null;
            this.m_Tail = New;
            if (this.m_Head == null) {
                this.m_Head = New;
            }
            this.m_nCount++;
        }
        return result;
    }

    public long RemoveHead(Object[] Data) {
        Node Remove = this.m_Head;
        if (Remove == null) {
            return -6;
        }
        Data[0] = Remove.Data;
        RemoveNode(Remove);
        this.m_Head = Remove.Next;
        if (this.m_Head == null) {
            this.m_Tail = null;
        }
        return 0;
    }

    public long RemoveTail(Object[] Data) {
        Node Remove = this.m_Tail;
        if (Remove == null) {
            return -6;
        }
        Data[0] = Remove.Data;
        RemoveNode(Remove);
        this.m_Tail = Remove.Previous;
        if (this.m_Tail == null) {
            this.m_Head = null;
        }
        return 0;
    }

    public Position GetHeadPosition() {
        return new Position(this.m_Head);
    }

    public Position GetTailPosition() {
        return new Position(this.m_Tail);
    }

    public long GetAt(Position position, Object[] Data) {
        long result = 0;
        if (position == null) {
            result = -17;
        }
        if (!SktScanErrors.SKTSUCCESS(result)) {
            return result;
        }
        Node Current = position._current;
        if (Current == null) {
            return -17;
        }
        Data[0] = Current.Data;
        return result;
    }

    public long RemoveAt(Position position, Object[] Data) {
        long result = 0;
        Node current = null;
        if (position != null) {
            current = position._current;
        } else {
            result = -17;
        }
        if (!SktScanErrors.SKTSUCCESS(result)) {
            return result;
        }
        if (current == null) {
            return -17;
        }
        Data[0] = current.Data;
        RemoveNode(current);
        if (this.m_Head == current) {
            this.m_Head = current.Next;
        }
        if (this.m_Tail == current) {
            this.m_Tail = current.Previous;
        }
        return result;
    }

    public long FindIndex(long ulIndex, Position position) {
        long Result = 0;
        Position currentPosition = GetHeadPosition();
        long internalIndex = 0;
        if (position == null) {
            Result = -18;
        }
        if (!SktScanErrors.SKTSUCCESS(Result)) {
            return Result;
        }
        Node unused = position._current = null;
        while (true) {
            if (!currentPosition.IsValid()) {
                break;
            } else if (internalIndex == ulIndex) {
                Node unused2 = position._current = currentPosition._current;
                break;
            } else {
                internalIndex++;
                currentPosition.GetNext();
            }
        }
        if (position._current == null) {
            return -17;
        }
        return Result;
    }

    public long InsertBefore(Position position, Object data) {
        long Result = 0;
        if (position == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Node current = position._current;
            Node newNode = new Node(data);
            if (newNode == null) {
                Result = -2;
            }
            if (SktScanErrors.SKTSUCCESS(Result) && current == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                newNode.Previous = current.Previous;
                if (newNode.Previous != null) {
                    newNode.Previous.Next = newNode;
                }
                newNode.Next = current;
                current.Previous = newNode;
                newNode.Data = data;
                if (this.m_Head == current) {
                    this.m_Head = newNode;
                }
                this.m_nCount++;
            }
        }
        return Result;
    }

    public long InsertAfter(Position position, Object data) {
        long Result = 0;
        if (position == null) {
            Result = -18;
        }
        if (SktScanErrors.SKTSUCCESS(Result)) {
            Node current = position._current;
            Node newNode = new Node(data);
            if (newNode == null) {
                Result = -2;
            }
            if (SktScanErrors.SKTSUCCESS(Result) && current == null) {
                Result = -18;
            }
            if (SktScanErrors.SKTSUCCESS(Result)) {
                newNode.Next = current.Next;
                if (newNode.Next != null) {
                    newNode.Next.Previous = newNode;
                }
                newNode.Previous = current;
                current.Next = newNode;
                newNode.Data = data;
                if (this.m_Tail == current) {
                    this.m_Tail = newNode;
                }
                this.m_nCount++;
            }
        }
        return Result;
    }

    private void RemoveNode(Node Remove) {
        if (Remove.Next != null) {
            Remove.Next.Previous = Remove.Previous;
        }
        if (Remove.Previous != null) {
            Remove.Previous.Next = Remove.Next;
        }
        this.m_nCount--;
    }

    /* access modifiers changed from: package-private */
    public int GetCount() {
        return this.m_nCount;
    }

    public static boolean Test() {
        boolean bResult = true;
        SktList list = new SktList();
        Object[] pInt = new Object[1];
        if (list.GetCount() != 0) {
            bResult = false;
        }
        if (bResult && list.AddHead("1") != 0) {
            bResult = false;
        }
        if (bResult && list.RemoveHead(pInt) != 0) {
            bResult = false;
        }
        if (bResult) {
            if (pInt[0] != "1") {
                bResult = false;
            } else if (list.GetCount() != 0) {
                bResult = false;
            }
        }
        if (bResult && list.AddHead("5") != 0) {
            bResult = false;
        }
        if (bResult && list.RemoveTail(pInt) != 0) {
            bResult = false;
        }
        if (bResult) {
            if (pInt[0] != "5") {
                bResult = false;
            } else if (list.GetCount() != 0) {
                bResult = false;
            }
        }
        if (bResult && list.AddTail("8") != 0) {
            bResult = false;
        }
        if (bResult && list.RemoveTail(pInt) != 0) {
            bResult = false;
        }
        if (bResult) {
            if (pInt[0] != "8") {
                bResult = false;
            } else if (list.GetCount() != 0) {
                bResult = false;
            }
        }
        if (bResult && list.AddTail("8") != 0) {
            bResult = false;
        }
        if (bResult && list.RemoveHead(pInt) != 0) {
            bResult = false;
        }
        if (bResult) {
            if (pInt[0] != "8") {
                bResult = false;
            } else if (list.GetCount() != 0) {
                bResult = false;
            }
        }
        if (bResult && list.RemoveHead(pInt) != -6) {
            bResult = false;
        }
        if (bResult && list.RemoveTail(pInt) != -6) {
            bResult = false;
        }
        if (bResult && list.RemoveAt((Position) null, pInt) != -17) {
            bResult = false;
        }
        if (bResult && list.GetHeadPosition().IsValid()) {
            bResult = false;
        }
        if (bResult) {
            for (int i = 0; i < 100; i++) {
                if (bResult && list.AddTail(String.valueOf(i)) != 0) {
                    bResult = false;
                }
                if (!bResult) {
                    break;
                }
            }
        }
        if (bResult && list.GetCount() != 100) {
            bResult = false;
        }
        if (bResult) {
            Position pos = list.GetHeadPosition();
            int i2 = 0;
            while (true) {
                if (!pos.IsValid()) {
                    break;
                }
                Position removePos = pos.Copy();
                String data = (String) pos.GetNext();
                if (removePos._current == pos._current) {
                    bResult = false;
                    break;
                }
                String data2 = String.valueOf(i2);
                if (!data.equals(data2)) {
                    bResult = false;
                    break;
                } else if (!((String) removePos.Get()).equals(data2)) {
                    bResult = false;
                    break;
                } else {
                    if (list.RemoveAt(removePos, pInt) != 0) {
                        bResult = false;
                    }
                    if (!bResult) {
                        break;
                    } else if (!String.valueOf(i2).equals((String) pInt[0])) {
                        bResult = false;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (bResult && list.GetCount() != 0) {
                bResult = false;
            }
            if (bResult) {
                SktDebug.DBGSKT_MSG(1, "SktList Test pass");
            }
        }
        return bResult;
    }
}
