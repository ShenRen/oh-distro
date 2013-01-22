#ifndef __maps_bot_renderer_h__
#define __maps_bot_renderer_h__

/**
 * Linking: `pkg-config --libs maps-renderer`
 * @{
 */

#include <lcm/lcm.h>
#include <bot_vis/bot_vis.h>
#include <bot_frames/bot_frames.h>

void maps_add_renderer_to_viewer(BotViewer* viewer, int priority, lcm_t* lcm, BotParam* param, BotFrames* frames);

#endif

