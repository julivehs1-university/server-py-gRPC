# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: Tracker.proto
# Protobuf Python Version: 5.26.1
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\rTracker.proto\"\x07\n\x05\x45mpty\"\x19\n\x05Robot\x12\x10\n\x08robot_id\x18\x01 \x02(\x05\"#\n\tRobotList\x12\x16\n\x06robots\x18\x01 \x03(\x0b\x32\x06.Robot\"5\n\x08Position\x12\t\n\x01x\x18\x01 \x02(\x02\x12\t\n\x01y\x18\x02 \x02(\x02\x12\x13\n\x0borientation\x18\x03 \x02(\x02\x32S\n\x07Tracker\x12\"\n\x0bGetPosition\x12\x06.Robot\x1a\t.Position\"\x00\x12$\n\x0cGetAllRobots\x12\x06.Empty\x1a\n.RobotList\"\x00')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'Tracker_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  DESCRIPTOR._loaded_options = None
  _globals['_EMPTY']._serialized_start=17
  _globals['_EMPTY']._serialized_end=24
  _globals['_ROBOT']._serialized_start=26
  _globals['_ROBOT']._serialized_end=51
  _globals['_ROBOTLIST']._serialized_start=53
  _globals['_ROBOTLIST']._serialized_end=88
  _globals['_POSITION']._serialized_start=90
  _globals['_POSITION']._serialized_end=143
  _globals['_TRACKER']._serialized_start=145
  _globals['_TRACKER']._serialized_end=228
# @@protoc_insertion_point(module_scope)
