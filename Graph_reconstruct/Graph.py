from collections import deque
import queue
import csv
import os
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('--graph_dir', dest = 'data_dir',type=str, help='folder to restore _graph.txt')
parser.add_argument('--vocab_dir', dest='vocab_dir', type=str, help='folder to restore vocab_map_for_slice2vec.csv')
args = parser.parse_args()
if not args.vocab_dir.endswith('/'):
    vocab_dir = args.vocab_dir+'/'
else:
    vocab_dir = args.vocab_dir

def load_vocabulary():
    with open(vocab_dir+"vocab_map_for_slice2vec.csv",'r') as csv_file:
        reader = csv.reader(csv_file)
        vocabulary = [row[1] for row in reader]
    return vocabulary

def write_stack_to_file(trace_stack, writer):
    if len(trace_stack) ==0:
        return
    sentence = list()
    for unit in trace_stack:
        # print(unit)
        graph_id =int(unit[:unit.index(":")])
        truncated = unit[unit.index(":")+1:]
        node_id = int(truncated[:truncated.index(":")])
        tokens = super_graph.graphs[graph_id].vertices[node_id].get_mark()
        for token in tokens:
            sentence.append(vocabulary.index(token))


        writer.writerow(sentence)

    #writer.write("\n-----------------------\n")


class Vertex:
    def __init__(self, unique_id, u):
        self.node_id = unique_id
        self.unit = str(unique_id) + ":" + u
        self.is_constant = False
        self.successors = list()
        self.predecessors = list()

    def __lt__(self, other):
        return self.node_id < other.node_id

    def add_predecessor(self, v):
        if v not in self.predecessors:
            self.predecessors.append(v)
            self.predecessors.sort()

    def add_successor(self, v):
        if v not in self.successors:
            self.successors.append(v)
            self.successors.sort()

    def get_mark(self):
        if "invoke" not in self.unit:
            if "=" not in self.unit:
                return []
            else:
                r_value = self.unit[self.unit.index("=") + 1:]
                if '"' in r_value or self.isInt(r_value):
                    if r_value in vocabulary:
                        return [r_value]
                return []

        else:
            tokens = []
            API = self.unit[self.unit.index("<"): self.unit.rindex(")>(") + 2]

            if API in vocabulary:
                tokens.append(API)

            argTable = self.unit[self.unit.rindex(")>(") + 3:self.unit.rindex(")")]
            args = argTable.split(",")
            for arg in args:
                if '"' in arg or self.isInt(arg):

                    if arg in vocabulary:
                        tokens.append(arg)
            return tokens

    def isInt(self,s):
        try:
            int(s)
            return True
        except ValueError:
            return False



class Graph:

    def __init__(self,unique_id):
        self.graph_id = unique_id
        self.vertices = {}
        self.connected_graph = {}
        self.entry_to = list()
        self.to_exit = list()
        self.callers = list()

    def set_slice_name(self, s):
        self.slice_name = s


    def add_vertex(self, vertex):
        if isinstance(vertex, Vertex) and vertex.node_id not in self.vertices:
            self.vertices[vertex.node_id] = vertex
            vertex.unit = str(self.graph_id) + ":" + vertex.unit
            return True
        else:
            return False

    def add_edge(self, u, v):
        if u in self.vertices.values() and v in self.vertices.values():
            for key, value in self.vertices.items():
                if key == u.node_id:
                    value.add_successor(v)
                if key == v.node_id:
                    value.add_predecessor(u)

            return True
        else:
            return False

    def add_connected_graph(self, n, graph_list):
        if n not in self.connected_graph:
            self.connected_graph[n] = graph_list
        for callee in graph_list:
            if callee in super_graph.graphs.keys():
                super_graph.graphs[callee].add_caller(self.graph_id)
            else:
                new_graph = Graph(callee)
                super_graph.add_graph(current_graph)

    def add_caller(self, n):
        if n not in self.callers:
            self.callers.append(n)

    def set_is_entry(self, is_entry):
        self.is_entry_graph = is_entry

    # A function used by DFS
    def DFSUtil(self, v, length, trace_stack, callsite_stack):

        # Mark the current node as visited
        # and print it

        # Recur for all the vertices
        # adjacent to this vertex
        copied_callsite_stack = callsite_stack.copy()
        if length <= 0:

            write_stack_to_file(trace_stack, writer)
            return

        if v in self.to_exit and "return" in self.vertices[v].unit:
            if copied_callsite_stack:
                last_callsite = copied_callsite_stack.pop()
                back_graph = super_graph.graphs[last_callsite.graph_id]
                for i in back_graph.vertices[last_callsite.node_id].successors:
                    back_graph.DFSUtil(i.node_id, length, trace_stack, copied_callsite_stack)
            else:
                if len(self.vertices[v].successors) != 0:
                    print("Node: " + self.vertices[v].unit)
                    raise Exception("Sorry, no numbers below zero")
                else:
                    write_stack_to_file(trace_stack, writer)
                    return
        if v in self.to_exit and "return" not in self.vertices[v].unit and len(self.vertices[v].successors)==0:
            write_stack_to_file(trace_stack, writer)
            return

        for i in self.vertices[v].successors:
            if i.unit not in trace_stack:
                if i.node_id in self.connected_graph.keys():

                    new_callsite = callsite(self.graph_id, i.node_id)
                    if new_callsite not in copied_callsite_stack:
                        copied_callsite_stack.append(new_callsite)
                        for g in self.connected_graph[i.node_id]:
                            super_graph.graphs[g].extract_traces(length, trace_stack, copied_callsite_stack)
                    else:
                        print("avoid recursive callsite stack")
                        return


                else:
                    tokens = i.get_mark()
                    if tokens:

                        trace_stack.append(i.unit)
                        self.DFSUtil(i.node_id, length - 1, trace_stack, copied_callsite_stack)
                        trace_stack.pop()
                    else:
                        self.DFSUtil(i.node_id, length, trace_stack, copied_callsite_stack)
            else:
                print("Avoid recursive")
                print(trace_stack)
                print("Graph_id: {}, node_id: {}".format(self.graph_id, v))
                for callsite_ in callsite_stack:
                    print(callsite_.graph_id, callsite_.node_id)

                return

    # The function to do DFS traversal. It uses
    # recursive DFSUtil()
    def extract_traces(self, length, trace_stack, callsite_stack):

        copied_callsite_stack = callsite_stack.copy()
        for start in self.entry_to:
            start_node = self.vertices[start]

            self.DFSUtil(start, length, trace_stack, copied_callsite_stack)
        if len(self.entry_to) == 0:
            # new start, but with the callsite stack
            for node_id, node in self.vertices.items():
                if len(node.predecessors) ==0 and node_id not in self.entry_to:
                    write_stack_to_file(trace_stack,writer)
                    new_trace_stack = deque()
                    if node_id in self.connected_graph.keys():
                        new_callsite = callsite(self.graph_id, node_id)
                        if new_callsite not in copied_callsite_stack:
                            copied_callsite_stack.append(new_callsite)
                            if node.get_mark():
                                new_trace_stack.append(node.unit)
                            for g in self.connected_graph[node_id]:
                                super_graph.graphs[g].extract_traces(10, new_trace_stack, copied_callsite_stack)
                        else:
                            print("Avoid recursive call")
                            return
                    else:
                        if node.get_mark():
                            new_trace_stack.append(node.unit)
                            self.DFSUtil(node_id, 10, new_trace_stack, copied_callsite_stack)
                        else:
                            self.DFSUtil(node_id, 10, new_trace_stack, copied_callsite_stack)










class callsite:
    def __init__(self, graph_id, node_id):
        self.graph_id = graph_id
        self.node_id = node_id

    def __eq__(self, other):
        """Override the default Equals behavior"""
        return self.graph_id == other.graph_id and self.node_id == other.node_id



class Super_graph:
    graphs = {}
    start_point = queue.Queue()

    def add_graph(self, graph):
        if isinstance(graph, Graph) and graph.graph_id not in self.graphs:
            self.graphs[graph.graph_id] = graph

    def add_new_start_point(self, callsite):
        self.start_point.put(callsite)

    '''def next_trace(self, length):
        while not self.start_point.empty():
            new_start = self.start_point.get()
            start_graph = self.graphs[new_start.graph_id]
            node = start_graph.vertices[new_start.node_id]
            trace_stack = deque()
            mark_stack = deque()
            callsite_stack = deque()
            trace_stack.append(node.unit)
            mark_stack.append(True)
            start_graph.DFSUtil(node_id, length, trace_stack, mark_stack, callsite_stack)'''

    def extract_traces(self, length):

        for key, value in self.graphs.items():
            if value.is_entry_graph:
                trace_stack = deque()
                callsite_stack = deque()
                value.extract_traces(length, trace_stack, callsite_stack)
            #else:
            #    for node_id, node in value.vertices.items():
            #        if len(node.predecessors) ==0 and node_id not in value.entry_to:
            #            trace_stack = deque()
             #           callsite_stack = deque()
             #           value.extract_traces(length, trace_stack,callsite_stack)



if not args.data_dir.endswith('/'):
    data_path = args.data_dir+'/'
else:
    data_path = args.data_dir
csv_file = open(data_path+"dataflow_traces.csv", "w")
writer = csv.writer(csv_file)
vocabulary = load_vocabulary()


files = os.listdir(data_path)
for file in files:
    if os.path.isfile(data_path+file) and file.endswith("_graph.txt"):
        print("processing "+file+"\n");
        super_graph = Super_graph()
        with open(data_path + file, 'r') as f:
            for row in f:
                row = row.strip()
                # print("row"+row)
                if "Graph Id: " in row and " | Slice: " in row:
                    current_graph_id = int(row[row.index("Graph Id: ") + 10:row.index(" | Slice:")])
                    slice_name = row[row.index("| Slice: Slice{") + 9:]
                    if current_graph_id not in super_graph.graphs.keys():
                        current_graph = Graph(current_graph_id)
                        current_graph.set_slice_name(slice_name)
                        super_graph.add_graph(current_graph)
                    else:
                        current_graph = super_graph.graphs[current_graph]
                        current_graph.set_slice_name(slice_name)

                if "Node Id: " in row and " | Unit: " in row:
                    node_id = int(row[row.index("Node Id: ") + 8:row.index(" | Unit: ")])
                    unit_name = row[row.index(" | Unit: ") + 9:]  # virtualinvoke <API()>("AES") make sure it will be depart in two nodes later and the "AES" will be use as start point to extract trace
                    node = Vertex(node_id, unit_name)
                    current_graph.add_vertex(node)

                if ": [" in row and "]" in row and "Connected: " not in row and "Entry To:" not in row and "To Exit:" not in row:
                    node_id = int(row[:row.index(": [")])
                    start_node = current_graph.vertices[node_id]
                    edge_nodes_list = row[row.index(": [") + 3: -1]
                    if edge_nodes_list.endswith(","):
                        edge_nodes_list = edge_nodes_list[:-1]
                    if len(edge_nodes_list) == 0:
                        continue

                    edge_nodes_list = edge_nodes_list.split(",")
                    try:
                        edge_list = [int(i) for i in edge_nodes_list]
                        for i in edge_list:
                            end_node = current_graph.vertices[i]
                            current_graph.add_edge(start_node, end_node)
                    except:
                        print("edge_list: {}".format(len(edge_nodes_list)))

                if ": [" in row and "]" in row and "Connected: " in row:
                    node_id = int(row[row.index("Connected: ") + 11:row.index(": [")])
                    connected_graphs_list = row[row.index(": [") + 3:-1]
                    if connected_graphs_list.endswith(","):
                        connected_graphs_list = connected_graphs_list[:-1]
                    if len(connected_graphs_list) == 0:
                        continue
                    connected_graphs_list = connected_graphs_list.split(",")
                    graph_list = [int(i) for i in connected_graphs_list]
                    current_graph.add_connected_graph(node_id, graph_list)
                if row.startswith("Entry To: "):
                    entry_list = row[row.index("Entry To: [") + 11:-1]
                    if entry_list.endswith(","):
                        entry_list = entry_list[:-1]
                    if len(entry_list) == 0:
                        continue
                    entry_list = entry_list.split(",")
                    try:
                        current_graph.entry_to = [int(i) for i in entry_list]
                    except:
                        print("entry_list {}".format(len(entry_list)))
                if row.startswith("To Exit: "):
                    exit_list = row[row.index("To Exit: [") + 10:-1]
                    if exit_list.endswith(","):
                        exit_list = exit_list[:-1]
                    if len(exit_list) == 0:
                        continue
                    exit_list = exit_list.split(",")
                    current_graph.to_exit = [int(i) for i in exit_list]
                if row.startswith("is Entry Graph: "):
                    mark = row[row.index("is Entry Graph: ") + 16:]
                    if mark == "true":
                        current_graph.set_is_entry(True)
                    else:
                        current_graph.set_is_entry(False)
        super_graph.extract_traces(10)
csv_file.close()