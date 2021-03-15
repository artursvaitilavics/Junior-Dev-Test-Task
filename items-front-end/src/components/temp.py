
import bpy


class TRANSFORM_OT_clear_orientations(bpy.types.Operator):
bl_idname = 'transform.clear_orientations'
bl_label = 'Clear Transform Orientations'

def execute(self, context):
    for t in context.scene.orientations:
        context.space_data.transform_orientation = t.name
        override = {
            'context': context,
            'area': context.area,
            'window': context.window,
            'screen': context.screen,
            'scene': context.scene,
            'region': context.region,
            'name': t.name
        }
        bpy.ops.transform.delete_orientation(override)
    return {"FINISHED"}


def register():
bpy.utils.register_class(TRANSFORM_OT_clear_orientations)
hotkey = bpy.context.window_manager.keyconfigs.active.keymaps['3D View'].keymap_items.new
hotkey('transform.clear_orientations', type='T',
        shift=True, ctrl=True, value='PRESS')
