from collections import deque
import queue
import csv
import os
import sys
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('--data_dir', dest = 'data_dir',type=str, help='folder to output dataflow_paths.txt')
parser.add_argument('--vocab_dir', dest='vocab_dir', type=str, help='folder to restore vocab_map_for_slice2vec.csv')
parser.add_argument('--file', dest='file',type=str)
args = parser.parse_args()
if not args.vocab_dir.endswith('/'):
    vocab_dir = args.vocab_dir+'/'
else:
    vocab_dir = args.vocab_dir


def load_vocabulary():
    with open(vocab_dir+"vocab_map_for_slice2vec.csv",'r') as csv_file:
        reader = csv.reader(csv_file)
        vocabulary = [row[1] for row in reader]
        vocabulary = [int(word) if isInt(word) else word for word in vocabulary]
        print("is 1024 in vocabulary: ", end=' ')
        print(1024 in vocabulary)
            

    return vocabulary

def isInt(s):
        try:
            int(s)
            return True
        except ValueError:
            return False

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
        self.predecessors_info = dict()
        self.successors_info = dict()

    def analyze_pred_edge_info(self,pred):
        return

    def analyze_succ_edge_info(self,succ):
        #info = self.unit[]
        return

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

    def get_mark(self,debug_flag=False):

        if debug_flag:
            print("unit:")
            print(self.unit)

        if "invoke" not in self.unit:
            if "=" not in self.unit:
                return ()
            else:
                r_value = self.unit[self.unit.index("=") + 1:]
                if '"' in r_value:
                    if r_value in vocabulary:
                        return (r_value,)
                elif isInt(r_value):
                    r_int = int(r_value)
                    if r_int in vocabulary:
                        return (r_int,)
                elif "newarray" in r_value:
                    try:
                        r_int = int(r_value[r_value.index('[')+1:r_value.index(']')])
                        if r_int in vocabulary:
                            return (r_int,)
                    except:
                        return ()

                return ()

        else:
            tokens = []
            API = self.unit[self.unit.index("<"): self.unit.rindex(")>(") + 2]

            if API in vocabulary:
                tokens.append(API)

            argTable = self.unit[self.unit.rindex(")>(") + 3:self.unit.rindex(")")]
            if debug_flag:
                print("argTable")
                print(argTable)
            args = argTable.split(",")
            
            for arg in args:
                if arg.startswith(" "):              
                    arg = arg[1:]
                if debug_flag:
                    print(arg)
                    print("isInt? ", end = ' ')
                    print(isInt(arg))
                    print("is in vocabulary?", end=' ')
                    print(arg in vocabulary)
                    print("is 0? ", end=' ')
                    print(arg==0)
                if '"' in arg or isInt(arg):
                    if isInt(arg):
                        arg = int(arg)
                    if arg in vocabulary:
                        tokens.append(arg)
            if debug_flag:
                print("return tokens")
                print(tokens)
            return tuple(tokens)

    

    def __repr__(self):
        return "Vertex{{node id: {}|unit: {}}}".format(self.node_id,self.unit)



class Graph:

    def __init__(self,unique_id):
        self.graph_id = unique_id
        self.vertices = {}
        self.connected_graph = {}
        self.entry_to = list()
        self.to_exit = list()
        self.callers = list()
        self.is_summarized = False
        self.is_starting_slice = False
        self.summaries = set() # connected to the caller
        self.new_paths = set() # new path, not connected to the caller E.g. "SHA-512" --> MessageDigest.getInstance()

    def set_slice_name(self, s):
        self.slice_name = s

    def set_starting_slice(self):
        self.is_starting_slice = True

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
                super_graph.add_graph(new_graph)
                super_graph.graphs[callee].add_caller(self.graph_id)

    def add_caller(self, n):
        if n not in self.callers:
            self.callers.append(n)

    def set_is_entry(self, is_entry):
        self.is_entry_graph = is_entry

    def print_graph(self):
        print("-------Info of Graph {}".format(self.graph_id))
        for vk in self.vertices:
            print("Node {} ".format(vk))
            print("\tPred node: ", end=' ')
            for pred in self.vertices[vk].predecessors:
                print(pred.node_id, end=' ')
            print("\n\tSucc node: ", end=' ')
            for succ in self.vertices[vk].successors:
                print(succ.node_id, end=' ')
            print("\n")
        print('--------------')
    def is_starting_slice_according_exit(self,debug_flag = False):
        if debug_flag:
            print("To exit: ",end=' ')
            print(self.to_exit)

        if len(self.to_exit)<1:

            return False
        elif len(self.to_exit)==1:
            sc_nid = self.to_exit[0]
            sc_unit = self.vertices[sc_nid].unit
            sc_unit = sc_unit[sc_unit.index(':')+1:]
            if debug_flag:
                print("Unit of exit node: ")
                print(sc_unit)
            if 'invoke' not in sc_unit:
                return False
            else:
                sc_api = sc_unit[sc_unit.index('<'):sc_unit.rindex('>(')+1]
                if debug_flag:
                    print("sc_api: ")
                    print(sc_api)
                    print("Is in vocabulary: ", end =' ')
                    print(sc_api in vocabulary)
                if sc_api in vocabulary:
                    return True
                else:
                    return False

    def summarize(self, debug_flag=True):
        if debug_flag:
            print("---summarize graph {}-----".format(self.graph_id))
        self.print_graph()
        self.is_summarized = True
        if self.graph_id == 78:
            print(self.is_starting_slice_according_exit(True))
        if self.is_starting_slice_according_exit():
            self.set_starting_slice()
        if self.graph_id == 71:
            print(self.vertices[1].unit)
        for n_id in self.to_exit:
            #print("Backward from node {}".format(n_id))
            visited = {key: False for key in self.vertices}
            node = self.vertices[n_id]
            path = deque()
            self.dfs_summarize(node,visited,path)
        if debug_flag:
            print("---Finish summarizing graph {}-----".format(self.graph_id))

    def collect_one_path(self,path, debug_flag=False):
        path_mark = {i: "" for i in range(len(path))}
        stack_process = [0]
        
        while stack_process:
            
            current_pid = stack_process.pop()
            if current_pid == -1 or current_pid == -2:
                if current_pid == -2:
                    has_path = True
                # end of the path, store it in self.summaries
                
                if debug_flag:
                    print("Debug info:")
                    print("path mark:")
                    print(path_mark)

                one_path = [path_mark[i] for i in range(len(path))]
                one_path_token = tuple()
                for i in range(len(one_path)):

                    p_token = one_path[i]
                    if debug_flag:
                        print("debug info")
                        print(p_token)
                        print(one_path_token)
                    if p_token:
                    
                        assert isinstance(p_token, tuple)
                    
                        if p_token[0] == 'summary':
                            if p_token[1]:
                                one_path_token = one_path_token + p_token[1]
                        elif p_token[0] =='normal':
                            if len(p_token[1]) == 1:
                                one_path_token = one_path_token + p_token[1]
                            elif len(p_token[1])>1:
                                t_api = p_token[1][0]
                                for t in p_token[1]:
                                    if isinstance(t, int) or '"' in t:
                                        #args, new path
                                        print("writing A path to new_paths:", end=' ')
                                        print(one_path_token+(t_api, t))
                                        self.new_paths.add(one_path_token+(t_api,t))

                                if current_pid != -2 or  i!=len(one_path)-1:

                                # if this is not an end, the t_api still need to connect other successors   
                                    one_path_token = one_path_token + (t_api,)
                                    print("one_path_token: ")
                                    print(one_path_token)
                                else:
                                    has_path = False
                        

                if current_pid == -1:
                    if one_path_token:
                        print("writing a summary to summaries:", end=' ')
                        print(one_path_token)
                        self.summaries.add(one_path_token)
                else:
                    if has_path and one_path_token:
                    
                        print("writing one path to new_paths:", end=' ')
                        print(one_path_token)
                        self.new_paths.add(one_path_token)
                
                continue
            if isinstance(current_pid,tuple):
                #a summary to be processed
                pid = current_pid[0]
                summary = current_pid[1]
                path_mark[pid]=('summary',summary)
                continue
                    
                

            current_pn = path[current_pid]
            current_pnode = self.vertices[current_pn]

            # connected node
            if current_pn in self.connected_graph:
                possible_argstr = current_pnode.get_mark()
                callee_ids = self.connected_graph[current_pn]
                
                for callee_id in callee_ids:
                    
                    # if no summary in callee

                    if not super_graph.graphs[callee_id].summaries:

                        path_mark[current_pid] = ('summary', ())
                        if current_pid+1<len(path):
                            stack_process.append(current_pid+1)
                        else:
                            if path[current_pid] in self.entry_to:
                                stack_process.append(-1) # end mark, in summaries (reach callers)
                            else:
                                stack_process.append(-2) # end mark, in new_paths (not reach callers)

                    for summary in super_graph.graphs[callee_id].summaries:

                        # add each summary in the stack to be processed later
                        if current_pid+1<len(path):
                            
                            stack_process.append(current_pid+1)
                            
                        else:
                            if path[current_pid] in self.entry_to:
                                stack_process.append(-1) # end mark, in summaries (reach callers)
                            else:
                                if not possible_argstr:
                                    stack_process.append(-2) # end mark, in new_paths (not reach callers)                         
                        stack_process.append((current_pid,summary))
                        if possible_argstr:
                            for argstr in possible_argstr:
                                stack_process.append(-2)
                                stack_process.append((current_pid,summary+(argstr,)))


                    for new_p in super_graph.graphs[callee_id].new_paths:
                        # add each new paths to this trace, no need to resume
                        stack_process.append(-2)
                        stack_process.append((current_pid,new_p))
            #normal node                    
            else:
                
                # process current node (normal node)
                marks = current_pnode.get_mark()
                
                path_mark[current_pid]=('normal', marks)
                if current_pid+1<len(path):
                    stack_process.append(current_pid+1)
                else:
                    if path[current_pid] in self.entry_to:
                        stack_process.append(-1) # end mark, in summaries (reach callers)
                    else:
                        stack_process.append(-2) # end mark, in new_paths (not reach callers)
                

                

    
    def dfs_summarize(self, v, visited,path, debug_flag=True):
        # Mark current node as visitied
        visited[v.node_id]=True
        # add current node to the path       
        path.append(v.node_id)

        if not v.predecessors:
            # reach the back end of the path                                  
            #print("Graph {}".format(self.graph_id))
            #print("****************************")
            if debug_flag:
                print("Collect path: ")
                for p in path:
                    print(p, end = ' ')
                print("\n")
            
            self.collect_one_path(path)
            
            

            #print("\n**************************")


        for pred in v.predecessors:
            if not visited[pred.node_id]:

                self.dfs_summarize(pred, visited,path)
            else:
                ''' 
                E.g. 1-->1-->0.
                backward from 1 to 1, to 1.
                '''
                if debug_flag:
                    print("..........Cycle!...........") 
                    print("Graph {}".format(self.graph_id))
                    for p in path:
                        print(p, end = ' ')
                    print("\n...........................")

        path.pop()






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


class Data_instance:
    def __init__(self, gid, label):
        self.label = label
        self.graph_id = gid
        self.paths = []
    def add_path(self, path, callers):
        self.paths.append([path,callers])

    def write_to_file(self, csv_writer):
        label_id = vocabulary.index(self.label)
        paths_id = []
        for p in self.paths:
            path_id = (vocabulary.index(token) for token in p[0])
            paths_id.append(path_id)

        csv_writer.writerow(["Label", label_id])
        csv_writer.writerow(["Starting graph", self.graph_id])
        for path_id in paths_id:
            csv_writer.writerow(path_id)
        print("----In graph {}, paths for label {}".format(self.graph_id,self.label))
        cnt = 0
        
        for p in self.paths:
            print("Path {}: ".format(cnt), end=' ')
            for token in p[0]:
                print(token, end=' ')
            print('\n')
            print("Caller stack: {}".format(p[1]))
            cnt += 1




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

    def print_call_graph(self, logger):
        logger.write("====current call graph======\n")
        for g_id in self.graphs:
            logger.write("graph id {}:\n".format(g_id))
            logger.write("Callees: \n")
            for connector, callees in self.graphs[g_id].connected_graph.items():
                logger.write("{}\n".format(callees))
            logger.write("Callers: \n")
            logger.write("{}\n".format(self.graphs[g_id].callers))
        logger.write("============================\n")
    def summarize_local_graphs(self):
        # summarize the local graphs in the super graph as the bottom-up form
        # calculate the initial callee degree of each graph
        gra_id_degree = {}
        for gra_id, gra in self.graphs.items():
            gra_id_degree[gra_id] = 0
            for connected_node_id, gra_list in gra.connected_graph.items():
                gra_id_degree[gra_id] += len(gra_list)
        
        debug_log.write("Initial degree of graphs {}\n".format(gra_id_degree))
        debug_log.write("Initial call graph: \n")
        for g_id in sorted(gra_id_degree.keys(), key=lambda k: gra_id_degree[k]):
            debug_log.write("Callees of graph {}\n".format(g_id))
            debug_log.write("{}\n".format(self.graphs[g_id].connected_graph))
        # sort the graphs to summary
        while(gra_id_degree):
            sorted_graph_pool = sorted(gra_id_degree.items(), key=lambda item: item[1])
            
            if sorted_graph_pool[0][1] !=0:
                # select the one who has the most callers.
                sorted_graph_pool = sorted(gra_id_degree.items(), key=lambda item: len(self.graphs[item[0]].callers))[::-1]
                debug_log.write("According caller degree:\n")
                for g_id, v in sorted_graph_pool:
                    debug_log.write("graph_id {}\n".format(g_id))
                    debug_log.write("callers: {}\n".format(self.graphs[g_id].callers))
            gra_id, callee_degree = sorted_graph_pool[0]
            print("summarizing graph {}, callee degree is {}".format(gra_id, callee_degree))
            debug_log.write("summarizing graph {}, callee degree is {}\n".format(gra_id, callee_degree))
            self.graphs[gra_id].summarize()
            del gra_id_degree[gra_id]
            debug_log.write("--callers of graph {}:\n".format(gra_id))
            for caller_id in self.graphs[gra_id].callers:
                # in case that recursion call loop that A call B, B call A, we summarize A then B, the caller has been deleted in the graph_id_degree
                debug_log.write("caller graph: {}\n".format(caller_id))
                if caller_id in gra_id_degree:
                    # in case that caller A calls B multiple times. 
                    gra_id_degree[caller_id] -= sum([1 for v in self.graphs[caller_id].connected_graph.values() for j in v if j==gra_id])
            debug_log.write("Updated degree of graphs {}\n".format(gra_id_degree))
            debug_log.write("Updated call graph: \n")
            for g_id in sorted(gra_id_degree.keys(), key=lambda k: gra_id_degree[k]):
                debug_log.write("Callees of graph {}\n".format(g_id))
                for connector, g_list in self.graphs[g_id].connected_graph.items():
                    g_list = [i for i in g_list if i in gra_id_degree]
                    debug_log.write("{}\n".format(g_list))


            #print("graph id: {}".format(k))
            #print("callee degree: {}".format(v))
    
    def collect_paths_from_callers_past(self, ds, current_g, callers, MAX_l_PATH, MAX_n_PATH):
        #current graph
        if current_g.graph_id in callers:
            # caller cycle, end tracing here
            one_path = ()
            for p_i in path:
                assert isinstance(p_i, tuple)
                one_path = one_path + p_i
            ds.add_path(one_path, callers.copy())
            return
        callers.append(current_g.graph_id)
        for new_p in current_g.new_paths:
            # end of a path tracing
            path.append(new_p)
            one_path = ()
            for p_i in path:
                assert isinstance(p_i, tuple)
                one_path = one_path + p_i
            ds.add_path(one_path, callers.copy())
            path.pop()

            
        for summary in current_g.summaries:
            path.append(summary)

            for caller_id in current_g.callers:
                caller_g = super_graph.graphs[caller_id]
                self.collect_paths_from_callers(ds, caller_g, path, callers, MAX_l_PATH, MAX_n_PATH)
            path.pop()

            if not current_g.callers:
                # no caller found, end tracing
                one_path = ()
                for p_i in path:
                    assert isinstance(p_i, tuple)
                    one_path = one_path + p_i
                ds.add_path(one_path,callers.copy())
        callers.pop()

    def collect_paths_from_callers(self, ds, current_g, callers, MAX_l_PATH, MAX_n_PATH):
        #current graph
        if current_g.graph_id in callers:
            # caller cycle, end tracing here
            for path in current_g.summaries:
                ds.add_path(path,callers.copy())
            for path in current_g.new_paths:
                ds.add_path(path,callers.copy())
            return
        callers.append(current_g.graph_id)
        

            
        
        for caller_id in current_g.callers:
            caller_g = super_graph.graphs[caller_id]
            self.collect_paths_from_callers(ds, caller_g, callers, MAX_l_PATH, MAX_n_PATH)
            

        if not current_g.callers:
            # no caller found, end tracing
            for path in current_g.summaries.union(current_g.new_paths):
                ds.add_path(path,callers.copy())
            
        callers.pop()



    def generate_paths_to_label(self, MAX_l_PATH, MAX_n_PATH, i_ds, csv_writer):
        for gid,g in self.graphs.items():
            if g.is_starting_slice:
                assert len(g.to_exit) <= 1
                
                if len(g.to_exit)==1:
                    sc_nid = g.to_exit[0]
                    sc = g.vertices[sc_nid].get_mark()
                    label = ''
                    callers = []
                    for sc_t in sc:
                        if isinstance(sc_t, str) and sc_t.startswith("<"):
                            label = sc_t
                    if label:
                        ds = Data_instance(gid, label)
                        i_ds += 1
                        self.collect_paths_from_callers(ds, g, callers, MAX_l_PATH, MAX_n_PATH)
                        ds.write_to_file(csv_writer)
                    else:
                        print("SC statement:")
                        print(g.vertices[sc_nid].unit)
                        raise ValueError

        return i_ds



    def extract_traces(self, length):

        for key, value in self.graphs.items():
            if value.is_entry_graph:
                starting_callsite = value.to_exit
                try:
                    assert len(starting_callsite) == 1
                    writer.writerow(["For callsite {} in Graph {}".format(value.vertices[starting_callsite[0]],value.graph_id)])
                except:
                    print("!!!Fix later")
                    print("To_exit of graph {}:".format(value.graph_id))
                    print(starting_callsite)
                    if len(starting_callsite) !=0:
                        raise AssertionError
                
                trace_stack = deque()
                callsite_stack = deque()
                
                value.extract_traces(length, trace_stack, callsite_stack)
            #else:
            #    for node_id, node in value.vertices.items():
            #        if len(node.predecessors) ==0 and node_id not in value.entry_to:
            #            trace_stack = deque()
             #           callsite_stack = deque()
             #           value.extract_traces(length, trace_stack,callsite_stack)
    def summarizing_paths(self):

        for key, value in self.graphs.items():
            if value.is_starting_slice:
                starting_criterion = value.to_exit
                try:
                    assert len(starting_criterion) == 1
                    writer.writerow(["Paths for SC {} in Graph {}".format(value.vertices[starting_criterion[0]],value.graph_id)])
                    print("Paths for SC {} in Graph {}".format(value.vertices[starting_criterion[0]],value.graph_id))
                except:
                    print("!!!Fix later")
                    print("To_exit of graph {}:".format(value.graph_id))
                    print(starting_criterion)
                    if len(starting_criterion) !=0:
                        raise AssertionError
                #for sc in starting_criterion:


if not args.data_dir.endswith('/'):
    data_path = args.data_dir+'/'
else:
    data_path = args.data_dir
csv_file = open(data_path+"dataflow_paths.csv", "w")


writer = csv.writer(csv_file)
vocabulary = load_vocabulary()
debug_log = open("./debug_log.txt",'w')



#files = os.listdir(data_path)
#for file in files:
file = args.file
if os.path.isfile(file) and file.endswith("_graph.txt"):
    writer.writerow(["Parsed info for "+file])
    print("processing "+file+"\n");
    super_graph = Super_graph()
    with open(file, 'r') as f:
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
                    current_graph = super_graph.graphs[current_graph_id]
                    current_graph.set_slice_name(slice_name)
            if "Node Id: " in row and " | Unit: " in row:
                node_id = int(row[row.index("Node Id: ") + 8:row.index(" | Unit: ")])
                unit_name = row[row.index(" | Unit: ") + 9:]  # virtualinvoke <API()>("AES") make sure it will be depart in two nodes later and the "AES" will be use as start point to extract trace
                node = Vertex(node_id, unit_name)
                current_graph.add_vertex(node)

            if ": [" in row and "]" in row and "Connected: " not in row and "Entry To:" not in row and "To Exit:" not in row:
                try:
                    node_id = int(row[:row.index(": [")])
                except:
                    print(row)
                    raise ValueError
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
                    raise ValueError

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
            #if row.startswith("is Starting slice: "):
                #flag = row[row.index("is Starting slice: ")+19:]
                #if flag == "true":
                    #current_graph.set_starting_slice()

    super_graph.print_call_graph(debug_log)
    super_graph.summarize_local_graphs()

    i_ds = super_graph.generate_paths_to_label(10, 10, 0,writer)
    print("Generate {} data instance".format(i_ds))
    #super_graph.summarizing_paths()
    #super_graph.extract_traces(10)
    #writer.writerow("Finished parsing "+file)
    #print("finished parsing "+file)
csv_file.close()
debug_log.close()